package com.basic.util;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.danga.MemCached.MemCachedClient;
import com.schooner.MemCached.MemcachedItem;

public class MemcachedClientSupport {

private static MemCachedClient memCachedClient;

private static Long defaultMaxIdle;

protected static Logger logger = LoggerFactory
        .getLogger(MemcachedClientSupport.class);

public void setDefaultMaxIdle(Long defaultMaxIdl) {
    MemcachedClientSupport.defaultMaxIdle = defaultMaxIdl;
}

public void setMemCachedClient(MemCachedClient memCachedClient) {
    MemcachedClientSupport.memCachedClient = memCachedClient;
    memCachedClient.setPrimitiveAsString(true);
}
/****
 * 获取指定Key的计数器
 * @param enm
 * @param keys
 * @return
 */
public static long getCounter(MemcacheKeyEnum enm,Object... keys){
    long r= memCachedClient.getCounter(generateMemCacheKey(enm,keys));
    logger.debug("读取计数器[key="+generateMemCacheKey(enm,keys)+",value="+r+"]");
    return r;
}


/*****
 * 初始化计数器
 * @param enm
 * @param counter 初始化值
 * @param keys
 * @return
 */
public static void initCounter(MemcacheKeyEnum enm,Long counter,Object... keys){
    boolean r =memCachedClient.storeCounter(generateMemCacheKey(enm,keys),counter);
    logger.debug("初始化计数器[key=]"+generateMemCacheKey(enm,keys)+",value="+counter+",result="+r+"]");
}

/*****
 * 计数器加一
 * @param enm
 * @param keys
 * @return 相加后计数器值
 */
public static long  increment(MemcacheKeyEnum enm,Object... keys){
    return increment(enm,1,keys);
}
/*****
 * 计数器加指定数值
 * @param enm
 * @param incr 加的数
 * @param keys
 * @return 
 */
public static long increment(MemcacheKeyEnum enm,long incr,Object... keys){
    long r= memCachedClient.incr(generateMemCacheKey(enm,keys), incr);
    logger.debug("计数器增长[key="+generateMemCacheKey(enm,keys)+",increment="+incr+",value="+r+"]");
    return r;
}
/****
 * 检验Memcache Key是否存在
 * @param enm
 * @param keys
 * @return
 */
public static boolean checkKeyExists(MemcacheKeyEnum enm,Object... keys){
    return memCachedClient.keyExists(generateMemCacheKey(enm,keys));
}

/**
 * @param enm
 * @param value
 * @param expiryMinute
 *            (过期分钟，不能大于30*24*60)
 * @param keys
 * 
 * [注意] 基本类型，会转换为String
 * @return 是否成功
 */
public static boolean setIntoMemCachedWithMinute(MemcacheKeyEnum enm,
        Object value, long expiryMinute, Object... keys) {
    long expirySecs = expiryMinute * 60;
    if (expirySecs > 2592000) {
        throw new RuntimeException("设置秒数不能大于2592000秒");
    }
    Date expiry = new Date(expirySecs*1000);
    return setIntoMemCached(enm, value, expiry, keys);
}

/**
 * 内部原理是：<br>
 * if (expiry == null) { expiry = new Date(0L); } <br>
 * String cmd = cmdname + " " + key + " " + flags + " " + expiry.getTime() /
 * 1000L + " "; d) <br>
 * <exptime> 过期的时间。 <br>
 * 过期时间，0 为永不过期(但可被服务器算法：LRU 等替换))<br>
 * 可使用 unix 时间戳格式或距离当前时间的秒数，设为秒数时不能大于 2592000（30 天）
 * 
 * [注意] 基本类型，会转换为String
 * @param enm
 * @param value
 * @param expiry
 * @param keys
 * @return
 */
public static boolean setIntoMemCached(MemcacheKeyEnum enm, Object value,
        Date expiry, Object... keys) {
    return memCachedClient.set(generateMemCacheKey(enm,keys), value, expiry);
}

public static boolean setIntoMemCached(MemcacheKeyEnum enm, Object value,
        Object... keys) {
    Date expiry = new Date(defaultMaxIdle);
    return memCachedClient.set(generateMemCacheKey(enm,keys), value, expiry);
}
/*****
 * 获取指定Key的缓存
 * [注意] 基本类型，会转换为String
 * @param enm
 * @param keys
 * @return
 */
public static Object getFromMemCached(MemcacheKeyEnum enm, Object... keys) {
    try {
        return memCachedClient.get(generateMemCacheKey(enm,keys));
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
/******
 * 获取指定Key，对应的值。
 * [注意] 基本类型，会转换为String
 * @param enm 
 * @param keys
 * @return
 */
public static Object getFromMemCachedWithLock(MemcacheKeyEnum enm, Object... keys){
    MemcachedItem casValue  = memCachedClient.gets(generateMemCacheKey(enm,keys));
    if(casValue==null){
        return null;
    }
    return casValue.value;
}
/****
 * 获取指定Key对应的Memcache版本号。
 * @param enm
 * @param keys
 * @return
 */
public static long getCasUniqueFromMemcached(MemcacheKeyEnum enm, Object... keys){
    MemcachedItem casValue  = memCachedClient.gets(generateMemCacheKey(enm,keys));
    if(casValue==null){
        return -1;
    }
    return casValue.casUnique;
}
/****
 * 设置指定值到缓存。
 * 如果给定的版本号，和当前值对应的版本号不一致，则，缓存服务器不会做任何实际操作。
 * @param enm
 * @param value
 * @param expiryMinute 缓存时间，分钟
 * @param casUnique 当前值对应版本号
 * @param keys
 */
public static boolean setIntoMemCachedWithLock(MemcacheKeyEnum enm,
        Object value, int expiryMinute,long casUnique, Object... keys){
    Date expireDate = DateUtils.addMinutes(new Date(), expiryMinute);
    return memCachedClient.cas(generateMemCacheKey(enm,keys), value,expireDate, casUnique);

}

/******
 * 生成Memcache 真实Key
 * @param enm
 * @param keys
 * @return
 */
private static String generateMemCacheKey(MemcacheKeyEnum enm, Object... keys){
    StringBuilder sb = new StringBuilder();
    sb.append(enm.name());
    for (int i = 0; i < keys.length; i++) {
        Object o = keys[i];
        if (o != null) {
            sb.append("_").append(o);
        }
    }
    //memCachedClient.st
    return sb.toString();
}
/****
 * 删除指定Key的缓存
 * @param enm
 * @param keys
 * @return
 */
public static boolean deleteFromMemCached(MemcacheKeyEnum enm,
        Object... keys) {
    return memCachedClient.delete(generateMemCacheKey(enm,keys));
}
}
package com.basic.util;

import java.util.Date;

import javax.servlet.FilterConfig; 
import javax.servlet.ServletContext; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletRequestWrapper; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils; 
import org.springframework.web.context.WebApplicationContext; 
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.danga.MemCached.MemCachedClient;

/** 
* @author william 
* 
*/ 
public class HttpServletRequestMemcacheWrapper extends 
HttpServletRequestWrapper {


MemCachedClient memCachedClient;
private int timeout;

private HttpServletRequest request = null;
private HttpServletResponse response = null;
private ServletContext context = null;

private MemcacheHttpSession session = null;
private String requestedSessionId = null;

public HttpServletRequestMemcacheWrapper(HttpServletRequest request,
        HttpServletResponse response, FilterConfig config) {
    super(request);
    this.request = request;
    this.response = response;
    this.context = config.getServletContext();
    this.timeout = Long.valueOf(config.getInitParameter("sessionTimeout"))
            .intValue();
    WebApplicationContext webApplicationContext = WebApplicationContextUtils
            .getWebApplicationContext(context);
    this.memCachedClient = (MemCachedClient) webApplicationContext
            .getBean("memCachedClient");

    CookieWrapper cookies = new CookieWrapper(request, response);
    this.requestedSessionId = cookies
            .getCookieValue("sessionId");

}

public HttpSession getSession(boolean create) {
    if (session != null && session.getId() != null && session.isValid()) {
        return session;
    }
    session = null;
    // if (requestedSessionId == null) { // SESSION ID IS NOT SPECIFIED
    // if (!create) {
    // return null;
    // }
    // return createNewSession();
    // }

    MemcacheHttpSession memSession = (MemcacheHttpSession) getMemcacheSession(create);
    // if (memSession == null || !(memSession instanceof
    // MemcacheHttpSession)
    // || !memSession.isValid()) {
    // if (!create) {
    // return null;
    // }
    // return createNewSession();
    // }
    session = memSession;

    return session;

}

public HttpSession getSession() {
    return getSession(true);
}

public String getRequestedSessionId() {
    return requestedSessionId;
}

// private HttpSession createNewSession() {
// requestedSessionId = java.util.UUID.randomUUID().toString()
// .replace("-", "");
// String msid = requestedSessionId;
// Object siteId = request.getAttribute("siteId");
// if (siteId != null && !"".equals(siteId)) {
// msid = requestedSessionId + "_" + siteId;
// } else {
// throw new RuntimeException("site id missed!");
// }
//
// // while (memCachedClient.get(id) != null) {
// // requestedSessionId = java.util.UUID.randomUUID().toString();
// // if (siteId != null && !"".equals(siteId)) {
// // id = requestedSessionId + "_" + siteId;
// // }
// // }
//
// MemcacheHttpSession memSession = new MemcacheHttpSession(msid, context,
// memCachedClient, true, this.timeout * 60);
//
// session = memSession;
//
// // Creating a new session cookie based on that session
// CookieWrapper cookies = new CookieWrapper(request, response);
// cookies.addSessionCookie(CookieConstant.SESSION_ID, requestedSessionId,
// true);
// if (logger.isDebugEnabled()) {
// logger.debug("New Session[" + session.getId()
// + "] created to memcache");
// }
//
// return session;
// }

private HttpSession getMemcacheSession(boolean create) {

    CookieWrapper cookies = new CookieWrapper(request, response);
    if (StringUtils.isBlank(requestedSessionId) && create) {
        requestedSessionId = java.util.UUID.randomUUID().toString()
                .replace("-", "");
        cookies.addSessionCookie("sessionId",
                requestedSessionId, true);
    }
    SessionData sessionData = null;
    SessionData sessionData_cart = null;
    if (StringUtils.isNotBlank(requestedSessionId)) {
        String msid = requestedSessionId ;
        if (StringUtils.isNotBlank(msid) && msid.length() > 8) {
            Object ob = memCachedClient.get(msid);
            if (ob != null) {
                sessionData = (SessionData) ob;
            } else {
                if (create) {
                    sessionData = new SessionData(msid, this.timeout * 60);
                    Date expiry = new Date((long) this.timeout * 60 * 1000);
                    memCachedClient.add(msid, sessionData, expiry);
                }
            }
        }

    }

    session = new MemcacheHttpSession(sessionData, sessionData_cart,
            context, memCachedClient);

    return session;
}
}
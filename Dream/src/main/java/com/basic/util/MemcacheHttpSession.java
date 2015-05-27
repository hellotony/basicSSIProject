package com.basic.util;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import com.danga.MemCached.MemCachedClient;

public class MemcacheHttpSession implements HttpSession {

	private SessionData sessionData = null;

	private MemCachedClient memCachedClient;

	// private String msid;
	private boolean isNew = true;

	private ServletContext context = null;

	public MemcacheHttpSession(SessionData sessionData,
			SessionData sessionData_cart, ServletContext context,
			MemCachedClient memCachedClient) {
		this.context = context;
		this.memCachedClient = memCachedClient;
		this.sessionData = sessionData;
	}

	private void updateSessionData() {
		if (this.sessionData != null
				&& this.sessionData.getSessionMetaData().getValidate()) {
			// 设置最后一次访问时间
			sessionData.getSessionMetaData().setLastAccessTm(
					System.currentTimeMillis());
			this.isNew = false;
			Date expiry = new Date((long)sessionData.getSessionMetaData()
					.getMaxIdle() * 1000);
			memCachedClient.replace(sessionData.getSessionMetaData().getId(),
					this.sessionData, expiry);
		}

	}


	public long getCreationTime() {
		return sessionData != null ? sessionData.getSessionMetaData()
				.getCreateTm() : 0;
	}

	public String getId() {
		return sessionData != null ? sessionData.getSessionMetaData().getId()
				: null;
	}

	public long getLastAccessedTime() {
		return sessionData != null ? sessionData.getSessionMetaData()
				.getLastAccessTm() : 0;
	}

	public ServletContext getServletContext() {
		return context;
	}

	public void setMaxInactiveInterval(int interval) {
		if (sessionData != null) {
			sessionData.getSessionMetaData().setMaxIdle(interval);
			updateSessionData();
		}
	}

	public int getMaxInactiveInterval() {
		return sessionData != null ? sessionData.getSessionMetaData()
				.getMaxIdle() : 0;
	}

	public HttpSessionContext getSessionContext() {
		throw new UnsupportedOperationException("getSessionContext");
	}

	public Object getAttribute(String name) {
		if ("org.apache.struts2.interceptor.debugging.VALUE_STACK".equals(name)) {
			throw new UnsupportedOperationException("debugging.VALUE_STACK");
		}
		
			if (this.sessionData != null) {
				// if (!this.sessionData.getSessionMetaData().getValidate()) {
				// sessionData = null;
				// memCachedClient.delete(msid);
				// } else {
				// updateSessionData();性能考虑不更新memcache
				return sessionData.getDataMap().get(name);
				// }
			}
		return null;
	}

	public Object getValue(String name) {
		return getAttribute(name);
	}

	public Enumeration getAttributeNames() {
		if (sessionData != null) {
			return new Vector<String>(sessionData.getDataMap().keySet())
					.elements();
		} else {
			return null;
		}
	}

	public String[] getValueNames() {
		if (sessionData != null) {
			return sessionData.getDataMap().keySet()
					.toArray(new String[sessionData.getDataMap().size()]);
		} else {
			return null;
		}
	}

	public void setAttribute(String name, Object value) {
		if ("org.apache.struts2.interceptor.debugging.VALUE_STACK".equals(name)) {
			throw new UnsupportedOperationException("debugging.VALUE_STACK");
		}

			if (this.sessionData != null) {
				sessionData.getDataMap().put(name, value);
				updateSessionData();
			
		}

	}

	public void putValue(String name, Object value) {
		setAttribute(name, value);
	}

	public void removeAttribute(String name) {
		
			if (sessionData != null) {
				sessionData.getDataMap().remove(name);
				updateSessionData();
		}

	}

	public void removeValue(String name) {
		removeAttribute(name);

	}

	public void invalidate() {
		if (sessionData != null && sessionData.getSessionMetaData() != null) {
			this.memCachedClient.delete(sessionData.getSessionMetaData()
					.getId());
		}
		sessionData = null;
	}

	public boolean isNew() {
		return this.isNew;
	}

	public boolean isValid() {
		if (sessionData != null) {
			return sessionData.getSessionMetaData().getValidate();
		} else {
			return false;
		}
	}
}
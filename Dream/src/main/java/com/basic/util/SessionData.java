package com.basic.util;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;


public class SessionData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * session元数据
	 */
	private SessionMetaData sessionMetaData = null;
	/**
	 * session数据
	 */
	private final Map<String, Object> dataMap = new LinkedHashMap<String, Object>();;

	public SessionData(String sessionId,int maxIdle) {
		this.sessionMetaData = new SessionMetaData(sessionId,maxIdle);
	}

	public SessionMetaData getSessionMetaData() {
		return sessionMetaData;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

}
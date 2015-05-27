package com.basic.util;

import java.util.Map;

import com.danga.MemCached.SockIOPool;

public class Test extends SockIOPool{

	@Override
	protected void addSocketToPool(Map<String, Map<SockIO, Long>> pool,
			String host, SockIO socket) {
		// TODO Auto-generated method stub
		super.addSocketToPool(pool, host, socket);
	}

	@Override
	protected void clearHostFromPool(Map<String, Map<SockIO, Long>> pool,
			String host) {
		// TODO Auto-generated method stub
		super.clearHostFromPool(pool, host);
	}

	@Override
	protected SockIO createSocket(String host) {
		// TODO Auto-generated method stub
		return super.createSocket(host);
	}

	@Override
	public boolean getAliveCheck() {
		// TODO Auto-generated method stub
		return super.getAliveCheck();
	}

	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return super.getBufferSize();
	}

	@Override
	public SockIO getConnection(String host) {
		// TODO Auto-generated method stub
		return super.getConnection(host);
	}

	@Override
	public boolean getFailback() {
		// TODO Auto-generated method stub
		return super.getFailback();
	}

	@Override
	public boolean getFailover() {
		// TODO Auto-generated method stub
		return super.getFailover();
	}

	@Override
	public int getHashingAlg() {
		// TODO Auto-generated method stub
		return super.getHashingAlg();
	}

	@Override
	public String getHost(String key, Integer hashcode) {
		// TODO Auto-generated method stub
		return super.getHost(key, hashcode);
	}

	@Override
	public String getHost(String key) {
		// TODO Auto-generated method stub
		return super.getHost(key);
	}

	@Override
	public int getInitConn() {
		// TODO Auto-generated method stub
		return super.getInitConn();
	}

	@Override
	public long getMaintSleep() {
		// TODO Auto-generated method stub
		return super.getMaintSleep();
	}

	@Override
	public long getMaxBusy() {
		// TODO Auto-generated method stub
		return super.getMaxBusy();
	}

	@Override
	public int getMaxConn() {
		// TODO Auto-generated method stub
		return super.getMaxConn();
	}

	@Override
	public long getMaxIdle() {
		// TODO Auto-generated method stub
		return super.getMaxIdle();
	}

	@Override
	public int getMinConn() {
		// TODO Auto-generated method stub
		return super.getMinConn();
	}

	@Override
	public boolean getNagle() {
		// TODO Auto-generated method stub
		return super.getNagle();
	}

	@Override
	public String[] getServers() {
		// TODO Auto-generated method stub
		return super.getServers();
	}

	@Override
	public SockIO getSock(String key, Integer hashCode) {
		// TODO Auto-generated method stub
		return super.getSock(key, hashCode);
	}

	@Override
	public SockIO getSock(String key) {
		// TODO Auto-generated method stub
		return super.getSock(key);
	}

	@Override
	public int getSocketConnectTO() {
		// TODO Auto-generated method stub
		return super.getSocketConnectTO();
	}

	@Override
	public int getSocketTO() {
		// TODO Auto-generated method stub
		return super.getSocketTO();
	}

	@Override
	public Integer[] getWeights() {
		// TODO Auto-generated method stub
		return super.getWeights();
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		super.initialize();
	}

	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return super.isInitialized();
	}

	@Override
	protected void removeSocketFromPool(Map<String, Map<SockIO, Long>> pool,
			String host, SockIO socket) {
		// TODO Auto-generated method stub
		super.removeSocketFromPool(pool, host, socket);
	}

	@Override
	protected void selfMaint() {
		// TODO Auto-generated method stub
		super.selfMaint();
	}

	@Override
	public void setAliveCheck(boolean aliveCheck) {
		// TODO Auto-generated method stub
		super.setAliveCheck(aliveCheck);
	}

	@Override
	public void setBufferSize(int bufferSize) {
		// TODO Auto-generated method stub
		super.setBufferSize(bufferSize);
	}

	@Override
	public void setFailback(boolean failback) {
		// TODO Auto-generated method stub
		super.setFailback(failback);
	}

	@Override
	public void setFailover(boolean failover) {
		// TODO Auto-generated method stub
		super.setFailover(failover);
	}

	@Override
	public void setHashingAlg(int alg) {
		// TODO Auto-generated method stub
		super.setHashingAlg(alg);
	}

	@Override
	public void setInitConn(int initConn) {
		// TODO Auto-generated method stub
		super.setInitConn(initConn);
	}

	@Override
	public void setMaintSleep(long maintSleep) {
		// TODO Auto-generated method stub
		super.setMaintSleep(maintSleep);
	}

	@Override
	public void setMaxBusyTime(long maxBusyTime) {
		// TODO Auto-generated method stub
		super.setMaxBusyTime(maxBusyTime);
	}

	@Override
	public void setMaxConn(int maxConn) {
		// TODO Auto-generated method stub
		super.setMaxConn(maxConn);
	}

	@Override
	public void setMaxIdle(long maxIdle) {
		// TODO Auto-generated method stub
		super.setMaxIdle(maxIdle);
	}

	@Override
	public void setMinConn(int minConn) {
		// TODO Auto-generated method stub
		super.setMinConn(minConn);
	}

	@Override
	public void setNagle(boolean nagle) {
		// TODO Auto-generated method stub
		super.setNagle(nagle);
	}

	@Override
	public void setServers(String[] servers) {
		// TODO Auto-generated method stub
		super.setServers(servers);
	}

	@Override
	public void setSocketConnectTO(int socketConnectTO) {
		// TODO Auto-generated method stub
		super.setSocketConnectTO(socketConnectTO);
	}

	@Override
	public void setSocketTO(int socketTO) {
		// TODO Auto-generated method stub
		super.setSocketTO(socketTO);
	}

	@Override
	public void setWeights(Integer[] weights) {
		// TODO Auto-generated method stub
		super.setWeights(weights);
	}

	@Override
	public void shutDown() {
		// TODO Auto-generated method stub
		super.shutDown();
	}

	
		
		
		
	
}

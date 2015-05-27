package com.dream.test;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class TestService{
	@Resource
	private Dao dao;

	public void add() {
		// TODO Auto-generated method stub
		dao.add();
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
}

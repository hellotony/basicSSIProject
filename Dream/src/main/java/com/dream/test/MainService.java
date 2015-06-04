package com.dream.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class MainService{
	@Resource
	private MainDao dao;

	public void add() {
		// TODO Auto-generated method stub
		dao.add();
	}

	public MainDao getDao() {
		return dao;
	}

	public void setDao(MainDao dao) {
		this.dao = dao;
	}

	public User getUserByName(String parameter) {
		return dao.getUserByName(parameter);
	}

	public void saveUser(User user) {
		dao.saveUser(user);
	}
}

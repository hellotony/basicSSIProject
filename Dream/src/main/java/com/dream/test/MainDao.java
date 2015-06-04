package com.dream.test;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

@Component
public class MainDao {
	
	@Resource
	protected SqlSessionTemplate sqlSessionTemplate;

	public void add() {
		// TODO Auto-generated method stub
		this.sqlSessionTemplate.insert("main.insert");
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	//通过用户名 拿到密码
	public User getUserByName(String parameter) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("main.getUserByName", parameter);
	}

	public void saveUser(User user) {
		 this.sqlSessionTemplate.insert("main.saveUser", user);
	}
}

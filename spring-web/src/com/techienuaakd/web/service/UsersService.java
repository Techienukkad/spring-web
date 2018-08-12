package com.techienuaakd.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techienuaakd.web.dao.User;
import com.techienuaakd.web.dao.UsersDao;

@Service("UsersService")
public class UsersService {

	private UsersDao dao;

	public UsersDao getDao() {
		return dao;
	}
	@Autowired
	public void setDao(UsersDao dao) {
		this.dao = dao;
	}
	
	public void createUser(User user) {
		dao.createNewUser(user);
	}
}

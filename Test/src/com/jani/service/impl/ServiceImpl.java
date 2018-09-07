package com.jani.service.impl;

import java.util.List;

import com.jani.bean.User;
import com.jani.dao.UserDao;
import com.jani.dao.impl.UserDaoImpl;
import com.jani.service.Service;

public class ServiceImpl implements Service{

	private UserDao userDao=new UserDaoImpl();
	@Override
	public List<User> query() {
		List<User> list=userDao.query();
		return list;
	}

}

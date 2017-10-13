package com.globallogic.springProj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.springProj.dao.UserDao;
import com.globallogic.springProj.model.User;
import com.globallogic.springProj.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public User getUserByLoginAndPass(String login, String pass) {
		return userDao.getUserByLoginAndPass(login, pass);
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(Long userId) {
		userDao.deleteUser(userId);
	}
	
	@Override
	public User getUserById(Long id) {
		
		return userDao.getUserById(id);
	}

	

	@Override
	public User getUserByLogin(String login) {
		
		return userDao.getUserByLogin(login);
	}

	

}

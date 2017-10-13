package com.globallogic.springProj.dao;

import java.util.List;

import com.globallogic.springProj.model.User;

public interface UserDao {

	public List<User> getAll();
	public User getUserById(Long id);
	public User getUserByLogin(String login);
	public User getUserByLoginAndPass(String login, String pass);
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(Long userId);

}
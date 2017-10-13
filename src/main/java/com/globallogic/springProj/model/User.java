package com.globallogic.springProj.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;
	
	private String login;
	
	private String password;
	
	private List<Role> roles = new LinkedList<Role>();
	
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long id) {
		this.userId = id;
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String name) {
		this.login = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	

}

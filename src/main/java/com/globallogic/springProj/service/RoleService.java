package com.globallogic.springProj.service;

import java.util.List;

import com.globallogic.springProj.model.Role;

public interface RoleService {
	public List<Role> getAll();
	public Role getById(Integer id);
	public Role getByName(String name);
	
}

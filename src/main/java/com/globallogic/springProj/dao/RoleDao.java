package com.globallogic.springProj.dao;

import java.util.List;

import com.globallogic.springProj.model.Role;

public interface RoleDao {
	public List<Role> getAll();
	public Role getById(Integer id);
	public Role getByName(String name);
}

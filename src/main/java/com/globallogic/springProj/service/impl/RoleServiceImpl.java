package com.globallogic.springProj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.springProj.dao.RoleDao;
import com.globallogic.springProj.model.Role;
import com.globallogic.springProj.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;

	@Override
	public List<Role> getAll() {
		return roleDao.getAll();
	}

	@Override
	public Role getById(Integer id) {
		return roleDao.getById(id);
	}

	@Override
	public Role getByName(String name) {
		return roleDao.getByName(name);
	}
}

package com.globallogic.springProj.dao.hibernate;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.springProj.dao.RoleDao;
import com.globallogic.springProj.dao.hibernate.entities.RoleEntity;
import com.globallogic.springProj.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	private static final Logger logger = Logger.getLogger(RoleDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Role> getAll() {
		List<RoleEntity> roleEntities;
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(RoleEntity.class);
			roleEntities = criteria.list();
		} catch (HibernateException e) {
			logger.error("Exception situation in ", e);
			return null;
		}

		List<Role> roles = new LinkedList<Role>();

		for (RoleEntity roleEnity : roleEntities) {
			roles.add(getRole(roleEnity));
		}
		return roles;
	}

	@Override
	@Transactional
	public Role getById(Integer id) {
		try {
			return getRole((RoleEntity) sessionFactory.getCurrentSession().get(
					RoleEntity.class, id));
		} catch (HibernateException e) {
			logger.error("Exception situation in ", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Role getByName(String name) {
		List<RoleEntity> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(RoleEntity.class);
			criteria.add(Restrictions.eq("name", name));
			list = criteria.list();
		} catch (HibernateException e) {
			logger.error("Exception situation in ", e);
			return null;
		}
		return (list.size() != 1) ? getRole(list.get(0)) : null;
	}

	private Role getRole(RoleEntity roleEntity) {
		Role role = new Role();
		role.setRoleId(roleEntity.getRoleId());
		role.setName(roleEntity.getName());
		return role;
	}

}
package com.globallogic.springProj.dao.hibernate;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.springProj.dao.UserDao;
import com.globallogic.springProj.dao.hibernate.entities.RoleEntity;
import com.globallogic.springProj.dao.hibernate.entities.UserEntity;
import com.globallogic.springProj.model.Role;
import com.globallogic.springProj.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> getAll() {
		Criteria criteria;
		List<UserEntity> userEntities;
		try {
			criteria = sessionFactory.getCurrentSession().createCriteria(
					UserEntity.class);
			userEntities = criteria.list();
			List<User> users = new ArrayList<User>();
			for (UserEntity userEntity : userEntities) {
				users.add(getUser(userEntity));
			}
			return users;
		} catch (Exception e) {
			logger.error("Exception situation in ", e);
			return null;
		}

	}

	@Override
	@Transactional
	public void deleteUser(Long userId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			UserEntity userEntity = (UserEntity) session.load(UserEntity.class,
					userId);
			session.delete(userEntity);
			session.flush();
		} catch (Exception e) {
			logger.error("Exception situation in ", e);
		}
	}

	@Override
	@Transactional
	public void insertUser(User user) {
		UserEntity userEntity = wrapToHibernUser(user);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(userEntity);
			session.flush();
		} catch (Exception e) {
			logger.error("Exception situation in ", e);
		}
	}

	@Override
	@Transactional
	public User getUserById(Long userId) {
		UserEntity userEntity = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			userEntity = (UserEntity) session.get(UserEntity.class, userId);
			return getUser(userEntity);
		} catch (Exception e) {
			logger.error("Exception situation in ", e);
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public User getUserByLoginAndPass(String login, String pass) {
		List<UserEntity> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(UserEntity.class);
			criteria.add(Restrictions.eq("login", login));
			criteria.add(Restrictions.eq("password", pass));
			list = criteria.list();
		} catch (Exception e) {
			logger.error("Exception situation in ", e);
			return null;
		}
		return (list.size() == 1) ? getUser(list.get(0)) : null;
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		UserEntity userEntity = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			userEntity = (UserEntity) session.load(UserEntity.class,
					user.getUserId());
			userEntity.setLogin(user.getLogin());
			userEntity.setPassword(user.getPassword());
			userEntity.setRoles(new LinkedHashSet<RoleEntity>());
			if (user.getRoles() != null) {
				for (Role role : user.getRoles()) {
					RoleEntity roleEntity = new RoleEntity();
					roleEntity.setRoleId(role.getRoleId());
					roleEntity.setName(role.getName());
					userEntity.getRoles().add(roleEntity);
				}
			}
			session.flush();
		} catch (Exception e) {
			logger.error("Exception situation in ", e);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public User getUserByLogin(String login) {
		List<UserEntity> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(UserEntity.class);
			criteria.add(Restrictions.eq("login", login));
			list = criteria.list();
		} catch (Exception e) {
			logger.error("Exception situation in ", e);
			return null;
		}
		return (list.size() == 1) ? getUser(list.get(0)) : null;
	}

	private User getUser(UserEntity userEntity) throws NullPointerException {

		User user = new User();
		user.setUserId(userEntity.getUserId());
		user.setLogin(userEntity.getLogin());
		user.setPassword(userEntity.getPassword());
		for (RoleEntity roleEntity : userEntity.getRoles()) {
			Role role = new Role();
			role.setRoleId(roleEntity.getRoleId());
			role.setName(roleEntity.getName());
			user.getRoles().add(role);
		}
		return user;
	}

	private UserEntity wrapToHibernUser(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(user.getUserId());
		userEntity.setLogin(user.getLogin());
		userEntity.setPassword(user.getPassword());
		if (user.getRoles() != null) {
			for (Role role : user.getRoles()) {
				RoleEntity roleEntity = new RoleEntity();
				roleEntity.setRoleId(role.getRoleId());
				roleEntity.setName(role.getName());
				userEntity.getRoles().add(roleEntity);
			}
		}
		return userEntity;
	}

}
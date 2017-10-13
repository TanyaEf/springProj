package com.globallogic.springProj.dao.hibernate.entities;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class UserEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	@Column(name="login")
	private String login;
	
	@Column(name="password")
	private String password;
	
	@ManyToMany
	@JoinTable(name = "USERS_ROLES",
			joinColumns = { @JoinColumn(name = "USER_ID") },
			inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") }) 
	private Set<RoleEntity> roles = new LinkedHashSet<RoleEntity>();
	
	
	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long l) {
		this.userId = l;
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

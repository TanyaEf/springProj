package com.globallogic.springProj.dao.hibernate.entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
public class RoleEntity {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer roleId;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "USERS_ROLES",  
			joinColumns = { @JoinColumn(name = "ROLE_ID") },
			inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
	private List<UserEntity> users = new LinkedList<UserEntity>();
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

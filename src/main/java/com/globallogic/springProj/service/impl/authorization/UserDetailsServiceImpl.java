package com.globallogic.springProj.service.impl.authorization;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.globallogic.springProj.dao.UserDao;
import com.globallogic.springProj.model.Role;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {

		com.globallogic.springProj.model.User user = userDao
				.getUserByLogin(login);

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(user.getLogin(), user.getPassword(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked,
				getAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(
			List<Role> listRoles) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(listRoles));
		return authList;
	}

	public List<String> getRoles(List<Role> listRoles) {

		List<String> roleNames = new LinkedList<String>();

		for (Role role : listRoles) {
			roleNames.add("ROLE_" + role.getName().toUpperCase());
		}
		return roleNames;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new LinkedList<GrantedAuthority>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
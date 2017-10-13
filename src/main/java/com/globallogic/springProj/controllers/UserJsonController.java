package com.globallogic.springProj.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.globallogic.springProj.model.User;
import com.globallogic.springProj.service.RoleService;
import com.globallogic.springProj.service.UserService;

@Controller
@RequestMapping(value = "/userJson")
public class UserJsonController {
	
	private static final Logger logger = Logger.getLogger(UserJsonController.class);

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<User> viewUsersListJson () {
		logger.info("JSON returned successfully");
		return userService.getAll();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView doAddNewUser(User user,
			BindingResult result, HttpServletRequest req,
			@RequestParam(value = "roles", required = false) int[] roles) {

		// if (result.hasErrors()) {
		//
		// return new ModelAndView("addUser");
		// }
		if (userService.getUserByLoginAndPass(user.getLogin(),
				user.getPassword()) == null) {
			if (roles != null) {
				for (int roleId : roles) {
					user.getRoles().add(roleService.getById(roleId));
				}
			}
			userService.insertUser(user);

			return new ModelAndView("redirect: all");
		} else {

			return new ModelAndView("addUser", "error",
					"There is user with these login and password");
		}
	}
	
	/*

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView viewAddUser() {
		ModelAndView modelAndView = new ModelAndView("addUser", "user",
				new User());
		modelAndView.addObject("roles", roleService.getAll());
		return modelAndView;

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView doAddNewUser(User user,
			BindingResult result, HttpServletRequest req,
			@RequestParam(value = "roles", required = false) int[] roles) {

	
		if (userService.getUserByLoginAndPass(user.getLogin(),
				user.getPassword()) == null) {
			if (roles != null) {
				for (int roleId : roles) {
					user.getRoles().add(roleService.getById(roleId));
				}
			}
			userService.insertUser(user);

			return new ModelAndView("redirect: all");
		} else {

			return new ModelAndView("addUser", "error",
					"There is user with these login and password");
		}
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView viewUsersList(HttpServletRequest req) {
		List<User> users = userService.getAll();
		if (users == null) {
			logger.warn("List of users is empty");
			return new ModelAndView("redirect:/home");
		}
		return new ModelAndView("users", "users", users);
	}
	

	

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView doDeleteUser(@RequestParam("id") Long id) {
		userService.deleteUser(id);
		return new ModelAndView("redirect: all");

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView viewUpdateUser(@RequestParam("id") Long id) {
		ModelAndView modelView = new ModelAndView();
		User user = userService.getUserById(id);
		List<Role> listRoles = roleService.getAll();
		if (user == null || listRoles == null) {
			logger.warn("List of roles is empty"); 
			return new ModelAndView("redirect: all");
		}
		modelView.addObject("user", user);
		modelView.addObject("roles", listRoles);
		modelView.setViewName("editUser");
		return modelView;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView doUpdateUser(@Validated User user, BindingResult result,
			HttpServletRequest req,
			@RequestParam(value = "roles", required = false) int[] roles) {

		if (roles != null) {
			for (int roleId : roles) {
				user.getRoles().add(roleService.getById(roleId));
			}
		}
		
		// if (result.hasErrors()) {
		//
		// ModelAndView modelAndView = new ModelAndView();
		// modelAndView.addObject("user", user);
		// modelAndView.addObject("roles", roleService.getAll());
		// modelAndView.setViewName("editUser");
		// return modelAndView;
		// }

		userService.updateUser(user);
		return new ModelAndView("redirect: all");

	}
	*/

}

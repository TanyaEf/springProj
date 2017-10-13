package com.globallogic.springProj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.globallogic.springProj.model.JsonRecordResponse;
import com.globallogic.springProj.model.JsonTableResponse;
import com.globallogic.springProj.model.User;
import com.globallogic.springProj.service.RoleService;
import com.globallogic.springProj.service.UserService;

@Controller
@RequestMapping(value = "userJTable")
public class UserJtableController {
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;

	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public @ResponseBody JsonTableResponse viewUsersList() {

		List<User> list = userService.getAll();

		return (list.size() > 0) ? new JsonTableResponse("OK", list, list.size(), roleService.getAll()) : new JsonTableResponse("ERROR", null, null, null);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody JsonRecordResponse addUser(@ModelAttribute User user, @RequestParam int allRoles,  BindingResult result) {
			
			userService.insertUser(user);
			return new JsonRecordResponse("OK", userService.getUserByLoginAndPass(user.getLogin(), user.getPassword()));
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody JsonRecordResponse updateUser(@ModelAttribute User user, BindingResult result) {
		
			userService.updateUser(user);
			return new JsonRecordResponse("OK", user);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody JsonTableResponse deleteUser(
			@RequestParam String userId) {
		
			userService.deleteUser(Long.parseLong(userId));
			return new JsonTableResponse("OK", null, null, null);
	}


}

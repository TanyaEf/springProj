package com.globallogic.springProj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globallogic.springProj.service.RoleService;
import com.globallogic.springProj.service.UserService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(method=RequestMethod.GET)
	private ModelAndView view() {
		
		return new ModelAndView("forward:/user/all", "roles", roleService.getAll());

	}

}

package com.globallogic.springProj.service.impl.validation;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.globallogic.springProj.model.User;

@Service
public class FormValidator implements Validator {

	@Override
	public boolean supports(Class<?> param) {
		return User.class.equals(param);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "valid.name");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"valid.password");

	}

}

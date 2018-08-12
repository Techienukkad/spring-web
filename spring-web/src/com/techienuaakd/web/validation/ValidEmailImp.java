package com.techienuaakd.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;

public class ValidEmailImp implements ConstraintValidator<ValidEmail, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(!EmailValidator.getInstance(false).isValid(value))
			return false;
		return true;
	}

}

package com.techienuaakd.web.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataBaseErrorHandller {

	@ExceptionHandler(DataAccessException.class)
	public String handleException(DataAccessException ex)
	{
		ex.printStackTrace();
		return "error";
	}
}

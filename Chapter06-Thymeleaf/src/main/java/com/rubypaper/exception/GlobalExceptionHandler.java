package com.rubypaper.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BoardException.class)
	public String handleCustomException(BoardException e, Model m) {
		m.addAttribute("exception", e);
		return "/errors/boardError";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model m) {
		m.addAttribute("exceptionMessage", e.getMessage());
		m.addAttribute("stackTrae", e.getStackTrace());
		return "/errors/globalError";
	}
}

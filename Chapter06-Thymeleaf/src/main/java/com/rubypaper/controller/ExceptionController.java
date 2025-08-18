package com.rubypaper.controller;

import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import com.rubypaper.exception.BoardNotFoundException;

@Controller
public class ExceptionController {
	@GetMapping("/boardError")
	public String boardError() {
		throw new BoardNotFoundException("검색된게시글이없습니다.");
	}

	@GetMapping("/illegalArgumentError")
	public String ellegalArgumentError() {
		throw new IllegalArgumentException("부적절한인자가전달되었습니다.");
	}

	@GetMapping("/sqlError")
	public String sqlError() throws SQLException {
		throw new SQLException("SQL 구문에오류가있습니다.");
	}
	
	@ExceptionHandler(SQLException.class)
	public String numberFormatError(SQLException e, Model m) {
		m.addAttribute("exceptionMessage", e.getMessage());
		m.addAttribute("stackTrace", e.getStackTrace());
		return "/errors/sqlError";
	}
}
package com.rubypaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@RestController
@RequestMapping("/api")
public class TestController {
	@Autowired
	private BoardRepository boardRepo;

	// 검색결과목록리턴
	@GetMapping("/board")
	public List<Board> getBoards() {
		return boardRepo.findAll(); 
	}	
}
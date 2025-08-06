package com.rubypaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@RestController
@RequestMapping("/api")
public class TestController {
	@Autowired
	private BoardRepository boardRepo;

	@GetMapping("/board")
	public List<Board> getBoards() {
		return boardRepo.findAll(); // 검색결과목록리턴
	}

	@GetMapping("/board/{seq}")
	public Board getBoard(@PathVariable Long seq) {
		return null; // 검색결과객체리턴
	}

	@PostMapping("/board")
	public Board postBoard(@RequestBody Board board) {
		return boardRepo.save(board); // 입력객체리턴
	}

	@PutMapping("/board")
	public Board putBoard(Board board) {
		return null; // 수정객체리턴
	}

	@PatchMapping("/board")
	public Board patchBoard(Board board) {
		return null; // 수정객체리턴
	}

	@DeleteMapping("/board/{seq}")
	public Board deleteBoard(@PathVariable Long seq) {
		return null; // 삭제객체리턴
	}
}
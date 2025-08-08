package com.rubypaper.controller;

import java.util.Date;
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

	// 검색결과목록리턴
	@GetMapping("/board")
	public List<Board> getBoards() {
		return boardRepo.findAll(); 
	}

	// 검색결과객체리턴
	@GetMapping("/board/{seq}")
	public Board getBoard(@PathVariable Long seq) {
		return boardRepo.findById(seq).orElse(null); 
	}

	// 입력객체리턴
	@PostMapping("/board")
	public Board postBoard(@RequestBody Board board) {
		return boardRepo.save(board);
	}

	// 수정객체리턴
	@PutMapping("/board/{seq}")
	public Board putBoard(@PathVariable Long seq, @RequestBody Board board) {
		board.setSeq(seq);
		return boardRepo.save(board);  
	}

	// 수정객체리턴
	@PatchMapping("/board/{seq}")
	public Board patchBoard(@PathVariable Long seq, @RequestBody Board board) {
		Board boardTemp = boardRepo.findById(seq).get();
		board.setSeq(seq);
		if(board.getTitle() == null)
			board.setTitle(boardTemp.getTitle());
		if(board.getWriter() == null)
			board.setWriter(boardTemp.getWriter());
		if(board.getContent() == null)
			board.setContent(boardTemp.getContent());
		
		board.setCreateDate(new Date());
		board.setCnt(boardTemp.getCnt());
		
		return boardRepo.save(board);  
	}

	// 삭제객체리턴
	@DeleteMapping("/board/{seq}")
	public void deleteBoard(@PathVariable Long seq) {
		boardRepo.deleteById(seq); 
	}
}
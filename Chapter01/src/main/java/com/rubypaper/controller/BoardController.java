package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;
import com.rubypaper.domain.BoardVO.BoardVOBuilder;

import lombok.Builder;

// @RestController 이어노테이션 사용하면, spring이 객체를 만들어줌 => "BoardController 생성" 콘솔창 뜸
// : 요청에대한 응답을 할때 응답 데이터를 본문에다 바로 담아 주는 역할. => response객체에 html본문을 json타입의 string으로 보내줌(텍스트)
@RestController
public class BoardController {
	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	//http://localhost:8080/hello?name=JSP
	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello: " + name;
	}
	
	//이 메서드를 실행하면 board라는 객체를 리턴하는데, 브라우저에 json타입으로 넘어간다.
	//http://localhost:8080/getBoard
	@Builder
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = BoardVO.builder()
		.seq(1)
		.title("테스트제목...")
		.writer("테스터")
		.content("테스트내용입니다")
		.createDate(new Date())
		.cnt(0)
		.build();
		
//		board.setSeq(1);
//		board.setTitle("테스트 제목...");
//		board.setWriter("테스터");
//		board.setContent("테스트 내용입니다...............");
//		board.setCreateDate(new Date());
//		board.setCnt(0);
		return board;
	}
	
	//배열로 바껴서 브라우저로 넘어감
	//http://localhost:8080/getBoardList
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList(){
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for(int i = 1; i <= 10; i++) {		
			BoardVO board = new BoardVO();
			board.setSeq(1);
			board.setTitle("제목"+i);
			board.setWriter("테스터");
			board.setContent(i+"번 내용입니다.");
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		return boardList;
	}
}

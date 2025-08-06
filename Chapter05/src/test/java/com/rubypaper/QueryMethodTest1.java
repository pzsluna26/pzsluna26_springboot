package com.rubypaper;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest1 {
	@Autowired
	private BoardRepository boardRepo;
	
	@BeforeAll
	static void dataPrepare(@Autowired BoardRepository boardRepo) {
		Random random = new Random();
		System.out.println("dataPrepare()");
		for(int i=1; i<=200; i++) {
			Board board = new Board();
			board.setTitle("테스트 제목 "+i);
			board.setWriter("테스터");
			board.setContent("테스트 내용 "+i);
			board.setCreateDate(new Date());
			int randomInt = random.nextInt(101);
		    board.setCnt((long)randomInt);  
			boardRepo.save(board);
		}
	}
	
//  쿼리 메소드 활용 실습 209 
//  2번문제
//	@Test
	public void testFindByTitleContaining() {
		List<Board> boardList = boardRepo.findByTitleContaining("1");
		System.out.println(" title에 1이 포함되는 데이터 출력");
		for (Board board : boardList) {
		System.out.println("---> " + board.toString());
		}
	}
	
//  3번문제
//	@Test
	public void testfindByTitleContainingAndCntGreaterThan() {
		List<Board> boardList = boardRepo.findByTitleContainingAndCntGreaterThan("1", 50);
		System.out.println("title에 1이 포함되면서 cnt가 50보다 큰 데이터 출력");
		for (Board board : boardList) {
		System.out.println("---> " + board.toString());
		}
	}
	
//  4번문제
//	@Test
	public void testfindByCntBetweenOrderBySeqAsc() {
		List<Board> boardList = boardRepo.findByCntBetweenOrderBySeqAsc(10L ,50L);
		System.out.println("Cnt가 10~50 사이인 데이터를 seq 오름차순으로 출력");
		for (Board board : boardList) {
		System.out.println("---> " + board.toString());
		}
	}
//  5번문제
	@Test
	public void testfindByTitleContainingOrContentContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10" ,"2");
		System.out.println("title에 \"10\"이 포함되거나 content에 \"2\"가 포함되는 데이터를 seq 내림차순으로 출력");
		for (Board board : boardList) {
		System.out.println("---> " + board.toString());
		}
	}
	}

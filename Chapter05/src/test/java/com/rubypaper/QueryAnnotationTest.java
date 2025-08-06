package com.rubypaper;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.dto.BoardDTO;
import com.rubypaper.persistence.BoardRepository;


//@Query-위치 기반 파라미터

@SpringBootTest
public class QueryAnnotationTest {
	@Autowired
	private BoardRepository boardRepo;


//@Query 이름 기반 파라미터
//	@Test
	public void testQueryAnnotationTest1() {
		List<Board> boardList = boardRepo.queryAnnotationTest1("테스트 제목 10");
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}
	
	
//@Query 특정 변수만 조회하기
//	@Test
	public void testQueryAnnotationTest2() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest2("테스트 제목 10");
		System.out.println("검색 결과");
		for(Object[] row : boardList) {
			System.out.println("--->" + Arrays.toString(row));
		}
	}
	
//@Query 특정변수만조회하기-응용
//	@Test 수정
	public void testQueryAnnotationTest3() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest3("테스트제목 10");
		System.out.println("검색 결과");
		for(Object[] row : boardList)
			System.out.println("--->" + Arrays.toString(row));
	}
	
//네이티브쿼리
//	@Test 수정
	public void testQueryAnnotationTest4() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest4("테스트제목 10");
		System.out.println("검색 결과");
		for(Object[] row : boardList)
			System.out.println("--->" + Arrays.toString(row));
	}
	
	
//페이징 및 정렬 처리하기
	@Test
	public void testQueryAnnotationTest5() {
		Pageable paging = PageRequest.of(0, 3, Sort.Direction.DESC,"seq");
		List<Board> boardList = boardRepo.queryAnnotationTest5(paging);
		System.out.println("검색 결과");
		for(Board board : boardList)
			System.out.println("--->" + board.toString());
	}
}

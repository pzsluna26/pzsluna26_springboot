package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rubypaper.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	//PDF 파일 201~209
	//쿼리메소드작성 및 테스트
	List<Board> findByTitle(String searchKeyword);
	//like연산자
	List<Board> findByContentContaining(String searchKeyword);
	//여러조건사용
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	//데이터 정렬
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	
	
	
	//쿼리메소드활용실습 - 2번
	List<Board> findByTitleContaining(String t);
	//쿼리메소드활용실습 - 3번
	List<Board> findByTitleContainingAndCntGreaterThan(String title, long cnt);
	//쿼리메소드활용실습 - 4번
	List<Board> findByCntBetweenOrderBySeqAsc(long start, long end);
	//쿼리메소드활용실습 - 5번
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);
	
	
	
	//PDF 파일 210
	//페이징
    //List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	
	//PDF 파일 212
	//페이지타입
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);

	
	//PDF 파일 217
	//@Query 위치 기반 파라미터
//	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(String searchKeyword);
	
	//@Query 이름 기반 파라미터
	@Query("SELECT b FROM Board b WHERE b.title like %:searchKeyword% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
	
	//@Query 특정변수만조회하기
	//object타입으로 리턴
	@Query("SELECT b.seq, b.title")
	
}

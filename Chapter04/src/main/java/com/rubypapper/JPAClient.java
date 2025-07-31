package com.rubypapper;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;

import com.rubypapper.domain.Board;

public class JPAClient {

//	public static void main(String[] args) {
//		
//		//EntityManagerFactory 생성
//		EntityManagerFactory emf = 
//				Persistence.createEntityManagerFactory("Chapter05");
//		
//		//EntityManager 생성
//		EntityManager em = emf.createEntityManager();
//		
//		
//		//Transaction 생성
//		//-> 전부실행 되던지 아니던지 하나의 단위 예)은행프로그램 입출금
//		EntityTransaction tx = em.getTransaction();
//		
//		try {
//			
//			//Transaction 시작
//			tx.begin();
//			
//			//DB에 저장할 객체 생성
//			Board board = new Board();
//			board.setTitle("JPA 제목");
//			board.setWriter("관리자");
//			board.setContent("JPA 글 등록 잘 되네요.");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			 // 글등록
//			em.persist(board);
//			
//			//Transaction 끝
//			tx.commit();
//			
//			 } catch (Exception e) {
//			 e.printStackTrace(); 
//			 
//			 //Transaction rollback
//			 tx.rollback();
//			 
//			} finally {
//			 // 사용한리소스객체닫기
//			em.close();
//			 emf.close();
//			 } 
//		}
	
//	public static void main(String[] args) {
//		//EntityManagerFactory 생성
//		EntityManagerFactory emf = 
//				Persistence.createEntityManagerFactory("Chapter05");
//		
//		//EntityManager 생성
//		EntityManager em = emf.createEntityManager();
//		
//		try {
//			// 글 상세 조회
//											// id가 1번인 데이터
//			Board searchBoard = em.find(Board.class, 1L);
//			System.out.println("--->" + searchBoard.toString());
//			
//		} catch (Exception e) {
//			 e.printStackTrace(); 
//		} finally {
//			em.close();
//			emf.close();
//		}
//	}
	

	public static void main(String[] args) {
		//EntityManagerFactory 생성
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("Chapter05");
		
		//EntityManager 생성
		EntityManager em = emf.createEntityManager();
		
		try {
			
								// JPA Query (JPQL) 사용
			List<Board> list = em.createQuery("select b from Board b", Board.class).getResultList();
			list.stream().forEach(System.out::println);
			
			@SuppressWarnings("unchecked")
								// Native SQL 사용 (즉, 진짜 SQL)
			List<Board> list1 = em.createNativeQuery("select * from board", Board.class).getResultList();
			list1.stream().forEach(System.out::println);
		
		} catch (Exception e) {
			 e.printStackTrace(); 
		} finally {
			em.close();
			emf.close();
		}
 }
}

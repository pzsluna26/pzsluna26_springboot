package com.rubypaper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.persistence.MemberRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class NplusOneTest {
	@Autowired
	private MemberRepository memberRepo;
	
	private void printResult(List<Member> list) {
		System.out.println("검색 결과");
		for(Member m : list) {
			System.out.println(m);
			List<Board> bList = m.getBoardList();
			for(Board b : bList)
				System.out.println("\t" + b);
			}		
		}
	
	@Transactional
	@Test
	public void test01() {
		printResult(memberRepo.findAll());	
	}
}

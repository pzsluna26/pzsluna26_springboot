package com.rubypaper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.persistence.MemberRepository;

@Component
public class DataInit implements ApplicationRunner {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		for(int i =1; i <=10; i++) {
			Member m = Member.builder()
					.id("member" + i).password("password" + i)
					.name("name" + i).role("user").build();
			Board b = Board.builder()
					.title("title" + i).content("content"+ i)
					.createDate(new Date()).cnt(0L).build();
			b.setMember(m);
			memberRepo.save(m);
		}

	}

}

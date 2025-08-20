package com.rubypaper;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.rubypaper.domain.Member;
import com.rubypaper.domain.Role;
import com.rubypaper.persistence.MemberRepository;

import lombok.RequiredArgsConstructor;

@Component
//final 붙은 필드 생성자 생성
@RequiredArgsConstructor

//applicationRunner 
// => 스프링 부트 애플리케이션이 실행된 직후, 특정 코드(그걸 구현하는 클래스=DataInit)를 실행하고 싶을 때 사용
// => 초기 데이터로딩시 유용함 

public class DataInit implements ApplicationRunner {
	
	private final MemberRepository memberRepo;
	private final PasswordEncoder encoder;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		memberRepo.save(Member.builder().id("member").pass(encoder.encode("abcd")).name("홍길동").enabled(true).role(Role.ROLE_MEMBER).build());
		memberRepo.save(Member.builder().id("manager").pass(encoder.encode("abcd")).name("홍이동").enabled(true).role(Role.ROLE_MANAGER).build());
		memberRepo.save(Member.builder().id("admin").pass(encoder.encode("abcd")).name("홍삼동").enabled(true).role(Role.ROLE_ADMIN).build());
	}
	

	

}

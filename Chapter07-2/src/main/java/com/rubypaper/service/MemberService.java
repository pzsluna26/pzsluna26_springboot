package com.rubypaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Member;
import com.rubypaper.persistence.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	//member가 이미 존재하는 경우 처리 추가
	public void save(Member member) {
		member.setPass(encoder.encode(member.getPass()));
		memberRepo.save(member);
	}
}

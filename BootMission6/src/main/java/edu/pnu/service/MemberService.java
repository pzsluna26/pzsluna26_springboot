package edu.pnu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;


@Service
public class MemberService {
	
		@Autowired
		private MemberRepository memberRepo;
		
		// 전체 검색 
		public List<Member> getAllMember(){
			return memberRepo.findAll();
		}
		
		// 아이디 검색 
		public Member getMemberById(Integer id) {
		    return memberRepo.findById(id).orElse(null);
		}
		
		// 회원 추가
		public Member postMember(Member member) {
			return  memberRepo.save(member);
		}
		
		// 전체 수정 
		public Member putMember(Integer id, Member member) {
			member.setId(id);
			return memberRepo.save(member);
		}
		
		// 일부 수정 
		public Member patchMember(Integer id, Member member) {
			Member memberTemp = memberRepo.findById(id).get();
			member.setId(id);
			if(member.getName() == null)
				member.setName(memberTemp.getName());
			if(member.getPass() == null)
				member.setPass(memberTemp.getPass());;
			member.setRegidate(new Date());
			
			return memberRepo.save(member);
		}
		
		// 삭제 
		public void deleteMember(Integer id) {
			memberRepo.deleteById(id);
		}
}

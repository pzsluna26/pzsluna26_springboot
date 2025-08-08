package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.pnu.service.MemberService;
import edu.pnu.domain.Member;

@RestController
@RequestMapping("/api")
public class MemberController {

	@Autowired
	private MemberService memberservice;

	
	// 전체 검색
	@GetMapping("/member")
	public List<Member> getAllMembers(){
		return memberservice.getAllMember();
	}
	
	// 아이디 검색
	@GetMapping("/member/{id}")
	public Member getMemberById(@PathVariable Integer id) {
		return memberservice.getMemberById(id);	
	}
	
	// 회원 추가
	@PostMapping("/member")
	public Member postMember(@RequestBody Member member) {
		return memberservice.postMember(member);
	}
	
	// 전체 수정
	@PutMapping("/member/{id}")
	public Member putMember(@PathVariable Integer id, @RequestBody Member member) {
		return memberservice.putMember(id, member);
	}
	
	// 일부 수정
	@PatchMapping("/member/{id}")
	public Member patchMember(@PathVariable Integer id, @RequestBody Member member) {
		return memberservice.patchMember(id,member);
	}
	
	// 삭제
	@DeleteMapping("/member/{id}")
	public void deleteMember(@PathVariable Integer id) {
		memberservice.deleteMember(id);
	}
}

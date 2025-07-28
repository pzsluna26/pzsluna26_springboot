package edu.pnu.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberDTO;
import edu.pnu.service.MemberService;


//BootMission3: list (가짜데이터) 말고 memberDAO 객체(DB데이터) 가져오기  

@RestController 
@RequestMapping("/api")
public class MemberController {
	
	// CRUD 서비스가 대신처리 
	private MemberService memberService;
	
	// 생성자(외부 서비스객체 들고와서 컨트롤러 클래스의 변수에 저장 => 컨트롤러에서 서비스 객체 쓰려고 )
	public MemberController(MemberService memberService) {
	        this.memberService = memberService;
	    }

	// 전체 검색
	@GetMapping("/member")
	public List<MemberDTO> getAllMember(){
		return memberService.getAllMember();
	}
	
	
	// 아이디 검색
	@GetMapping("/member/{id}")
	public MemberDTO getMemberById(@PathVariable Integer id) {
	    	return memberService.getMemberById(id);
	    }
	

	// 추가 
	@PostMapping("/member")    
	public MemberDTO postMember(@RequestBody MemberDTO memberDTO) {
		return memberService.postMember(memberDTO);
		}
	
	// 전체 수정 
	@PutMapping("/member/{id}")
	public MemberDTO putMember(@PathVariable Integer id, @RequestBody MemberDTO memberDTO) {
		return memberService.putMember(id, memberDTO);
	}
	
	// 일부 수정 
	@PatchMapping("/member/{id}")
	public MemberDTO patchMember(@PathVariable Integer id, @RequestBody MemberDTO memberDTO) {
		return memberService.patchMember(id, memberDTO);
	}
	
	// 삭제
	@DeleteMapping("/member/{id}")
	public void deleteMember(@PathVariable Integer id) {
		memberService.deleteMember(id);
	}
}

	

	

	
	

	
	
	
	
	
	
	
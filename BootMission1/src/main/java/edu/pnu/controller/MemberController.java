package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
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

// membercontroller: 웹 브라우저나 앱에서 들어오는 요청을 받아서,
// 'Member 정보를 주고받는 기능(=API)'을 담당하는 Spring Boot의 "문지기" 역할

@RestController
// @RequestMapping 공통url 
// 	=> http://localhost:8080/api/ ...
@RequestMapping("/api")
public class MemberController {
	
	// 데이터 저장용 객체 생성
	private List<MemberDTO> list = new ArrayList<>();
	
	public MemberController() { 
		//데이터 초기화
		for (int i=1; i<=10; i++) {
			list.add(MemberDTO.builder()
					.id(i).name("name" + i).pass("pass" + i)
					.regidate(new Date()).build());
		}
	}
	
	// 검색(Read –select All): 맴버 리스트 찾아서 리턴
	@GetMapping("/member")
	public List<MemberDTO> getAllMember(){
		return list;
	}
	
	
	// 검색(Read –select One): ID로 특정 멤버만 찾아서 보여주기
	@GetMapping("/member/{id}")
	public MemberDTO getMemberById(@PathVariable Integer id) {
	    for(MemberDTO m : list) {
	    	if(m.getId() == id) {
	    		return m;
	    		}
	    	}
	    	return null;
	    }
	

	// 입력(create - insert): 새 멤버를 리스트에 추가
	@PostMapping("/member")    // JSON으로 들어온 데이터를 MemberDTO 객체로 자동 변환해줍니다.
							   // @RequestBody => 리액트에서 db.json 한것처럼 객체 데이터로 변환됨
	public MemberDTO postMember(@RequestBody MemberDTO memberDTO) {

	    // 1. 전달받은 memberDTO의 id가 비어 있는지(null) 확인합니다.
	    //    → 비어 있다면 기존 list에서 가장 큰 id를 찾아서 +1 한 값으로 설정합니다.
		if(memberDTO.getId() == null) {
			int maxId = 0;
			for(MemberDTO m : list) {
				if(m.getId() > maxId) {
					maxId = m.getId();
				}	
			}
			memberDTO.setId(maxId + 1);
			memberDTO.setRegidate(new Date());
		}
		list.add(memberDTO);
		return memberDTO;
		}
	
	// 수정(Update–객체교체)
	@PutMapping("/member/{id}")
	public MemberDTO putMember(@PathVariable Integer id, @RequestBody MemberDTO memberDTO) {
		for(int i=0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				memberDTO.setId(id);
				memberDTO.setRegidate(new Date());
				list.set(i, memberDTO);
				return memberDTO;
			}
		}
		return null;
	}
	
	// 수정(Update–일부정보수정)
	@PatchMapping("/member/{id}")
	public MemberDTO patchMember(@PathVariable Integer id, @RequestBody MemberDTO memberDTO) {
		for(int i=0; i<list.size(); i++) {
			MemberDTO m = list.get(i);
			if(m.getId() == id) {
				if(memberDTO.getName() != null) m.setName(memberDTO.getName());
				if(memberDTO.getPass() != null) m.setPass(memberDTO.getPass());
				return m;
			}	
		}return null;
	}
	
	// 삭제(Delete -delete)
	@DeleteMapping("/member/{id}")
	public void deleteMember(@PathVariable Integer id) {
		for(int i=0; i<list.size(); i++) {
			MemberDTO m = list.get(i);
			if(m.getId() == id) {
				list.remove(i);
			}
		} 
	}
}

	

	

	
	

	
	
	
	
	
	
	
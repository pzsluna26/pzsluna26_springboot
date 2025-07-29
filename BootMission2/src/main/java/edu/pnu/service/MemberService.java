package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 6ab0409 (upload)
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.Builder;

<<<<<<< HEAD
=======
>>>>>>> branch 'main' of https://github.com/pzsluna26/pzsluna26_SpringBoot.git
=======

>>>>>>> 6ab0409 (upload)
import edu.pnu.domain.MemberDTO;



//BootMission2: 데이터 처리 책임은 Service로 넘기고, Controller는 요청,응답만 처리하게 분리

@Service
public class MemberService {
	
	   // list 객체 생성 (가짜데이터)
		private List<MemberDTO> list = new ArrayList<>();
		
		public MemberService() { 
			//데이터 초기화
			for (int i=1; i<=10; i++) {
				list.add(MemberDTO.builder()
						.id(i).name("name" + i).pass("pass" + i)
						.regidate(new Date()).build());
			}
		}
		
		// 전체 검색
		public List<MemberDTO> getAllMember(){
			return list;
		}
		
		
		// 아이디 검색
		public MemberDTO getMemberById(Integer id) {
		    for(MemberDTO m : list) {
		    	if(m.getId() == id) {
		    		return m;
		    		}
		    	}
		    	return null;
		    }
		

		// 추가 
		public MemberDTO postMember(MemberDTO memberDTO) {
		    //  전달받은 memberDTO의 id가 비어 있는지(null) 확인
		    //  → 비어 있다면 기존 list에서 가장 큰 id를 찾아서 +1 한 값으로 설정 
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
		
		// 전체 수정 
		public MemberDTO putMember(Integer id, MemberDTO memberDTO) {
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
		
		// 일부 수정 
		public MemberDTO patchMember(Integer id, MemberDTO memberDTO) {
			for(int i=0; i<list.size(); i++) {
				MemberDTO m = list.get(i);
				if(m.getId() == id) {
					if(memberDTO.getName() != null) m.setName(memberDTO.getName());
					if(memberDTO.getPass() != null) m.setPass(memberDTO.getPass());
					return m;
				}	
			}return null;
		}
		
		// 삭제
		public void deleteMember(Integer id) {
			for(int i=0; i<list.size(); i++) {
				MemberDTO m = list.get(i);
				if(m.getId() == id) {
					list.remove(i);
				}
			} 
		}
}

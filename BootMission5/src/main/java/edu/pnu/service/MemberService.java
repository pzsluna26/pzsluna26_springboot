package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberDTO;

//DI 방법  

@Service
public class MemberService {
	
		@Autowired
		private MemberDao memberDao;
		
		// 외부에서 DAO 객체 가져옴 (서비스에서 DAO메서드 쓰려고)
		public MemberService() {
			memberDao = new MemberDao();
		}
		
		// 전체 검색 
		public List<MemberDTO> getAllMember(){
			return memberDao.getAllMember();
		}
		
		
		// 아이디 검색 
		public MemberDTO getMemberById(Integer id) {
		    return memberDao.getMemberById(id);
		}
		
		// 입력(create - insert): 새 멤버를 리스트에 추가
		public MemberDTO postMember(MemberDTO memberDTO) {
			return memberDao.postMember(memberDTO);
		}
		
		// 전체 수정 
		public MemberDTO putMember(Integer id, MemberDTO memberDTO) {
			return memberDao.putMember(id, memberDTO);
		}
		
		// 일부 수정 
		public MemberDTO patchMember(Integer id, MemberDTO memberDTO) {
			return memberDao.patchMember(id, memberDTO);
		}
		
		// 삭제 
		public void deleteMember(Integer id) {
			memberDao.deleteMember(id);
		}
}

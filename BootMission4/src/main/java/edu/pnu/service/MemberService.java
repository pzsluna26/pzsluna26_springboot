package edu.pnu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberDTO;



// BootMission4: DB 작업을 추적하고 기록(Log) 

@Service
public class MemberService {
	
		private MemberDao memberDao;
		private LogDao logDao;
		
		public MemberService() {
			// 회원 관련 처리 
			memberDao = new MemberDao();
			// 로그 기록 처리 
			logDao = new LogDao();
		}
		
		// 검색
		public List<MemberDTO> getAllMember() {
			
			
			return ;
		}
		
		
		// 아이디 검색
		public MemberDTO getMemberById(Integer id) {
			return ;
		}
		
		// 추가 
		public MemberDTO postMember(MemberDTO memberDTO) {
			return ;
		}
		
		// 수정 
		public MemberDTO putMember(Integer id, MemberDTO memberDTO) {
			
	        return ;
		}
		
		// 일부 수정 
		public MemberDTO patchMember(Integer id, MemberDTO memberDTO) {
			return;
		}
		
		// 삭제 
		public void deleteMember(Integer id) {
			
		}
		
		
}

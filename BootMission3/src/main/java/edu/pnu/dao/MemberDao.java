package edu.pnu.dao; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.MemberDTO;

// BootMission3: list (가짜데이터) 말고 memberDAO 객체(DB데이터) 가져오기  

public class MemberDao {
	private Connection con;
	
	// DB 연결 
	public MemberDao() {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/bootmission", "musthave", "tiger");
	        System.out.println("DB 연결 성공");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	// 전체 검색 
	public List<MemberDTO> getAllMember(){
		List<MemberDTO> list = new ArrayList<>();
		String query = "SELECT * FROM member";
		try(PreparedStatement psmt = con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery()){
			while (rs.next()) {
				MemberDTO m = new MemberDTO();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setPass(rs.getString("pass"));
				m.setRegidate(rs.getDate("regidate"));
				list.add(m);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	// 아이디 검색
	public MemberDTO getMemberById(Integer id) {
		String query = "SELECT * FROM member WHERE id=?";
		try(PreparedStatement psmt = con.prepareStatement(query)){
			psmt.setInt(1, id);
			try(ResultSet rs = psmt.executeQuery()){
				if(rs.next()) {
					MemberDTO m = new MemberDTO();
					m.setId(rs.getInt("id"));
					m.setName(rs.getString("name"));
					m.setPass(rs.getString("pass"));
					m.setRegidate(rs.getDate("regidate"));
					return m;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 
		return null;
	 }
	
	
	// 추가 
	public MemberDTO postMember(MemberDTO memberDTO) {
		String query = "INSERT INTO member (name, pass) VALUES(?,?)";
		try(PreparedStatement psmt = con.prepareStatement(query)) {
			psmt.setString(1, memberDTO.getName());
			psmt.setString(2, memberDTO.getPass());
			psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} 
		return memberDTO;
	}
	
	// 전체 수정
	public MemberDTO putMember(Integer id, MemberDTO memberDTO) {
		String query = "UPDATE member SET name=?, pass=? WHERE id=?";
		try(PreparedStatement psmt = con.prepareStatement(query)) {
			psmt.setString(1, memberDTO.getName());
			psmt.setString(2, memberDTO.getPass());
			psmt.setInt(3, id);
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return memberDTO;
		
	}
	
	// 일부 수정
	public MemberDTO patchMember(Integer id, MemberDTO memberDTO) {
		String query = "UPDATE member SET ";
		// 수정할 값이 있는지 확인 
		boolean hasPass = memberDTO.getPass() != null;
		boolean hasName = memberDTO.getName() != null;
		
		// 둘 다 없으면 수정할것 없으니 끝  
		if(!hasPass && !hasName) return null;
		// 상황에 맞는 쿼리 만들기
		// 1. 비밀번호만 수정할때 
		if(hasPass) query += "pass=?";
		// 2. 둘 다 수정할때 
		if(hasPass && hasName) query += " , ";
		// 3. 이름만 수정할때 
		if(hasName) query += "name=?";
		// 수정할 대상(id)이 누군지 지정 
		query += " WHERE id=?";
		
		try (PreparedStatement psmt = con.prepareStatement(query)) {
			// 물음표 자리 
			int cnt = 1;
			
			// 이름이 있으면 먼저 설정 
			if(hasName) psmt.setString(cnt++, memberDTO.getName());
			
			// 비밀번호가 있으면 그 다음 물음표 자리로 넘어가기 
			if(hasPass) psmt.setString(cnt++, memberDTO.getPass());
			
			// 마지막으로 조건(id) 설정 
			psmt.setInt(cnt, id);
			
			// DB반영 
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberDTO;
	}
	
	// 삭제
	public void deleteMember(Integer id) {
		String query = "DELETE FROM member WHERE id=?";
		try(PreparedStatement psmt = con.prepareStatement(query)) {
			psmt.setInt(1, id);
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
	    try {
	        if (con != null) con.close();
	        System.out.println("DB 연 해제");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}


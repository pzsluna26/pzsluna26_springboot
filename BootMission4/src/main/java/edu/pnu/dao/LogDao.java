package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

// BootMission4: DB 작업을 추적하고 기록(Log) 

public class LogDao { 
	private Connection con;

	public LogDao() {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/bootmission", "musthave", "tiger");
	        System.out.println("DB 연결 성공");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	// 로그 기록 저장하는 메서드 
	public void addLog(Map <String, Object> map) {
		String query = "INSERT INTO dblog (method, sqlstring, success) VALUES (?,?,?)";
		try (PreparedStatement psmt = con.prepareStatement(query)) {
			psmt.setString(1, (String) map.get("method"));
			psmt.setString(2, (String) map.get("sqlstring"));
			psmt.setBoolean(3, (Boolean) map.get("success"));
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

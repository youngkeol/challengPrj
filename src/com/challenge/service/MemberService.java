package com.challenge.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.challenge.entity.Board;
import com.challenge.entity.Comment;
import com.challenge.entity.Member;

public class MemberService {

	public int getInfo(String memId) {
		
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql = "select * from MEMBER where MEMID = ?";
		int memNum = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			PreparedStatement st = con.prepareStatement(sql);			
		
			st.setString(1, memId);
			
			ResultSet rs = st.executeQuery();
			try {
				if(rs.next()) {
					memNum = rs.getInt("MEMNUM");
				}
				
			}finally{
				rs.close();
				st.close();
				con.close();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memNum; 
	}
	
	public int getLogin(String memId, String memPw){
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql = "select * from MEMBER where MEMID = ?";
				
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			PreparedStatement st = con.prepareStatement(sql);			
		
			st.setString(1, memId);
			
			ResultSet rs = st.executeQuery();
			try {
				if(rs.next()){
					if(rs.getString("MEMPW").equals(memPw)) {
						return 1; //로그인 성공
					}else {
						return -1; //비번이 틀린경우
					}
					
				}else {
					return -1; //아이디가 없는경우
				}
			}finally{
				rs.close();
				st.close();
				con.close();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1; 
	}

	
	public void getJoin(String memId, String memPw, String memName, String memGen, String memEmail){
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql = "insert into MEMBER values (MEM_SEQ.nextval ,?, ?, ?, ?, ?)";
				
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			PreparedStatement st = con.prepareStatement(sql);			
		
			st.setString(1, memId);
			st.setString(2, memPw);
			st.setString(3, memName);
			st.setString(4, memGen);
			st.setString(5, memEmail);
			int result = st.executeUpdate();
			
			st.close();
			con.close();	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public String getId(String email) {
		String memId = null;
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql = "select MEMID from MEMBER where MEMEMAIL = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			PreparedStatement st = con.prepareStatement(sql);			
		
			st.setString(1, email);
			
			ResultSet rs = st.executeQuery();
			
			try {
				if(rs.next()) {
					memId = rs.getString("MEMID");
				}
				
			}finally{
				rs.close();
				st.close();
				con.close();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memId; 
	}
	
	public String getPw(String id, String email) {
		String memPw = null;
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql = "select MEMPW from MEMBER where MEMEMAIL = ? and MEMID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			PreparedStatement st = con.prepareStatement(sql);			
		
			st.setString(1, email);
			st.setString(2, id);
			
			ResultSet rs = st.executeQuery();
			
			try {
				if(rs.next()) {
					memPw = rs.getString("MEMPW");
				}
				
			}finally{
				rs.close();
				st.close();
				con.close();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memPw; 
	}
	
	
	public int getCount() {
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql ="select count(*) memcount from MEMBER";
		
	

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			Statement st = con.createStatement();			
			
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()){
				result = rs.getInt("memcount");
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int checkId(String idValue) {
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql ="select * from MEMBER where MEMID = ?";
		
	

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			PreparedStatement st = con.prepareStatement(sql);			
			
			st.setString(1, idValue);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				//아이디가 존재하면
				result = 0;
			}else {
				//아이디가 존재하지 않으면
				result = 1;
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int checkEmail(String emailValue) {
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql ="select * from MEMBER where MEMEMAIL = ?";
		
	

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			PreparedStatement st = con.prepareStatement(sql);			
			
			st.setString(1, emailValue);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				//이메일이 존재하면
				result = 0;
			}else {
				//이메일이 존재하지 않으면
				result = 1;
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}



}

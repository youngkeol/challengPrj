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

import com.challenge.entity.Comment;
import com.challenge.service.entity.CommentList;

public class CommentService {
	
	public List<CommentList> getCommentList(int boardNum) {
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql ="select * from B_COMMENT_VIEW where BOARDNUM = ? order by COMDATE asc";
		
		List<CommentList> comList = new ArrayList<CommentList>();	

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			PreparedStatement st = con.prepareStatement(sql);			
		
			st.setInt(1, boardNum);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				int comNum = rs.getInt("COMNUM");
				String comContent = rs.getString("COMCONTENT");
				Date comDate = rs.getDate("COMDATE");
				String memName= rs.getString("MEMNAME");
	

				
				CommentList comment = new CommentList(
						comNum,
						comContent,
						comDate,
						memName,
						boardNum
				);
				
				comList.add(comment);
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return comList;
		
	}
	
	
	public int addComment(Comment comment) {
		int result = 0;
		
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql ="insert into B_COMMENT values(COM_SEQ.NEXTVAL, ? ,SYSDATE ,? ,?)";
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, comment.getComContent());
			st.setInt(2, comment.getMemNum());
			st.setInt(3, comment.getBoardNum());
//			System.out.println(comment.getComContent());
//			System.out.println(comment.getMemNum());
//			System.out.println(comment.getMemNum());
			
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
			System.out.println("댓글 추가 완료");
		
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return result;
		
	}

	public int delComment(Comment comment) {
		int result = 0;
		
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql ="DELETE FROM B_COMMENT WHERE  COMNUM = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, comment.getComNum());
			result = st.executeUpdate();
		
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	
	
	
	
	
	public Comment getComment() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getCount() {
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql ="select count(*) comcnt from b_comment";
		
	

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			Statement st = con.createStatement();			
			
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()){
				result = rs.getInt("comcnt");
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

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
import com.challenge.service.entity.BoardList;
import com.challenge.service.entity.BoardView;

public class BoardService {
	
	public List<BoardList> getBoardList(){
		return getBoardList("BoardTit", "", 1);
	}
	public List<BoardList> getBoardList(int page){
		return getBoardList("BoardTit","", page);
	}
	
	public List<BoardList> getBoardList(String field, String query, int page){
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql ="select * from(" +
				"select ROWNUM NUM, B.* from " +
				"(select * from BOARD join MEMBER on MEMBER.MEMNUM = BOARD.MEMNUM order by regdate desc) B where " + field + " like ? "+
				") where NUM between ? and ?";
				
	
				
		//1, 11, 21, 31 ==> 1 +(n-1)10 
		//10, 20, 30 40 ==> n * 10
		
		List<BoardList> list = new ArrayList<BoardList>();
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			PreparedStatement st = con.prepareStatement(sql);			
		
			st.setString(1, "%"+ query + "%");
			st.setInt(2, 1+(page-1)*10);
			st.setInt(3, page*10);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				int boardNum = rs.getInt("BOARDNUM");
				String boardTit = rs.getString("BOARDTIT");
				String boardContent = rs.getString("BOARDCONTENT");
				Date regdate = rs.getDate("REGDATE");
				String memName = rs.getString("MEMNAME");
				int boardHit = rs.getInt("BOARDHIT");
				
				
				BoardList boardList = new BoardList(
						boardNum,
						boardTit,
						memName,
						regdate,
						boardHit
				);
				
				list.add(boardList);
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	
	
	
	public int getBoardCount() {
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		return getBoardCount("BoardTit", "");
	}
	
	public int getBoardCount(String field, String query) {
		
		
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql = "select COUNT(BOARDNUM) COUNT from (" +
	    		"select ROWNUM NUM, B.* from (" +
				"select * from BOARD join MEMBER on MEMBER.MEMNUM = BOARD.MEMNUM order by regdate desc) B where " + field + " like ?)";				
				
		
		int count = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			PreparedStatement st = con.prepareStatement(sql);			
		
			st.setString(1, "%"+ query + "%");
			
			
			ResultSet rs = st.executeQuery();
			if(rs.next())
				count = rs.getInt("count");
			
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public BoardView getBoard(int boardNum) {
		BoardView boardView = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql = "select * from BOARD join MEMBER on BOARD.MEMNUM = MEMBER.MEMNUM where BOARDNUM=?";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			PreparedStatement st = con.prepareStatement(sql);			

			st.setInt(1, boardNum);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				String boardTit = rs.getString("BOARDTIT");
				String boardContent = rs.getString("BOARDCONTENT");
				Date regdate = rs.getDate("REGDATE");
				String memName= rs.getString("MEMNAME");
				int boardHit = rs.getInt("BOARDHIT");
				
				
				boardView = new BoardView(
						boardNum,
						boardTit,
						memName,
						regdate,
						boardHit,
						boardContent
				); 
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardView;
		
	}
	
	
	
	//글등록
	public int insert(Board board) {
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql ="insert into BOARD values(BOARD_SEQ.nextval , ?, ?, SYSDATE, ?, 0 )";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			PreparedStatement st = con.prepareStatement(sql);			
		
			st.setString(1, board.getBoardTit());
			st.setString(2, board.getBoardContent());
			st.setInt(3, board.getMemId());
			
			result = st.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	//글등록후 글번호 가져오기
	public int getBoardNum() {
		int boardNum = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql ="select ROWNUM, B.BOARDNUM from(" + 
				"select * from BOARD order by REGDATE desc" + 
				") B WHERE ROWNUM = 1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");		
			Statement st = con.createStatement();  
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				boardNum = rs.getInt("BOARDNUM");
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardNum;
		
	}
	
	
	//메인페이지 글개수 가져오기
	public int getCount() {
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql ="select count(*)  boardcnt from BOARD";
		
	

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			Statement st = con.createStatement();			
			
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()){
				result = rs.getInt("boardcnt");
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
	
	
	public int updateHit(int boardNum) {	
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/JAVA";
		String sql ="update board set boardHit = boardHit + 1 where boardnum = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "challenge", "1234");
			PreparedStatement st = con.prepareStatement(sql);			
		
			st.setInt(1,boardNum);
	
			result = st.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

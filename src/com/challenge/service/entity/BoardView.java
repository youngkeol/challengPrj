package com.challenge.service.entity;

import java.util.Date;

public class BoardView {
	private int boardNum;
	private String boardTit;
	private String memName;
	private Date regdate;
	private int boardHit;
	private String boardContent;
	
	
	public BoardView() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardView(int boardNum, String boardTit, String memName, Date regdate, int boardHit, String boardContent) {
		this.boardNum = boardNum;
		this.boardTit = boardTit;
		this.memName = memName;
		this.regdate = regdate;
		this.boardHit = boardHit;
		this.boardContent = boardContent;
	}
	

	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardTit() {
		return boardTit;
	}
	public void setBoardTit(String boardTit) {
		this.boardTit = boardTit;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	@Override
	public String toString() {
		return "BoardView [boardNum=" + boardNum + ", boardTit=" + boardTit + ", memName=" + memName + ", regdate="
				+ regdate + ", boardHit=" + boardHit + ", boardContent=" + boardContent + "]";
	}
	
	
	
}

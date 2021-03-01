package com.challenge.service.entity;

import java.util.Date;

public class BoardList {
	private int boardNum;
	private String boardTit;
	private String memName;
	private Date regdate;
	private int boardHit;
	
	
	public BoardList() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardList(int boardNum, String boardTit, String memName, Date regdate, int boardHit) {
		this.boardNum = boardNum;
		this.boardTit = boardTit;
		this.memName = memName;
		this.regdate = regdate;
		this.boardHit = boardHit;
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

	@Override
	public String toString() {
		return "BoardList [boardNum=" + boardNum + ", boardTit=" + boardTit + ", memName=" + memName + ", regdate="
				+ regdate + ", boardHit=" + boardHit + "]";
	}
}

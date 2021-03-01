package com.challenge.entity;

import java.sql.Date;

public class Board {
	private int boardNum;
	private String boardTit;
	private int memId;
	private Date regdate;
	private int boardHit;
	private String boardContent;
	
	public Board() {
	}
	
	public Board(String boardTit, int memberId, String boardContent) {
		this(0, boardTit, memberId, null, 0, boardContent);
	}
	
	public Board(int boardNum, String boardTit, int memId, Date regdate, int boardHit, String boardContent) {
		this.boardNum = boardNum;
		this.boardTit = boardTit;
		this.memId = memId;
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

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
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
		return "Board [boardNum=" + boardNum + ", boardTit=" + boardTit + ", memId=" + memId + ", regdate=" + regdate
				+ ", boardHit=" + boardHit + ", boardContent=" + boardContent + "]";
	}
}

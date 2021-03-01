package com.challenge.entity;

import java.sql.Date;

public class Comment {
	private int comNum;
	private String comContent;
	private Date comDate;
	private int memNum;
	private int boardNum;
	
	
	public Comment() {
	
	}
	public Comment(String comContent, int memNum, int boardNum) {
		this.comContent = comContent;
		this.memNum = memNum;
		this.boardNum = boardNum;
	}
	
	public Comment(int comNum, String comContent, Date comDate, int memNum, int boardNum) {
		this.comNum = comNum;
		this.comContent = comContent;
		this.comDate = comDate;
		this.memNum = memNum;
		this.boardNum = boardNum;
	}
	
	public int getComNum() {
		return comNum;
	}
	public void setComNum(int comNum) {
		this.comNum = comNum;
	}
	public String getComContent() {
		return comContent;
	}
	public void setComContent(String comContent) {
		this.comContent = comContent;
	}
	public Date getComDate() {
		return comDate;
	}
	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	
	
	

}

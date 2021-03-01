package com.challenge.service.entity;

import java.util.Date;

public class CommentList {
	private int comNum;
	private String comContent;
	private Date comDate;
	private String memName;
	private int boardNum;
	
	
	public CommentList() {
		// TODO Auto-generated constructor stub
	}
	
	public CommentList(int comNum, String comContent, Date comDate, String memName, int boardNum) {
		this.comNum = comNum;
		this.comContent = comContent;
		this.comDate = comDate;
		this.memName = memName;
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
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	@Override
	public String toString() {
		return "CommentList [comNum=" + comNum + ", comContent=" + comContent + ", comDate=" + comDate + ", memName="
				+ memName + ", boardNum=" + boardNum + "]";
	}
	
	
	
	
}

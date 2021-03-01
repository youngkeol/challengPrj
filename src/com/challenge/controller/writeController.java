package com.challenge.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.challenge.entity.Board;
import com.challenge.service.BoardService;
import com.challenge.service.MemberService;

@WebServlet("/write")
public class writeController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String boardTit = request.getParameter("boardTit");
		String boardContent = request.getParameter("boardContent");
		int memberId = (int) session.getAttribute("sessionNum");
		
		
		
		Board board = new Board( boardTit, memberId, boardContent);
		System.out.println(board.toString());
		
		BoardService boardService = new BoardService();
		boardService.insert(board);
		int boardNum = boardService.getBoardNum();
		System.out.println(boardNum);
		
		response.sendRedirect("/challengPrj/board/detail?boardNum=" + boardNum);
	}
}



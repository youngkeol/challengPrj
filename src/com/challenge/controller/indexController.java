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

import com.challenge.entity.Board;
import com.challenge.service.BoardService;
import com.challenge.service.CommentService;
import com.challenge.service.MemberService;

@WebServlet("/index")
public class indexController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//멤버수
		MemberService memService = new MemberService();
		int memCount = memService.getCount();
		
		//글개수
		BoardService service = new BoardService();
		int boardCount = service.getCount();
		
		
		//댓글개수
		CommentService comServiece = new CommentService();
		int commentCount = comServiece.getCount();
		
		System.out.println(memCount);
		System.out.println(boardCount);
		System.out.println(commentCount);
		
		request.setAttribute("memCount", memCount);
		request.setAttribute("boardCount", boardCount);
		request.setAttribute("commentCount", commentCount);
		
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);	
		//response.sendRedirect("index.jsp");
	}
}



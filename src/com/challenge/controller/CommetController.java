package com.challenge.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.challenge.entity.Comment;
import com.challenge.service.CommentService;

//AJAX사용으로 사용 안함
//@WebServlet("/board/comment")
public class CommetController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String comContent = request.getParameter("comcontent");
		int memNum = Integer.parseInt(request.getParameter("membernum"));
		int boardNum = Integer.parseInt(request.getParameter("boardnum"));
		
		System.out.println(comContent);
		System.out.println(memNum);
		System.out.println(boardNum);
		Comment comment = new Comment(comContent, memNum, boardNum);
		CommentService service = new CommentService();
		
		service.addComment(comment);
		
		response.sendRedirect("detail?boardnum="+ boardNum);	
	}
}

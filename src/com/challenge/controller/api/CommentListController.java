package com.challenge.controller.api;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.challenge.entity.Comment;
import com.challenge.service.CommentService;
import com.challenge.service.entity.CommentList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//데이터만 주는 컨트롤
@WebServlet("/api/comment/list")
public class CommentListController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		

		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String content = request.getParameter("content");
		int memNum = Integer.parseInt(request.getParameter("memNum"));
		
		//insert
		CommentService comServiece = new CommentService();
		Comment comment = new Comment(content, memNum, boardNum);
		System.out.println(comment.toString());
		comServiece.addComment(comment);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		System.out.println(request.getParameter("boardNum"));
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
				
		CommentService comServiece = new CommentService();
		List<CommentList>  commentList = comServiece.getCommentList(boardNum);
		System.out.println("commentList : " + commentList);
		
		 
//		String json = "[";
//		
//		for(int i =0; i<commentList.size(); i++) {
//			CommentList comList = commentList.get(i);
//			json += String.format("{\"memName\":\"%s\", \"comDate\":\"%s\", \"comContent\":\"%s\" }", comList.getMemName(), comList.getComDate(), comList.getComContent());
//			
//			if(commentList.size() > i+1) {
//				json +=",";
//			}
//		}
//		json += "]";
		
		Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); 
		System.out.println(json.toJson(commentList));
		response.getWriter().print(json.toJson(commentList));
	}
	
}

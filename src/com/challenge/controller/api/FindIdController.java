package com.challenge.controller.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.challenge.service.MemberService;
import com.google.gson.Gson;


@WebServlet("/api/findId")
public class FindIdController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
//		String btn = request.getParameter("idBtn");
//		System.out.println(btn);
		System.out.println(request.getParameter("email"));
		String email = request.getParameter("email");
		
	
		MemberService memService = new MemberService();
		String findId = memService.getId(email);
		
		System.out.println(findId);
		String json = new Gson().toJson(findId);
		System.out.println(json);
		response.getWriter().println(json);
	}

}

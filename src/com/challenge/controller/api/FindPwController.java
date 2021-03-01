package com.challenge.controller.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.challenge.service.MemberService;
import com.google.gson.Gson;


@WebServlet("/api/findPw")
public class FindPwController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		
		String id= request.getParameter("id");
		String email = request.getParameter("email");
		System.out.println("id");
		System.out.println("email");
	
		MemberService memService = new MemberService();
		String findPw = memService.getPw(id, email);
		
		System.out.println(findPw);
		String json = new Gson().toJson(findPw);
		System.out.println(json);
		response.getWriter().println(json);
	}

}

package com.challenge.controller.api;

import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.challenge.service.MemberService;
import com.google.gson.Gson;


@WebServlet("/api/idCheck")
public class idCheckController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String idValue = request.getParameter("idValue");
		System.out.println("idValue : " + idValue);
	
		MemberService memService = new MemberService();
		int idValueCheck = memService.checkId(idValue);
		//아이디가 존재하면 0, 존재하지 않으면 1 반환
		System.out.println(idValueCheck);
		
		response.getWriter().println(idValueCheck);
	}

}

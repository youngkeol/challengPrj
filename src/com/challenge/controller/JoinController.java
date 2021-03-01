package com.challenge.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.challenge.service.MemberService;

@WebServlet("/join")
public class JoinController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memName = request.getParameter("memName");
		String gen = request.getParameter("gen");
		String memGen = null;
		if(gen.equals("남")){
			memGen = "1";
		} else {
			memGen = "2";
		}
		
		String email = request.getParameter("email");
		String email2 = request.getParameter("email2");
		String memEmail = email + "@" + email2;

		session.setAttribute("memID", memId);
		MemberService memService = new MemberService();
		memService.getJoin(memId, memPw, memName, memGen, memEmail);
		response.sendRedirect("/challengPrj/login");
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
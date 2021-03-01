package com.challenge.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.challenge.service.MemberService;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String returnUrl = request.getParameter("return-url");
		System.out.println("returnUrl : " + returnUrl);
		
		if(returnUrl != null )
			request.setAttribute("returnUrl", returnUrl);
	

		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		
		String returnUrl = request.getParameter("return-url");
		
		String memId = request.getParameter("id");		
		String memPw = request.getParameter("pw");

		
		MemberService mService = new MemberService();
		int loginResult = mService.getLogin(memId,memPw);
		
		if(loginResult == 1) {
			//로그인 성공
			int memNum = mService.getInfo(memId);
			session.setAttribute("sessionId", memId);
			session.setAttribute("sessionNum", memNum);
			
			if(returnUrl !=null && !returnUrl.equals("")) {
				//돌아갈 주소가 있음
				response.sendRedirect(returnUrl);
				return;
			}else {
				response.sendRedirect("index");
				return;
			}
		
			
		}else if(loginResult == -1){
			//로그인실패
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}
	
}



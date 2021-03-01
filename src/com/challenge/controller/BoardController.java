package com.challenge.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.challenge.service.BoardService;
import com.challenge.service.entity.BoardList;

@WebServlet("/board")
public class BoardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String field_ = request.getParameter("field");	
		String query_ = request.getParameter("search");
		String page_ = request.getParameter("page");
	
		String field="BoardTit";
		if(field_ != null && !field_.equals("")) {
			field = field_;
		}
		
		String query ="";
		if(query_ != null && !query_.equals("")) {
			query = query_;
		}
		
		int page = 1;
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		
		
		System.out.println("field : " + field);
		System.out.println("seach : " + query);
		
		BoardService service = new BoardService();
		List<BoardList> list = service.getBoardList(field, query, page);
		int count = service.getBoardCount(field, query);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.getRequestDispatcher("WEB-INF/view/board.jsp").forward(request, response);
	}
}



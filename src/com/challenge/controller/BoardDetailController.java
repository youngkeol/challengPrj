package com.challenge.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.challenge.service.BoardService;
import com.challenge.service.CommentService;
import com.challenge.service.entity.BoardView;
import com.challenge.service.entity.CommentList;

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		BoardService service = new BoardService();
		
		//조회수 증가
		int boardHit = service.updateHit(boardNum);
		
		//데이터 가져오기
		BoardView board = service.getBoard(boardNum);
		
		CommentService comService = new CommentService();
		List<CommentList> comList = comService.getCommentList(boardNum);
		
		
		request.setAttribute("b", board);
		request.setAttribute("comList", comList );
		
		//forword
		request.getRequestDispatcher("/WEB-INF/view/detail.jsp").forward(request, response);

	}
}

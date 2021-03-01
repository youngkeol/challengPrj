package com.challenge.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(
  urlPatterns = {"/*"}
)
public class SecurityFilter implements Filter {

	private final static String[] authURLs = { 
			"/write",
	};
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
	//	System.out.printf("uri %s \n ", uri);
		
		boolean requireAuth = false;
		
		//인증이 필요한 URL 확인
		for(String authUrl : authURLs) {
			if(uri.contains(authUrl)) {
				requireAuth = true;
				break;
			}
		}
		
		
		//인증에 필요한 url인가 ?  인증이 있는가?
		if(requireAuth && session.getAttribute("sessionId") == null) {
			response.sendRedirect("login?return-url=" + uri);
			
			return;
		}
		
		
		chain.doFilter(req, resp);
	}

}

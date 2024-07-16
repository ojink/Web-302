package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import level5.SearchLevel5;

@WebServlet("*.l5")
public class L5Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getServletPath();
		String view = null;
		boolean redirect = false;
		
		
		//제조사명 조회화면 요청
		if( uri.equals("/search.l5") ) {
			
			//응답화면
			view = "level5/search.jsp";
		}
		
		if( redirect )
			response.sendRedirect(view);
		else
			request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getServletPath();
		String view = null;
		boolean forward = true;
		
		//제조사명 조회처리 요청
		if( uri.equals("/search.l5") ) {
			//비지니스로직
			new SearchLevel5().exec(request, response);
			
			//응답화면
			view = "level5/result.jsp";
		}
		
		if( forward )
			request.getRequestDispatcher(view).forward(request, response);
		else
			response.sendRedirect(view);
		
	}

}

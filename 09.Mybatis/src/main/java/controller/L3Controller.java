package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import level3.InsertCommand;
import level3.ListCommand;

@WebServlet("*.l3")
public class L3Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getServletPath();
		String view = null;
		boolean forward = true;
		
		//L3문제 목록화면 요청
		if( uri.equals("/list.l3") ) {
			//비니지스로직
			new ListCommand().exec(request, response);
			
			//응답화면
			view = "l3/list.jsp";
		}
		//신규등록화면 요청
		else if( uri.equals("/register.l3") ) {
			
			//응답화면
			view = "l3/register.jsp";
		}
		//신규회원등록처리 요청
		else if( uri.equals("/insert.l3") ) {
			//비지니스로직
			new InsertCommand().exec(request, response);
			
			//응답화면
			forward = false;
			view = "list.l3";
		}
		
		
		
		if( forward ) {
			request.getRequestDispatcher(view).forward(request, response);
		}else {
			response.sendRedirect(view);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

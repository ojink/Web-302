package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import custom_01.CustomInfo;
import custom_01.CustomList;

@WebServlet("*.l3")
public class L3Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getServletPath();
		String view = null;
		Command custom = null;
		
		//회원목록 조회 요청
		if( uri.equals("/list.l3") ) {
			//비지니스로직
			custom = new CustomList();
			custom.exec(request, response);
			
			//응답화면
			view = "custom/list.jsp";
		}
		//회원정보 조회 요청
		else if( uri.equals("/info.l3") ) {
			//비지니스로직
			custom = new CustomInfo();
			custom.exec(request, response);
			
			//응답화면
			view = "custom/info.jsp";
		}
		
		request.getRequestDispatcher(view).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

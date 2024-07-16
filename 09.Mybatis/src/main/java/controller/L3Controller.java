package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import level3.DeleteLevel3;
import level3.InfoCommand;
import level3.InsertCommand;
import level3.ListCommand;
import level3.UpdateLevel3;

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
		//선택한 회원정보화면 요청
		else if( uri.equals("/info.l3")) {
			//비지니스로직
			new InfoCommand().exec(request, response);
			
			//응답화면
			view = "l3/info.jsp";
		}
		//선택한 회원정보 수정화면 요청
		else if( uri.equals("/modify.l3") ) {
			//비지니스로직
			new InfoCommand().exec(request, response);
			
			//응답화면
			view = "l3/modify.jsp";
		}
		//회원정보 수정 저장처리 요청
		else if( uri.equals("/update.l3")) {
			//비지니스로직
			new UpdateLevel3().exec(request, response);
			
			//응답화면
			view = "info.l3?id=" + request.getParameter("p_id");
			forward = false;
		}
		//선택한 회원정보 삭제처리 요청
		else if( uri.equals("/delete.l3") ) {
			//비지니스로직
			new DeleteLevel3().exec(request, response);
			
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

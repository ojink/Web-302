package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.EmployeeDeleteCommand;
import hr.EmployeeInfo;
import hr.EmployeeInsert;
import hr.EmployeeListCommand;
import hr.EmployeeUpdate;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//주소의 요청 확인
		String uri = request.getServletPath();
		String view = "";
		boolean redirect = false;
		
		if( uri.equals("/select.do") ) {
			//비니지스 로직
			Command command = new EmployeeListCommand();
			command.execute(request, response);
			
			//응답화면 연결
			view = "hr/list.jsp";
			
		}else if( uri.equals("/register.do") ) {
			//신규사원입력화면 요청
			view = "hr/register.jsp";
			
		}else if( uri.equals("/insert.do") ) {
			//비니지스 로직
			new EmployeeInsert().execute(request, response);
			
			//응답화면 연결
			view = "select.do";
			redirect = true;
			
		}else if( uri.equals("/update.do") ) {
			//비니지스 로직
			new EmployeeUpdate().execute(request, response);
			
			//응답화면 연결
			view = "info.do?id=" + request.getParameter("employee_id");
			redirect = true;
			
		}else if( uri.equals("/delete.do") ) {
			//비니지스 로직: DB에서 삭제처리
			//System.out.println("삭제처리");
			Command command = new EmployeeDeleteCommand();
			command.execute(request, response);
			
			//응답화면 연결
			redirect = true;
			view = "select.do";
		}else if( uri.equals("/info.do") ) {
			new EmployeeInfo().execute(request, response);
			
			//응답화면
			view = "hr/info.jsp";					
		}else if( uri.equals("/modify.do")) {
			new EmployeeInfo().execute(request, response);
			
			view = "hr/modify.jsp";
		}
		
		if( redirect ) {
			response.sendRedirect(view);
		}else {
			request.getRequestDispatcher(view).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

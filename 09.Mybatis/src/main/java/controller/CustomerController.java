package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.DeleteCommand;
import customer.InfoCommand;
import customer.InsertCommand;
import customer.ListCommand;
import customer.UpdateCommand;

@WebServlet("*.cu")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getServletPath();
		String view = null;
		boolean redirect = false;
		
		//고객 목록화면 요청
		if( uri.equals("/list.cu") ) {
			//비지니스로직
			new ListCommand().exec(request, response);
			
			//응답화면
			view = "customer/list.jsp";
		}
		//고객 정보화면 요청
		else if( uri.equals("/info.cu") ) {
			//비지니스로직
			new InfoCommand().exec(request, response);
			
			//응답화면
			view = "customer/info.jsp";
		}
		//고객정보 수정화면 요청
		else if( uri.equals("/modify.cu") ) {
			//비니지스로직
			new InfoCommand().exec(request, response);

			//응답화면
			view = "customer/modify.jsp";
		}
		//고객정보 수정저장 처리 요청
		else if( uri.equals("/update.cu") ) {
			//비니지스로직
			new UpdateCommand().exec(request, response);
			
			//응답화면			
			view = "info.cu?id=" + request.getParameter("id");
			redirect = true;
		}
		//고객정보 삭제처리 요청
		else if( uri.equals("/delete.cu") ) {
			//비지니스로직
			new DeleteCommand().exec(request, response);
			
			//응답화면
			redirect = true;
			view = "list.cu";
		}
		//신규고객 등록화면 요청
		else if( uri.equals("/register.cu") ) {
			
			//응답화면
			view = "customer/register.jsp";
		}
		//신규고객정보 신규저장 처리 요청
		else if( uri.equals("/insert.cu") ) {
			//비지니스로직
			new InsertCommand().exec(request, response);
			
			//응답화면
			view = "list.cu";
			redirect = true;
		}
		
		
		
		if( redirect )
			response.sendRedirect(view);
		else
			request.getRequestDispatcher(view).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

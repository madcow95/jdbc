package com.bizpoll.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.action.Action;
import com.bizpoll.action.ActionFoward;
import com.bizpoll.action.IndexAction;

/**
 * Servlet implementation class BizpollFrontController
 */
@WebServlet("/BizpollFrontController")
public class BizpollFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BizpollFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 깨짐 방지(post방식)
		request.setCharacterEncoding("UTF-8");
		
		Action action = null;
		ActionFoward foward = null;
		
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());
		
		System.out.println("uri ===> " + uri);
		System.out.println("ctx ===> " + ctx);
		System.out.println("command ===> " + command);
		
		// ---------------------- 액션 맵핑 ----------------------
		if(command.equals("/index.bizpoll")) {
			action = new IndexAction();
			foward = action.excute(request, response);
		}
		
		// ---------------------- 공통 분기 작업 ----------------------
		if (foward != null) {
			if(foward.isRedirect()) {
				response.sendRedirect(foward.getPath());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(foward.getPath());
				rd.forward(request, response);
			}
		}
	}

}

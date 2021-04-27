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
import com.bizpoll.action.BoardAddAction;
import com.bizpoll.action.BoardFormAction;
import com.bizpoll.action.BoardListAction;
import com.bizpoll.action.ContractAction;
import com.bizpoll.action.DetailAction;
import com.bizpoll.action.FindZipNumAction;
import com.bizpoll.action.IdCheckFormAction;
import com.bizpoll.action.IndexAction;
import com.bizpoll.action.JoinAction;
import com.bizpoll.action.JoinFormAction;
import com.bizpoll.action.LoginAction;
import com.bizpoll.action.LoginAction_Detail;
import com.bizpoll.action.LogoutAction;
import com.bizpoll.action.MybatisLoginAction;
import com.bizpoll.action.UpdateAction;
import com.bizpoll.action.UpdateDetailAction;
import com.bizpoll.boardaction.BoardAction;
import com.bizpoll.boardaction.DeleteAction;
import com.bizpoll.boardaction.DeletePostAction;

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
		// 메인 홈페이지
		if(command.equals("/index.bizpoll")) {
			action = new IndexAction();
			foward = action.excute(request, response);
		}
		// 상품 상세
		else if(command.equals("/product_detail.bizpoll")) {
			action = new DetailAction();
			foward = action.excute(request, response);
		}
		// 회원가입
		else if(command.equals("/contract.bizpoll")) {
			action = new ContractAction();
			foward = action.excute(request, response);
		}
		else if(command.equals("/join_form.bizpoll")) {
			action = new JoinFormAction();
			foward = action.excute(request, response);
		}
		else if(command.equals("/id_check_form.bizpoll")) {
			action = new IdCheckFormAction();
			foward = action.excute(request, response);
		}
		// 로그인
		else if(command.equals("/login.bizpoll")) {
			action = new LoginAction();
			foward = action.excute(request, response);
		}
		else if(command.equals("/login_detail.bizpoll")) {
			action = new LoginAction_Detail();
			foward = action.excute(request, response);
		}
		// 로그아웃
		else if(command.equals("/logout.bizpoll")) {
			action = new LogoutAction();
			foward = action.excute(request, response);
		}
		// 우편번호찾기
		else if(command.equals("/find_zip_num.bizpoll")) {
			action = new FindZipNumAction();
			foward = action.excute(request, response);
		}
		// 회원가입 후 홈으로
		else if(command.equals("/join.bizpoll")) {
			action = new JoinAction();
			foward = action.excute(request, response);
		}
		
		
		// 회원정보수정
		else if(command.equals("/update.bizpoll")) {
			action = new UpdateAction();
			foward = action.excute(request, response);
		}
		else if(command.equals("/update_detail.bizpoll")) {
			action = new UpdateDetailAction();
			foward = action.excute(request, response);
		}
		
		// ---------------------- 게시판 액션 매핑 ----------------------
		
		if(command.equals("/board_list.bizpoll")) {
			action = new BoardListAction();
			foward = action.excute(request, response);
		} else if(command.equals("/boardForm.bizpoll")) {
			action = new BoardFormAction();
			foward = action.excute(request, response);
		} else if(command.equals("/boardAdd.bizpoll")) {
			action = new BoardAddAction();
			foward = action.excute(request, response);
		}
		
		// ---------------------- 게시판 상세 --------------------------
		if(command.equals("/boardView.bizpoll")) {
			action = new BoardAction();
			foward = action.excute(request, response);
		}
		// 게시글 삭제
		else if (command.equals("/delete.bizpoll")) {
			action = new DeleteAction();
			foward = action.excute(request, response);
		}
		else if(command.equals("/delete_post.bizpoll")) {
			action = new DeletePostAction();
			foward = action.excute(request, response);
		}
		
		// ---------------------- myBatis 작업 --------------------------
		
		// 로그인
		if (command.equals("/mybatislogin.bizpoll")) {
			action = new MybatisLoginAction();
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

package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.ProductDAO;

public class JoinAction_Detail implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uri = "member/join_detail.jsp";
		ProductDAO mDao = ProductDAO.getInstance();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String addr = request.getParameter("address");
		String phone = request.getParameter("phone");
		String zip_num = request.getParameter("zip_num");
		System.out.println(id);
		mDao.join(id, pwd, name, email, addr, phone, zip_num);
		ActionFoward forward = new ActionFoward();
		forward.setPath(uri);
		forward.setRedirect(false);
		return forward;
	}

}

package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import com.bizpoll.dao.MemberDAO;*/

public class JoinFormAction implements Action {

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "member/join.jsp";

		/*
		 * MemberDAO mDao = MemberDAO.getInstance(); String id =
		 * request.getParameter("id"); String pwd = request.getParameter("pwd"); String
		 * pwdCheck = request.getParameter("pwdCheck"); String name =
		 * request.getParameter("name"); String email = request.getParameter("email");
		 * String zipCode = request.getParameter("zip_code"); String phone =
		 * request.getParameter("phone");
		 */

		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}

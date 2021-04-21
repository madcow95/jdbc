package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bizpoll.dao.MemberDAO;
import com.bizpoll.dto.MemberDTO;

public class MemberDeleteAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "member/delete.jsp";
		String userID = request.getParameter("id");
		String userPWD = request.getParameter("pwd");
		/* MemberDAO mDao = new MemberDAO(); */
		/* mDao.deleteMember(userID, userPWD); */
		
		HttpSession session = request.getSession();
		session.invalidate();
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}
	
}

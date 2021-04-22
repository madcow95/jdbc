package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bizpoll.dao.MemberDAO;
import com.bizpoll.dto.MemberDTO;

public class DeleteAction_Detail implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "index.bizpoll";
		
		String userID = request.getParameter("id");
		String userPWD = request.getParameter("pwd");
		System.out.println(userID);
		HttpSession session = request.getSession();
		
		MemberDTO mDto = new MemberDTO();
		mDto.setId(userID);
		mDto.setPwd(userPWD);
		
		if (mDto != null) {
			
		}
		session.invalidate();
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.deleteMember(userID, userPWD);
		
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}

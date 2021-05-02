package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.MemberDAO;
import com.bizpoll.dto.MemberDTO;

public class UpdateDetailAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "member/login_fail.jsp";
		String userID = request.getParameter("id");
		String userPWD = request.getParameter("pwd");
		String changePWD = request.getParameter("changepwd");
		
		MemberDTO mDto = new MemberDTO();
		MemberDAO mDao = MemberDAO.getInstance();
		mDto = mDao.getMember(userID);
		if(mDto != null) {
			if(mDto.getPwd().equals(userPWD)) {
				url = "index.bizpoll";
			}
		}
		mDao.update(userID, userPWD, changePWD);
		
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}

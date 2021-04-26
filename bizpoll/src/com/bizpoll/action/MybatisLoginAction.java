package com.bizpoll.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.MemberDAO;
import com.bizpoll.dto.MemberDTO;

public class MybatisLoginAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "member/mybatislogin.jsp";
		MemberDAO mDao = MemberDAO.getInstance();
		
		List<MemberDTO> memList = mDao.mybatisLogin();
		System.out.println(memList.toString());
		request.setAttribute("memList", memList);
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}

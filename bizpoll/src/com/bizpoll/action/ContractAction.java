package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContractAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uri = "member/contract.jsp";
		
		ActionFoward forward = new ActionFoward();
		forward.setPath(uri);
		forward.setRedirect(false);
		return forward;
	}
}

package com.bizpoll.boardaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.action.Action;
import com.bizpoll.action.ActionFoward;
import com.bizpoll.dao.BoardDAO;

public class DeletePostAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "member/login_fail.jsp";
		
		try {
			int articleno = Integer.parseInt(request.getParameter("artino"));
			
			System.out.println("delpostaction artino >> " + articleno);
			
			BoardDAO bDao = BoardDAO.getInstance();
			int result = bDao.boardDel(articleno);
			if(result > 0) {
				url = "board/del_suc.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}

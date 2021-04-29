package com.bizpoll.boardaction;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.action.Action;
import com.bizpoll.action.ActionFoward;

public class DeleteAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "board/deleteBoard.jsp";
		try {
			int articleno = Integer.parseInt(request.getParameter("articleno"));
			System.out.println("delaction articleno >> " + articleno);
			
			Map<String, Integer> delPost = new HashMap<String, Integer>();
			delPost.put("articleno", articleno);
			
			request.setAttribute("delPost", delPost);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}

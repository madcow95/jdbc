package com.bizpoll.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardReplyFormAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "board/boardReplyForm.jsp";
		
			int articleno = Integer.parseInt(request.getParameter("articleno"));
			int ref = Integer.parseInt(request.getParameter("ref"));
			int re_step = Integer.parseInt(request.getParameter("re_step"));
			int re_level = Integer.parseInt(request.getParameter("re_level"));
			System.out.println("BoardReplyFormAction articleno >> " + articleno);
			System.out.println("BoardReplyFormAction ref >> " + ref);
			System.out.println("BoardReplyFormAction re_step >> " + re_step);
			System.out.println("BoardReplyFormAction re_level >> " + re_level);
			
			Map<String, Integer> replyInfo = new HashMap<String, Integer>();
			replyInfo.put("articleno", articleno);
			replyInfo.put("ref", ref);  // map 에서 set은 put
			replyInfo.put("re_step", re_step);
			replyInfo.put("re_level", re_level);
		
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}

}

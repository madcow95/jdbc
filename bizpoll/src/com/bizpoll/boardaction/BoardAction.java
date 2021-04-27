package com.bizpoll.boardaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bizpoll.action.Action;
import com.bizpoll.action.ActionFoward;
import com.bizpoll.dao.BoardDAO;
import com.bizpoll.dto.BoardDTO;

public class BoardAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "board/board_detail.jsp";
		HttpSession session = request.getSession();
		String strArtNo = request.getParameter("articleno");
		BoardDAO bDao = BoardDAO.getInstance();
		
		BoardDTO bDto = bDao.getBoard(strArtNo);
		session.setAttribute("artNo", bDto);
		
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}

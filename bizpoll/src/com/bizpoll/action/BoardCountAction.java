package com.bizpoll.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.BoardDAO;
import com.bizpoll.dto.BoardDTO;

public class BoardCountAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "board_list.bizpoll";
		Integer readcount = Integer.parseInt(request.getParameter("readcount"));
		Integer articleno = Integer.parseInt(request.getParameter("articleno"));
		System.out.println("count action readcount > " + readcount);
		System.out.println("count action articleno > " + articleno);
		BoardDTO bDto = new BoardDTO();
		BoardDAO bDao = BoardDAO.getInstance();
		Map<Object, Integer> count = new HashMap<Object, Integer>();
		count.put(bDto, articleno);
		count.put(bDto, readcount);
		bDto.setArticleno(articleno);
		bDto.setReadcount(readcount);
		System.out.println("bDto artno > " + bDto.getArticleno());
		System.out.println("bDto readcount > " + bDto.getReadcount());
		bDao.readcount(bDto);
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}

}

package com.bizpoll.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.BoardDAO;
import com.bizpoll.dto.BoardDTO;

public class BoardListAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "board/board_list.jsp";
		
		BoardDAO bDao = BoardDAO.getInstance();
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		int section = Integer.parseInt((_section == null) ? "1" : _section);
		int pageNum = Integer.parseInt((_pageNum == null) ? "1" : _pageNum);
		Map<String, Object> pagingMap = new HashMap<String, Object>();
		pagingMap.put("section", section); // put의 String type은 mapper에서 받아온 값
		pagingMap.put("pageNum", pageNum);
		pagingMap.put("searchType", searchType);
		pagingMap.put("searchKeyword", searchKeyword);
		
		List<BoardDTO> boardList = bDao.boardList(pagingMap);
		int boardListAllCnt = bDao.boardListAllCnt(pagingMap);
		int cal = (boardListAllCnt - boardListAllCnt/100*100)-(boardListAllCnt - boardListAllCnt/100*100)/10*10;
		System.out.println("count > " + boardListAllCnt);
		System.out.println("count cal > " + cal);
		Map<String, Object> boardInfo = new HashMap<>();
		
		boardInfo.put("selAllBoardList", boardListAllCnt);
		boardInfo.put("boardList", boardList);
		boardInfo.put("section", section);
		boardInfo.put("pageNum", pageNum);
		boardInfo.put("searchType", searchType);
		boardInfo.put("searchKeyword", searchKeyword);
		
		request.setAttribute("boardInfo", boardInfo);
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}

}

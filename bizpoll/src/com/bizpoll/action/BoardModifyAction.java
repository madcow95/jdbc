package com.bizpoll.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.bizpoll.common.FileUpload;
import com.bizpoll.dao.BoardDAO;
import com.bizpoll.dto.BoardDTO;

public class BoardModifyAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "board/board_list.jsp";
		BoardDTO bDto = new BoardDTO();
		BoardDAO bDao = BoardDAO.getInstance();
		
		Map<String, String> boardMap = FileUpload.upload(request, response);
		int articleNo = Integer.parseInt(boardMap.get("articleno")); 
		String title = boardMap.get("subject");
		String content = boardMap.get("content");
		String originalFileName = boardMap.get("originalFileName");
		String fileName = boardMap.get("filename");
		String savePath = boardMap.get("savePath");
		
		bDto.setSubject(title);
		bDto.setContent(content);
		bDto.setFilename(fileName);
		bDto.setArticleno(articleNo);
		int result = bDao.modify(bDto);
		
		if (fileName != null && fileName.length() != 0) {
			File srcFile = new File(savePath + "\\" + "temp" + "\\" + fileName);
			File destDir = new File(savePath + "\\" + articleNo);
			destDir.mkdirs(); // 디렉토리 생성
			FileUtils.moveFileToDirectory(srcFile, destDir, true);
			
			File oldFile = new File(savePath + "\\" + articleNo + "\\" + originalFileName);
			oldFile.delete();
		}
		response.setContentType("text/html; charset=UTF-8"); // 글자깨짐 방지
		PrintWriter pw = response.getWriter(); // 문자열 처리
		if(result > 0) {
			pw.print("<script>" + " alert('수정완료');" + " location.href='" + "board_list.bizpoll';" + " </script>");
		} else {
			pw.print("<script>" + "alert('수정실패');" + "history.go(-1);" + "</script>");
		}
		return null;
	}

}

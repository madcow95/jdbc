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

public class BoardAddAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardDTO bDto = new BoardDTO();
		BoardDAO bDao = new BoardDAO();
		
		Map<String, String> boardMap = FileUpload.upload(request, response);
		
		int articleNo = bDao.getNewArticleNo(); // bDao method 
		String title = boardMap.get("subject");
		String content = boardMap.get("content");
		String fileName = boardMap.get("filename");
		String savePath = boardMap.get("savePath");
		String id = boardMap.get("id");
		
		bDto.setId(id);
		bDto.setSubject(title);
		bDto.setContent(content);
		bDto.setFilename(fileName);
		bDto.setRef(articleNo + 1);
		bDto.setRe_step(0); // 신규는 0부터 시작?
		bDto.setRe_level(1); // ref : 부모 , re_step : 자식 , re_level : 손자?
		
		System.out.println("BoardAddAction bDTO ==> " + bDto.getFilename()); // 찍어내는게 많으면 헷갈리니 class명과 찍어낼 이름까지 출력시켜서 안헷갈리게
		
		int result = bDao.create(bDto); // bDao method
		
		if (fileName != null && fileName.length() != 0) {
			File srcFile = new File(savePath + "\\" + "temp" + "\\" + fileName);
			File destDir = new File(savePath + "\\" + (articleNo + 1));
			destDir.mkdirs(); // 디렉토리 생성
			FileUtils.moveFileToDirectory(srcFile, destDir, true);
		}
		
		response.setContentType("text/html; charset=UTF-8"); // 글자깨짐 방지
		PrintWriter pw = response.getWriter(); // 문자열 처리
		if(result > 0) {
			pw.print("<script>" + "alert('새글을 추가했습니다.');" + "location.href='" + "board_list.bizpoll';" + "</script>");
		} else {
			pw.print("<script>" + "alert('등록에 실패했습니다.');" + "history.go(-1);" + "</script>");
		}
		return null;
	}

}

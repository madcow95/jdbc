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

public class BoardReplyAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardDTO bDto = new BoardDTO();
		BoardDAO bDao = new BoardDAO();
		
		Map<String, String> boardMap = FileUpload.upload(request, response);
			int parentNo = Integer.parseInt(boardMap.get("ref"));
			int articleno = bDao.getNewArticleNo();
			String subject = boardMap.get("subject");
			String content = boardMap.get("content");
			String fileName = boardMap.get("filename");
			String savePath = boardMap.get("savePath");
			String id = boardMap.get("id");
			System.out.println("bREAc parentno >> " + parentNo);
			int ref = parentNo;
			int re_step = Integer.parseInt(boardMap.get("re_step"));
			int re_level = Integer.parseInt(boardMap.get("re_level"));
			
			bDto.setSubject(subject);
			bDto.setContent(content);
			bDto.setFilename(fileName);
			bDto.setRef(ref);
			bDto.setRe_step(re_step);
			bDto.setRe_level(re_level);
			bDto.setId(id);
			
			int result = 0;
			result = bDao.replyReStepUpdate(bDto);
			result = bDao.create(bDto);
			
			if (fileName != null && fileName.length() != 0) {
				File srcFile = new File(savePath + "\\" + "temp" + "\\" + fileName);
				File destDir = new File(savePath + "\\" + (articleno));
				System.out.println("replAction srcFile>> " + srcFile);
				System.out.println("replAction destDir>> " + destDir);
				destDir.mkdirs(); // 디렉토리 생성
				FileUtils.moveFileToDirectory(srcFile, destDir, true);
			}
			
			response.setContentType("text/html; charset=UTF-8"); // 글자깨짐 방지
			PrintWriter pw = response.getWriter(); // 문자열 처리
			if(result > 0) {
				pw.print("<script>" + "alert('댓글을 추가했습니다.');" + "location.href='" + "board_list.bizpoll';" + "</script>");
			} else {
				pw.print("<script>" + "alert('댓글 등록에 실패했습니다.');" + "history.go(-1);" + "</script>");
			}
		
		return null;
	}

}

package com.bizpoll.common;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload {
	
	public static Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) {
		
		String savePath = "C:\\Users\\choi\\Desktop\\jdbc\\bizpoll\\WebContent\\images\\board";
		Map<String, String> boardMap = new HashMap<String, String>();
		String encodeing = "UTF-8";
		
		File currentDirPath = new File(savePath);
		// commons
		DiskFileItemFactory factory = new DiskFileItemFactory(); // 선행작업
		
		factory.setRepository(currentDirPath); // commons에서 제공해주는 임시영역? 메모리에 저장할 수 있게
		
		factory.setSizeThreshold(10 * 1024 * 1024); // 용량을 10MB 까지만
		
		ServletFileUpload upload = new ServletFileUpload(factory); // servlet에서 정보를 넘겼을 때, ??
		
		try {
			List<FileItem> items = upload.parseRequest(request); 
			
			for (int i = 0; i < items.size(); i++) {
				// 글제목, 글내용, 첨부파일을 하나씩 꺼내오는 반복문?
				FileItem fileItem = (FileItem) items.get(i);
				
				// fileItem에 해당하는 form이 존재한다면
				if (fileItem.isFormField()) { // 파일이 아닐경우
					System.out.println(fileItem.getFieldName() + " = " + fileItem.getString(encodeing));//input type의 name을 찾아온다?
					
					boardMap.put(fileItem.getFieldName(), fileItem.getString(encodeing));
				} else { // 파일일 경우
					System.out.println("파라미터명 : " + fileItem.getFieldName());
					System.out.println("파일크기 : " + fileItem.getSize() + "bytes");
					
					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						
						if(idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx + 1);
						System.out.println("파일명 : " + fileName);
						
						boardMap.put(fileItem.getFieldName(), fileName);
						
						File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
						fileItem.write(uploadFile); // 임시폴더 temp에 임시로 저장
					}
				}
			}
			boardMap.put("savePath", savePath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardMap;
	}
}

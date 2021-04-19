package com.bizpoll.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.ProductDAO;
import com.bizpoll.dto.ProductDTO;

public class IndexAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// action이란 애들은 주소가 들어와야하고 dao를 호출하고 여기서 가지고 노는 장소 main method와 비슷한 역할
		String uri = "index.jsp";
		
		ProductDAO pDao = ProductDAO.getInstance();
		ArrayList<ProductDTO> newProductList = pDao.listNewProduct();
		ArrayList<ProductDTO> bestProductList = pDao.listBestProduct();
		
		
		// 해당객체를 request에 보내주는 역할? name은 화면에서 불러올 위치 이름
		request.setAttribute("newProductList", newProductList);
		request.setAttribute("bestProductList", bestProductList);
		
		ActionFoward forward = new ActionFoward();
		forward.setPath(uri);
		forward.setRedirect(false);
		return forward;
	}

	
}

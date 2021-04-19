package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.ProductDAO;
import com.bizpoll.dto.ProductDTO;

public class DetailAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uri = "product_detail.jsp";
		
		ProductDAO pDao = ProductDAO.getInstance();
		String p_code = request.getParameter("p_code");
		ProductDTO productDetail = pDao.productDetail(p_code);
		request.setAttribute("productDetail", productDetail);
		
		ActionFoward forward = new ActionFoward();
		forward.setPath(uri);
		forward.setRedirect(false);
		return forward;
	}

}

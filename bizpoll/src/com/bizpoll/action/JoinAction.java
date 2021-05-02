package com.bizpoll.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.MemberDAO;
import com.bizpoll.dto.MemberDTO;

public class JoinAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "member/login.jsp";
		MemberDAO mDao = MemberDAO.getInstance();
		/*
		 * mDto.setId(request.getParameter("id"));
		 * mDto.setPwd(request.getParameter("pwd"));
		 * mDto.setName(request.getParameter("irum"));
		 * mDto.setEmail(request.getParameter("email"));
		 * mDto.setZip_num(request.getParameter("zipNum"));
		 * mDto.setAddress(request.getParameter("addr1") +
		 * request.getParameter("addr2")); mDto.setPhone(request.getParameter("phone"));
		 */
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String zip_num = request.getParameter("zipNum");
		String address = request.getParameter("addr1") + request.getParameter("addr2");
		String phone = request.getParameter("phone");
		MemberDTO mDto = new MemberDTO();
		mDto.setId(id);
		mDto.setPwd(pwd);
		mDto.setName(name);
		mDto.setEmail(email);
		mDto.setZip_num(zip_num);
		mDto.setAddress(address);
		mDto.setPhone(phone);
		System.out.println("mDto name ==> " + mDto.getName());
		System.out.println("mDto pwd ==> " + mDto.getPwd());
		System.out.println("mDto addr ==> " + mDto.getAddress());
		System.out.println("mDto phone ==> " + mDto.getPhone());
		int result = mDao.batisJoin(mDto);
		System.out.println("result >> " + result);
		
		
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}

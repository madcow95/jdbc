package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}

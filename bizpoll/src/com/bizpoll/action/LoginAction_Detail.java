package com.bizpoll.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.MemberDTO;

public class LoginAction_Detail implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "member/login_fail.jsp";
		
		String userId = request.getParameter("id");
		String userPwd = request.getParameter("pwd");
		
		MemberDTO mDto = null;
		HttpSession session = request.getSession();
		
		String sql = "SELECT * "
				   + "FROM member "
				   + "WHERE id=? "
				   + "AND pwd=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mDto = new MemberDTO();
				mDto.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		if(mDto != null) {
			session.removeAttribute("userId");
			session.setAttribute("userId", mDto);
			url = "index.bizpoll";
		}
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}

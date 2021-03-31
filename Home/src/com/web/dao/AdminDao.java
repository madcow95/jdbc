package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.web.dbm.DBManager;
import com.web.dto.AdminDto;

public class AdminDao implements AdminService {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	AdminDto aDto;
	List<AdminDto> adList;
	@Override
	public void signIn() {

	}

	@Override
	public int idCheck(String check) {
		con = DBManager.getConnection();
		try {
			String sql = "SELECT  * " + "FROM    admin " + "WHERE   id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, check);

			rs = pstmt.executeQuery();
			adList = new ArrayList<AdminDto>();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				AdminDto aDto = new AdminDto(id, pw, name, phone);
				adList.add(aDto);
			}
			
		} catch (Exception e) {

		}
		return adList.size();
	}

	@Override
	public void logIn() {
		// TODO Auto-generated method stub

	}

}

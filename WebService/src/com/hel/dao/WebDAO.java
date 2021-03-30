package com.hel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hel.dto.WebDTO;
import com.hel.service.WebService;

public class WebDAO implements WebService {
	private String url;
	private String forName;
	private String user;
	private String pw;
	private Scanner scan;
	private WebDTO wDto;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Connection con = null;
	private List<WebDTO> webList;

	public WebDAO() {
		forName = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@220.93.161.202:1521:xe";
		user = "scott";
		pw = "1234";
		scan = new Scanner(System.in);
	}

	@Override
	public String login() {
		System.out.println("로그인");
		System.out.println("========================");
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		System.out.print("비밀번호 : ");
		String pass = scan.nextLine();
		wDto = new WebDTO();
		wDto.setId(id);
		wDto.setPass(pass);
		int succ = 0;
		List<WebDTO> webList = new ArrayList<WebDTO>();

		try {
			Class.forName(forName);
			con = DriverManager.getConnection(url, user, pw);
			String sql = "SELECT  * "
			+ "FROM    healthpage "
			+ "WHERE   id = ? " 
			+ "AND     pw = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wDto.getId());
			pstmt.setString(2, wDto.getPass());

			succ = pstmt.executeUpdate();
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userId = rs.getString("id");
				String userName = rs.getString("name");
				WebDTO wDto = new WebDTO();
				wDto.setId(userId);
				wDto.setName(userName);
				webList.add(wDto);
			}
		} catch (Exception e) {

		}
		if (succ > 0) {
			return webList.get(0).getName();
		} else {
			return null;
		}
	}

	@Override
	public int signin() {
		System.out.println("회원가입을 환영합니다.");
		System.out.println("========================");
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		System.out.print("비밀번호 : ");
		String pass = scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("주소 : ");
		String addr = scan.nextLine();
		System.out.print("생년월일 : ");
		String birth = scan.nextLine();
		System.out.print("번호 : ");
		String phone = scan.nextLine();

		wDto = new WebDTO();
		wDto.setId(id);
		wDto.setPass(pass);
		wDto.setName(name);
		wDto.setAddr(addr);
		wDto.setBirth(birth);
		wDto.setPhone(phone);
		int succ = 0;
		try {
			Class.forName(forName);
			con = DriverManager.getConnection(url, user, pw);

			String sql = "INSERT INTO healthpage " + "VALUES(?, ?, ? ,? ,?, ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, wDto.getId());
			pstmt.setString(2, wDto.getPass());
			pstmt.setString(3, wDto.getName());
			pstmt.setString(4, wDto.getBirth());
			pstmt.setString(5, wDto.getAddr());
			pstmt.setString(6, wDto.getPhone());

			succ = pstmt.executeUpdate();
		} catch (Exception e) {

		}
		return succ;
	}

	@Override
	public int update(String userId, String userPw) {
		int succ = 0;
		System.out.println("정보수정");
		System.out.println("=============");
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 주소 변경");
		System.out.println("3. 번호 변경");
		System.out.println("=============");
		System.out.print("선택 >> ");
		String strSelect = scan.nextLine();

		int select = Integer.valueOf(strSelect);
		if (select == 1) {
			System.out.print("변경할 비밀번호 : ");
			String updatePw = scan.nextLine();
			wDto = new WebDTO();
			wDto.setPass(updatePw);
			try {
				Class.forName(forName);
				con = DriverManager.getConnection(url, user, pw);

				String sql = "UPDATE healthpage " 
				+ "SET pw = ? " 
				+ "WHERE id = ? AND pw = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, wDto.getPass());
				pstmt.setString(2, userId);
				pstmt.setString(3, userPw);
				succ = pstmt.executeUpdate();
			} catch (Exception e) {

			}
			return succ;
		} else if (select == 2) {
			try {
				Class.forName(forName);
				con = DriverManager.getConnection(url, user, pw);

				String sql = "UPDATE healthpage " 
				+ "SET addr = ? " 
				+ "WHERE id = ? AND pw = ?";
				pstmt = con.prepareStatement(sql);
				System.out.print("변경할 주소 : ");
				String updateAddr = scan.nextLine();
				wDto = new WebDTO();
				wDto.setAddr(updateAddr);
				pstmt.setString(1, wDto.getAddr());
				pstmt.setString(2, userId);
				pstmt.setString(3, userPw);
				succ = pstmt.executeUpdate();
				return succ;
			} catch (Exception e) {

			}
		} else if (select == 3) {
			try {
				Class.forName(forName);
				con = DriverManager.getConnection(url, user, pw);

				String sql = "UPDATE healthpage " 
				+ "SET phone = ? " 
				+ "WHERE id = ? AND pw = ?";
				pstmt = con.prepareStatement(sql);
				System.out.print("변경할 번호 : ");
				String updatePhone = scan.nextLine();
				wDto = new WebDTO();
				wDto.setPhone(updatePhone);
				pstmt.setString(1, wDto.getPhone());
				pstmt.setString(2, userId);
				pstmt.setString(3, userPw);
				succ = pstmt.executeUpdate();
				return succ;
			} catch (Exception e) {

			}
		}
		return 0;
	}

	@Override
	public int delete(String strId, String strPw) {
		wDto = new WebDTO();
		wDto.setId(strId);
		wDto.setPass(strPw);
		int succ = 0;
		try {
			Class.forName(forName);
			con = DriverManager.getConnection(url, user, pw);

			String sql = "DELETE FROM healthpage " 
			+ "WHERE id = ? AND pw = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wDto.getId());
			pstmt.setString(2, wDto.getPass());
			succ = pstmt.executeUpdate();
		} catch (Exception e) {

		}
		return succ;
	}

	@Override
	public List<WebDTO> select(String selectId, String selectPw) {
		try {
			wDto = new WebDTO();
			wDto.setId(selectId);
			wDto.setPass(selectPw);
			Class.forName(forName);
			con = DriverManager.getConnection(url, user, pw);
			
			String sql = "SELECT * "
					+ "FROM healthpage "
					+ "WHERE id = ? "
					+ "AND pw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wDto.getId());
			pstmt.setString(2, wDto.getPass());
			
			rs = pstmt.executeQuery();
			webList = new ArrayList<WebDTO>();
			while(rs.next()) {
				String id = rs.getString("id");
				String pass = rs.getString("pw");
				String name = rs.getString("name");
				String birth = rs.getString("birth");
				String addr = rs.getString("addr");
				String phone = rs.getString("phone");
				
				WebDTO wDto = new WebDTO(id, pass, name, addr, birth, phone);
				webList.add(wDto);
			}
		} catch (Exception e) {
			
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return webList;
	}

}

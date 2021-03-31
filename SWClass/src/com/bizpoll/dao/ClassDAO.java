package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.ClassDTO;
import com.bizpoll.service.ClassService;

public class ClassDAO implements ClassService {
	private String url;
	private String forName;
	private String user;
	private String pw;
	private Scanner scan;
	private ClassDTO cDto;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Connection con = null;
	private List<ClassDTO> classList;
	
	public ClassDAO() {
//		forName = "oracle.jdbc.driver.OracleDriver";
//		url = "jdbc:oracle:thin:@192.168.4.9:1521:xe";
//		user = "scott";
//		pw = "1234";
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
		cDto = new ClassDTO();
		cDto.setId(id);
		cDto.setPass(pass);
		int succ = 0;
		List<ClassDTO> classList = new ArrayList<ClassDTO>();

		try {
			//Class.forName(forName);
			//con = DriverManager.getConnection(url, user, pw);
			con = DBManager.getConnection();
			String sql = "SELECT  * "
			+ "FROM    healthpage "
			+ "WHERE   id = ? " 
			+ "AND     pw = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cDto.getId());
			pstmt.setString(2, cDto.getPass());

			succ = pstmt.executeUpdate();
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userId = rs.getString("id");
				String userName = rs.getString("name");
				ClassDTO cDto = new ClassDTO();
				cDto.setId(userId);
				cDto.setName(userName);
				classList.add(cDto);
			}
		} catch (Exception e) {

		} 
		DBManager.close(con, pstmt);
		if (succ > 0) {
			return classList.get(0).getName();
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

		cDto = new ClassDTO();
		cDto.setId(id);
		cDto.setPass(pass);
		cDto.setName(name);
		cDto.setAddr(addr);
		cDto.setBirth(birth);
		cDto.setPhone(phone);
		int succ = 0;
		try {
			//Class.forName(forName);
			//con = DriverManager.getConnection(url, user, pw);
			con = DBManager.getConnection();
			String sql = "INSERT INTO healthpage " + "VALUES(?, ?, ? ,? ,?, ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, cDto.getId());
			pstmt.setString(2, cDto.getPass());
			pstmt.setString(3, cDto.getName());
			pstmt.setString(4, cDto.getBirth());
			pstmt.setString(5, cDto.getAddr());
			pstmt.setString(6, cDto.getPhone());

			succ = pstmt.executeUpdate();
		} catch (Exception e) {

		}
		DBManager.close(con, pstmt);
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
			try {
				//Class.forName(forName);
				//con = DriverManager.getConnection(url, user, pw);
				con = DBManager.getConnection();
				String sql = "UPDATE healthpage " 
				+ "SET pw = ? " 
				+ "WHERE id = ? AND pw = ?";
				pstmt = con.prepareStatement(sql);
				System.out.print("변경할 비밀번호 : ");
				String updatePw = scan.nextLine();
				cDto = new ClassDTO();
				cDto.setPass(updatePw);
				pstmt.setString(1, cDto.getPass());
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
				cDto = new ClassDTO();
				cDto.setAddr(updateAddr);
				pstmt.setString(1, cDto.getAddr());
				pstmt.setString(2, userId);
				pstmt.setString(3, userPw);
				succ = pstmt.executeUpdate();
				return succ;
			} catch (Exception e) {

			}
		} else if (select == 3) {
			try {
				//Class.forName(forName);
				//con = DriverManager.getConnection(url, user, pw);
				con = DBManager.getConnection();
				String sql = "UPDATE healthpage " 
				+ "SET phone = ? " 
				+ "WHERE id = ? AND pw = ?";
				pstmt = con.prepareStatement(sql);
				System.out.print("변경할 번호 : ");
				String updatePhone = scan.nextLine();
				cDto = new ClassDTO();
				cDto.setPhone(updatePhone);
				pstmt.setString(1, cDto.getPhone());
				pstmt.setString(2, userId);
				pstmt.setString(3, userPw);
				succ = pstmt.executeUpdate();
				return succ;
			} catch (Exception e) {

			}
		}
		DBManager.close(con, pstmt);
		return 0;
	}

	@Override
	public int delete(String strId, String strPw) {
		cDto = new ClassDTO();
		cDto.setId(strId);
		cDto.setPass(strPw);
		int succ = 0;
		try {
			//Class.forName(forName);
			//con = DriverManager.getConnection(url, user, pw);
			con = DBManager.getConnection();
			String sql = "DELETE FROM healthpage " 
			+ "WHERE id = ? AND pw = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cDto.getId());
			pstmt.setString(2, cDto.getPass());
			succ = pstmt.executeUpdate();
		} catch (Exception e) {

		}
		DBManager.close(con, pstmt);
		return succ;
	}

	@Override
	public List<ClassDTO> select(String selectId, String selectPw) {
		try {
			cDto = new ClassDTO();
			cDto.setId(selectId);
			cDto.setPass(selectPw);
			//Class.forName(forName);
			//con = DriverManager.getConnection(url, user, pw);
			con = DBManager.getConnection();
			String sql = "SELECT * "
					+ "FROM healthpage "
					+ "WHERE id = ? "
					+ "AND pw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cDto.getId());
			pstmt.setString(2, cDto.getPass());
			
			rs = pstmt.executeQuery();
			classList = new ArrayList<ClassDTO>();
			while(rs.next()) {
				String id = rs.getString("id");
				String pass = rs.getString("pw");
				String name = rs.getString("name");
				String birth = rs.getString("birth");
				String addr = rs.getString("addr");
				String phone = rs.getString("phone");
				
				ClassDTO cDto = new ClassDTO(id, pass, name, addr, birth, phone);
				classList.add(cDto);
			}
		} catch (Exception e) {
			
		}
		DBManager.close(con, pstmt, rs);
		return classList;
	}

}

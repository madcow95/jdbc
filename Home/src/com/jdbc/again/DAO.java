package com.jdbc.again;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.web.dbm.DBManager;

public class DAO {
	/*
	 * admin 등록 아이디 체크 로그인 관리자 목록
	 */
	private PreparedStatement pstmt = null;
	private Connection con = null;
	private ResultSet rs = null;
	private Scanner scan;
	private List<DTO> adminList;
	public DAO() {
		scan = new Scanner(System.in);
	}

	public int insert(String adminId) {
		int succ = 0;
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * "
					+ "FROM admin "
					+ "WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminId);
			succ = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (succ > 0) {
			return succ;
		} else {
			try {
				System.out.println(adminId + "는 사용가능한 아이디");
				System.out.print("PW : ");
				String adminPw = scan.nextLine();
				System.out.print("NAME : ");
				String adminName = scan.nextLine();
				System.out.print("PHONE : ");
				String adminPhone = scan.nextLine();
				con = DBManager.getConnection();
				String sql = "INSERT INTO admin "
							+ "VALUES(?, ?, ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, adminId);
				pstmt.setString(2, adminPw);
				pstmt.setString(3, adminName);
				pstmt.setString(4, adminPhone);
				pstmt.executeUpdate();
			} catch (Exception e) {

			} finally {
				DBManager.close(con, pstmt);
			}
			return 0;
		}
	}

	public List<DTO> login(String id, String pw) {
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * "
					+ "FROM admin "
					+ "WHERE id = ? AND pw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			adminList = new ArrayList<DTO>();
			while(rs.next()) {
				String name = rs.getString("name");
				DTO dto = new DTO();
				dto.setName(name);
				adminList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		return adminList;
	}

	public List<DTO> userList() {
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * "
					+ "FROM admin ";
					
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			adminList = new ArrayList<DTO>();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				DTO dto = new DTO(id, pw, name, phone);
				adminList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminList;
	}
	
	public int update(String id, String pw) {
		int succ = 0;
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * " + 
					"FROM admin " + 
					"WHERE id = ? " + 
					"AND pw = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			succ = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(succ > 0) {
			System.out.println("=================");
			System.out.println("1. 비밀번호 변경");
			System.out.println("2. 이름 변경");
			System.out.println("3. 전화번호 변경");
			System.out.println("Q. 수정완료");
			System.out.println("=================");
			System.out.print("선택 >> ");
			String strSelect = scan.nextLine();
			if(strSelect.equalsIgnoreCase("q")) {
				// break;
			}
			int select = Integer.valueOf(strSelect);
			if (select >= 1 && select <= 3) {
				if(select == 1) {
					System.out.println("비밀번호 변경");
					System.out.println("===============");
					System.out.print("변경할 비밀번호 : ");
					String changePw = scan.nextLine();
					int result = 0;
					try {
						con = DBManager.getConnection();
						String sql = "UPDATE admin " + 
								"SET pw = ? " + 
								"WHERE id = ? " + 
								"AND pw = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, changePw);
						pstmt.setString(2, id);
						pstmt.setString(3, pw);
						result = pstmt.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(result > 0) {
						return result;
					}
				} else if(select == 2) {
					System.out.println("이름 변경");
					System.out.println("===============");
					System.out.print("변경할 이름 : ");
					String changeName = scan.nextLine();
					int result = 0;
					try {
						con = DBManager.getConnection();
						String sql = "UPDATE admin " + 
								"SET name = ? " + 
								"WHERE id = ? " + 
								"AND pw = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, changeName);
						pstmt.setString(2, id);
						pstmt.setString(3, pw);
						result = pstmt.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(result > 0) {
						return result;
					}
				} else if(select == 3) {
					System.out.println("전화번호 변경");
					System.out.println("===============");
					System.out.print("변경할 전화번호 : ");
					String changePhone = scan.nextLine();
					int result = 0;
					try {
						con = DBManager.getConnection();
						String sql = "UPDATE admin " + 
								"SET phone = ? " + 
								"WHERE id = ? " + 
								"AND pw = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, changePhone);
						pstmt.setString(2, id);
						pstmt.setString(3, pw);
						result = pstmt.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(result > 0) {
						return result;
					}
				}
			} else {
				System.out.println("1 ~ 3에서만 입력하세요");
			}
		}
		return 0;
	}
	
	public int search(String name) {
		int succ = 0;
		try {
			con = DBManager.getConnection();
			String sql = "SELECT COUNT(name) " + 
					"FROM admin " + 
					"WHERE name LIKE ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"%" + name + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				succ = rs.getInt("COUNT(name)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (succ > 0) {
			return succ;
		} else {
			return 0;
		}
	}

	public boolean delete(String id, String pw) {
		int succ = 0;
		try {
			con = DBManager.getConnection();
			String sql = "DELETE FROM admin " + 
					"WHERE id = ? AND pw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, id);
			pstmt.setNString(2, pw);
			succ = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (succ > 0) {
			return true;
		} else {
			return false;
		}
	}
}

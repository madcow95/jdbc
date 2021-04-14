package com.bizpoll.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bizpoll.common.DBManager;

/*
 * admin 등록
 * 아이디 체크
 * 로그인
 * 관리자 목록
 */
public class AdminDAO_real {
	private AdminDTO aDto;
	private Connection con;
	private PreparedStatement pstmt;
	private Scanner scan;
	private ResultSet rs;
	private List<AdminDTO> adminList;

	public AdminDAO_real() {
		scan = new Scanner(System.in);
	}

	public int signIn(String adminId) {
		aDto = new AdminDTO();
		con = DBManager.getConnection();
		String sql = "SELECT  * "
					+ "FROM admin WHERE "
					+ "id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminId);
			rs = pstmt.executeQuery();
			adminList = new ArrayList<AdminDTO>();
			while (rs.next()) {
				String id = rs.getString("id");

				AdminDTO aDto = new AdminDTO();
				aDto.setId(id);
				adminList.add(aDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (adminList.size() > 0) {
			return adminList.size();
		} else {
			System.out.println("아이디 생성가능");
			System.out.println("==============");
			System.out.print("PW : ");
			String pw = scan.nextLine();
			System.out.print("NAME : ");
			String name = scan.nextLine();
			System.out.print("PHONE : ");
			String phone = scan.nextLine();

			aDto = new AdminDTO(adminId, pw, name, phone);
			con = DBManager.getConnection();
			int succ = 0;
			String sql2 = "INSERT INTO admin VALUES(?, ?, ?, ?)";
			try {
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, adminId);
				pstmt.setString(2, aDto.getPw());
				pstmt.setString(3, aDto.getName());
				pstmt.setString(4, aDto.getPhone());

				succ = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(con, pstmt);
			}
			return 0;
		}
	}

	public List<AdminDTO> login(String id, String pw) {
		con = DBManager.getConnection();
		String sql = "SELECT  * "
					+ "FROM admin "
					+ "WHERE id = ? AND pw = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			adminList = new ArrayList<AdminDTO>();
			while (rs.next()) {
				String name = rs.getString("name");
				AdminDTO aDto = new AdminDTO();
				aDto.setName(name);
				adminList.add(aDto);
			}
		} catch (Exception e) {

		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return adminList;
	}

	public int update(String adminId, String adminPw) {
		con = DBManager.getConnection();
		String sql = "SELECT  * "
				+ "FROM admin "
				+ "WHERE id = ? AND pw = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminId);
			pstmt.setString(2, adminPw);
			rs = pstmt.executeQuery();
			adminList = new ArrayList<AdminDTO>();
			while (rs.next()) {
				String id = rs.getString("id");
				AdminDTO aDto = new AdminDTO();
				aDto.setId(id);
				adminList.add(aDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (adminList.size() > 0) {
			System.out.println("=============");
			System.out.println("1. 비밀번호 변경");
			System.out.println("2. 전화번호 변경");
			System.out.println("3. 이름 변경");
			System.out.println("4. 변경 완료");
			System.out.println("=============");
			System.out.print("입력 >> ");
			String strSelect = scan.nextLine();
			int select = Integer.valueOf(strSelect);
			while (true) {
				if (select >= 1 && select <= 4) {
					if (select == 1) {
						System.out.println("비밀번호 변경");
						System.out.println("=============");
						System.out.print("변경할 PW : ");
						String changePw = scan.nextLine();
						con = DBManager.getConnection();

						String sql2 = "UPDATE admin "
								+ "SET pw = ? "
								+ "WHERE id = ? AND pw = ?";
						int succ = 0;
						try {
							pstmt = con.prepareStatement(sql2);
							pstmt.setString(1, changePw);
							pstmt.setString(2, adminId);
							pstmt.setString(3, adminPw);

							succ = pstmt.executeUpdate();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						return succ;
					} else if (select == 2) {
						System.out.println("전화번호 변경");
						System.out.println("=============");
						System.out.print("변경할 번호 : ");
						String ChangePhone = scan.nextLine();
						con = DBManager.getConnection();

						String sql2 = "UPDATE admin "
								+ "SET phone = ? "
								+ "WHERE id = ? AND pw = ?";
						int succ = 0;
						try {
							pstmt = con.prepareStatement(sql2);
							pstmt.setString(1, ChangePhone);
							pstmt.setString(2, adminId);
							pstmt.setString(3, adminPw);
							succ = pstmt.executeUpdate();
						} catch (Exception e) {

						}
						return succ;
					} else if (select == 3) {
						System.out.println("이름 변경");
						System.out.println("=============");
						System.out.print("변경할 이름 : ");
						String changeName = scan.nextLine();
						con = DBManager.getConnection();

						String sql2 = "UPDATE admin "
									+ "SET name = ? "
									+ "WHERE id = ? AND pw = ?";
						int succ = 0;
						try {
							pstmt = con.prepareStatement(sql2);
							pstmt.setString(1, changeName);
							pstmt.setString(2, adminId);
							pstmt.setString(3, adminPw);
							succ = pstmt.executeUpdate();
						} catch (Exception e) {

						}
						return succ;
					} else if (select == 4) {
						break;
					}
				} else {
					System.out.println("1 ~ 4의 숫자만 입력하세요");
				}
				return 1;
			}
		}
		DBManager.close(con, pstmt);
		return 0;
	}

	public List<AdminDTO> adminList(String adminId, String adminPw) {
		con = DBManager.getConnection();

		String sql = "SELECT  * "
					+ "FROM admin WHERE "
					+ "id = ? AND pw = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminId);
			pstmt.setString(2, adminPw);
			rs = pstmt.executeQuery();
			adminList = new ArrayList<AdminDTO>();
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				AdminDTO aDto = new AdminDTO(id, pw, name, phone);
				adminList.add(aDto);
			}
		} catch (Exception e) {

		}
		DBManager.close(con, pstmt, rs);
		return adminList;
	}

	public int delete(String delId, String delPw) {
		con = DBManager.getConnection();
		String sql = "DELETE FROM admin "
					+ "WHERE id = ? AND pw = ?";
		int succ = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, delId);
			pstmt.setString(2, delPw);
			succ = pstmt.executeUpdate();
		} catch (Exception e) {

		} finally {
			DBManager.close(con, pstmt);
		}
		return succ;
	}

}

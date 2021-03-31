package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bizpoll.dto.MemberDTO;

public class MemberDAO {

	private String url;
	private String className;
	private String user;
	private String pw;
	private Scanner scan;
	private List<MemberDTO> memList;
	MemberDTO mDto;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection con = null;
	
	public MemberDAO() {
		url = "jdbc:oracle:thin:@192.168.4.9:1521:xe";
		className = "oracle.jdbc.driver.OracleDriver";
		user = "scott";
		pw = "1234";
		scan = new Scanner(System.in);
		
	}

	public void insert() {
		System.out.print("ȸ�� ��ȣ�� �Է��ϼ��� : ");
		int no = scan.nextInt();
		scan.nextLine();

		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = scan.nextLine();

		System.out.print("���̸� �Է��ϼ��� : ");
		int age = scan.nextInt();
		scan.nextLine();

		System.out.print("�ּҸ� �Է��ϼ��� : ");
		String addr = scan.nextLine();

		System.out.print("��ȭ��ȣ�� �Է��ϼ��� : ");
		String phone = scan.nextLine();

		scan.close();

		MemberDTO mDto = new MemberDTO(no, name, age, addr, phone);

		int result = memInsert(mDto);
		if (result > 0) {
			System.out.println("ȸ������ �Ϸ�");
		} else {
			System.out.println("���� ����");
		}
	}

	private int memInsert(MemberDTO mDto) {
		int succ = 0;

		try {
			Class.forName(className);

			Connection con = DriverManager.getConnection(url, user, pw);

			String sql = "INSERT INTO tblMember VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mDto.getNo());
			pstmt.setString(2, mDto.getName());
			pstmt.setInt(3, mDto.getNo());
			pstmt.setString(4, mDto.getAddr());
			pstmt.setString(5, mDto.getPhone());

			succ = pstmt.executeUpdate();
		} catch (Exception e) {

		}
		return succ;
	}

	public void delete() {
		String name = scan.nextLine();
		MemberDTO mDto = new MemberDTO();
		mDto.setName(name);
		scan.close();
		int result = memDelete(mDto);

		if (result > 0) {
			System.out.println("Ż��Ϸ�");
		} else {
			System.out.println("Ż�����");
		}
	}

	private int memDelete(MemberDTO mDto) {
		int conn = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);
			String sql = "DELETE FROM tblMember WHERE name = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mDto.getName());
			int result = pstmt.executeUpdate();
			conn = result;
		} catch (Exception e) {

		}
		return conn;
	}

	public void update() {
		System.out.print("������ ȸ�� �̸� �Է� : ");
		String name = scan.nextLine();
		
		System.out.print("������ ���� : ");
		int age = scan.nextInt();
		scan.nextLine();
		
		System.out.print("����� ��ȭ��ȣ : ");
		String phone = scan.nextLine();
		
		MemberDTO mDto = new MemberDTO();
		mDto.setName(name);
		mDto.setAge(age);
		mDto.setPhone(phone);
		scan.close();
		
		int result = memUpdate(mDto);
		if(result > 0) {
			System.out.println("���� �Ϸ�");
		} else {
			System.out.println("���� ����");
		}
	}

	private int memUpdate(MemberDTO mDto) {
		int succ = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);

			String sql = "UPDATE tblMember " + 
					"SET age = ?, phone = ? " + 
					"WHERE name = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mDto.getAge());
			pstmt.setString(2, mDto.getPhone());
			pstmt.setString(3, mDto.getName());
			
			succ = pstmt.executeUpdate();
		} catch (Exception e) {
			
		}
		return succ;
	}

	public List<MemberDTO> select(int inputNo) {
		try {
			Class.forName(className);
			con = DriverManager.getConnection(url, user, pw);
			
			String sql = "SELECT * FROM tblMember WHERE no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, inputNo);
			
			rs = pstmt.executeQuery();
			memList = new ArrayList<MemberDTO>();
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String phone = rs.getString("phone");
				
				MemberDTO mDto = new MemberDTO(no, name, age, addr, phone);
				memList.add(mDto);
			}
		} catch (Exception e) {
			
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
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
		return memList;
	}
	
	public int login(int succ) {
		//System.out.print("이름입력 : ");
		//String name = scan.nextLine();
		System.out.print("번호입력 : ");
		succ = 0;
		try {
			int no = scan.nextInt();
			scan.nextLine();
			
			mDto = new MemberDTO();
			//mDto.setName(name);
			mDto.setNo(no);
			
			try {
				Class.forName(className);
				con = DriverManager.getConnection(url, user, pw);
				
				String sql = "SELECT * " + 
						"FROM tblMember " + 
						"WHERE name = ? " + 
						"AND   no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mDto.getName());
				pstmt.setInt(2, mDto.getNo());
				
				succ = pstmt.executeUpdate();
			} catch (Exception e) {
				
			}
			
		} catch (Exception e) {
			System.out.println("회원번호는 숫자만 입력해주세요.");
		}
		return succ;
	}
	public List<MemberDTO> userId(String user) {
		System.out.print("회원번호 입력 : ");
		int password = scan.nextInt();
		try {
			Class.forName(className);
			con = DriverManager.getConnection(url, user, pw);
			String sql = "SELECT * " + 
					"FROM tblMember " + 
					"WHERE name = ? " + 
					"AND   no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setInt(2, password);
			
			rs = pstmt.executeQuery();
			
			mDto = new MemberDTO();
			
		} catch (Exception e) {
			
		}
		return null;
	}
}

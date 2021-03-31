package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.bizpoll.dto.MemberDTO;

public class Ex09_Insert {
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
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
		
		System.out.printf("%d %s %d %s %s\n",no,name,age,addr,phone);
		
		MemberDTO mDto = new MemberDTO(no, name, age, addr, phone);
		
		int result = memInsert(mDto); // method�� �����߰� mDto���� parameter(�Ű�����)��
		if(result > 0) {
			System.out.println("��� �Ϸ�");
		} else {
			System.out.println("��� ����");
		}
	}

	public static int memInsert(MemberDTO mDto) {
		String url = "jdbc:oracle:thin:@192.168.4.9:1521:xe";
		String user = "scott";
		String pw = "1234";
		
		int succ = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);

			String sql = "INSERT INTO tblMember VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mDto.getNo()); 
			pstmt.setString(2, mDto.getName());
			pstmt.setInt(3, mDto.getAge());
			pstmt.setString(4, mDto.getAddr());
			pstmt.setString(5, mDto.getPhone());

			succ = pstmt.executeUpdate();
			
		} catch (Exception e) {
			
		}
		return succ;
	}

}

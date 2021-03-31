package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.bizpoll.dto.MemberDTO;

public class Ex09_Insert {
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("회원 번호를 입력하세요 : ");
		int no = scan.nextInt();
		scan.nextLine();
		
		System.out.print("이름을 입력하세요 : ");
		String name = scan.nextLine();
		
		System.out.print("나이를 입력하세요 : ");
		int age = scan.nextInt();
		scan.nextLine();
		
		System.out.print("주소를 입력하세요 : ");
		String addr = scan.nextLine();
		
		System.out.print("전화번호를 입력하세요 : ");
		String phone = scan.nextLine();

		scan.close();
		
		System.out.printf("%d %s %d %s %s\n",no,name,age,addr,phone);
		
		MemberDTO mDto = new MemberDTO(no, name, age, addr, phone);
		
		int result = memInsert(mDto); // method를 실행했고 mDto값을 parameter(매개변수)로
		if(result > 0) {
			System.out.println("등록 완료");
		} else {
			System.out.println("등록 실패");
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

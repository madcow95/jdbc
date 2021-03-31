package com.web.main;

import java.util.Scanner;

import com.web.dao.AdminDao;

public class AdminMain {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AdminDao aDao = new AdminDao();
		while(true) {
			System.out.println("===========");
			System.out.println("1. 중복체크");
			System.out.println("2. 회원가입");
			System.out.println("3. 로그인");
			System.out.println("4. 종료");
			System.out.println("===========");
			System.out.print("입력 >> ");
			String strSelect = scan.nextLine();
			
			int select = Integer.valueOf(strSelect);
			if(select >= 1 && select <= 4) {
				if(select == 1) {
					System.out.println("중복체크");
					System.out.println("===========");
					System.out.print("ID : ");
					String check = scan.nextLine();
					int result = aDao.idCheck(check);
					if(result > 0) {
						System.out.println("이미 존재하는 아이디 입니다.");
					} else {
						System.out.println("회원가입 가능");
					}
				} else if(select == 2) {
					aDao.signIn();
				} else if(select == 3) {
					aDao.logIn();
				}
				
			}
			
		}
		
	}
}

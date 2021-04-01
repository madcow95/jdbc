package com.bizpoll.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMain {
// 1. 관리자 등록 2. 관리자 로그인 3. 시스템 종료
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AdminDAO aDao = new AdminDAO();
		List<AdminDTO> adList = new ArrayList<AdminDTO>();
		while (true) {
			System.out.println("=============");
			System.out.println("1. 계정생성");
			System.out.println("2. 중복체크");
			System.out.println("3. 로그인");
			System.out.println("4. 중복");
			System.out.println("5. 시스템 종료");
			System.out.println("=============");
			System.out.print("입력 >> ");
			String strSelect = scan.nextLine();
			try {
				int select = Integer.valueOf(strSelect);
				if (select >= 1 && select <= 5) {
					if (select == 1) {
						int result = aDao.makeAdmin();
						if (result > 0) {
							System.out.println("생성 완료");
						} else {
							System.out.println("생성 실패");
						}
					} else if (select == 2) {
						System.out.print("ID 입력 : ");
						String adminId = scan.nextLine();
						adList = aDao.checkId(adminId);
						if (adList.size() > 0) {
							for (int i = 0; i < adList.size(); i++) {
								if (adList.get(i).getId().equals(adminId)) {
									System.out.println("이미 존재하는 아이디 입니다.");
								}
							}
						} else {
							System.out.println("사용 가능한 아이디 입니다.");
						}
					} else if (select == 3) {
						System.out.print("ID : ");
						String adminId = scan.nextLine();
						System.out.print("PW : ");
						String adminPw = scan.nextLine();

						adList = aDao.login(adminId, adminPw);
						if (adList.size() > 0) {
							for (AdminDTO aDto : adList) {
								System.out.printf("%s님 환영합니다\n", aDto.getName());
							}
						} else {
							System.out.println("존재하지 않는 회원입니다.");
						}
					} else if (select == 4) {
						System.out.print("아이디 입력 : ");
						String id = scan.nextLine();
						if (aDao.adminICheck(id) == true) {
							System.out.println("회원가입 가능");
						} else {
							System.out.println("이미 존재하는 아이디");
						}

					} else if (select == 5) {
						System.out.println("시스템 종료");
						break;
					}
				} else {
					System.out.println("1 ~ 5의 숫자만 입력해주세요");
				}

			} catch (Exception e) {
				System.out.println("1 ~ 5의 숫자만 입력해주세요");
			}

		}

	}
}

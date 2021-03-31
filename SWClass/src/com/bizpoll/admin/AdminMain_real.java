package com.bizpoll.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMain_real {
// 1. 관리자 등록 2. 관리자 로그인 3. 시스템 종료
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AdminDAO_real aDao2 = new AdminDAO_real();
		List<AdminDTO> adList = new ArrayList<AdminDTO>();
		while (true) {
			System.out.println("=============");
			System.out.println("1. 계정생성");
			System.out.println("2. 로그인");
			System.out.println("3. 회원정보 변경");
			System.out.println("4. 시스템 종료");
			System.out.println("=============");
			System.out.print("입력 >> ");
			String strSelect = scan.nextLine();
			try {
				int select = Integer.valueOf(strSelect);
				if (select >= 1 && select <= 3) {
					if (select == 1) {
						System.out.print("ID 입력 : ");
						String adminId = scan.nextLine();
						try {
							int result = aDao2.checkId(adminId);
							
							if (result > 0) {
								System.out.println("이미 존재하는 아이디 입니다.");
							} else {
								System.out.println("회원가입 완료!");
							}
						} catch (Exception e) {
							System.out.println("입력을 해주세요");
						}
					} else if (select == 2) {
						System.out.print("ID : ");
						String adminId = scan.nextLine();
						System.out.print("PW : ");
						String adminPw = scan.nextLine();

						adList = aDao2.login(adminId, adminPw);
						if (adList.size() > 0) {
							for (AdminDTO aDto : adList) {
								System.out.printf("%s님 환영합니다\n", aDto.getName());
							}
						} else {
							System.out.println("존재하지 않는 회원입니다.");
						}
					} else if(select == 3) {
						aDao2.update();
					}
					else if (select == 4) {
						System.out.println("시스템 종료");
						break;
					}
				} else {
					System.out.println("1 ~ 3의 숫자만 입력해주세요");
				}

			} catch (Exception e) {
				System.out.println("1 ~ 3의 숫자만 입력해주세요");
			}

		}

	}
}

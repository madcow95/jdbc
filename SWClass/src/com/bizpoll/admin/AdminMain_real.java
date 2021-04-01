package com.bizpoll.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMain_real {
// 1. 관리자 등록 2. 관리자 로그인 3. 관리자 목록 4. 시스템 종료
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AdminDAO_real aDao2 = new AdminDAO_real();
		List<AdminDTO> adList = new ArrayList<AdminDTO>();
		while (true) {
			System.out.println("=============");
			System.out.println("1. 계정생성");
			System.out.println("2. 로그인");
			System.out.println("3. 회원정보 수정");
			System.out.println("4. 관리자 목록");
			System.out.println("5. 회원 탈퇴");
			System.out.println("6. 시스템 종료");
			System.out.println("=============");
			System.out.print("입력 >> ");
			String strSelect = scan.nextLine();
			try {
				int select = Integer.valueOf(strSelect);
				if (select >= 1 && select <= 6) {
					if (select == 1) {
						
						System.out.print("ID 입력 : ");
						String adminId = scan.nextLine();
						int result = aDao2.signIn(adminId);
						
						if (result > 0) {
							System.out.println("이미 존재하는 아이디 입니다.");
						} else {
							System.out.println("회원가입 완료!");
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
					} else if (select == 3) {
						System.out.println("회원정보 수정");
						System.out.println("===============");
						System.out.print("회원 ID : ");
						String updateId = scan.nextLine();
						System.out.print("회원 PW : ");
						String updatePw = scan.nextLine();
						int result = aDao2.update(updateId, updatePw);
						if (result > 0) {
							System.out.println("정보 수정 완료");
						} else {
							System.out.println("존재하지 않는 회원입니다.");
						}
					} else if(select == 4) {
						System.out.print("관리자 ID : ");
						String searchAdmin = scan.nextLine();
						System.out.print("관리자 PW : ");
						String searchAdminPW = scan.nextLine();
						adList = aDao2.adminList(searchAdmin, searchAdminPW);
						if(adList.size() > 0) {
							for(AdminDTO aDto : adList) {
								System.out.println(aDto.getName() + "의 정보");
								System.out.println("===============================");
								System.out.printf("%s %s %s %s\n",
										aDto.getId(),
										aDto.getPw(),
										aDto.getName(),
										aDto.getPhone());
							}
						} else {
							System.out.println("등록되지 않은 회원입니다.");
						}
					} else if(select == 5) {
						System.out.print("삭제할 ID : ");
						String delId = scan.nextLine();
						System.out.print("삭제할 ID의 PW : ");
						String delPw = scan.nextLine();
						int result = aDao2.delete(delId, delPw);
						if(result > 0) {
							System.out.println("탈퇴 완료");
						} else {
							System.out.println("등록된 사용자가 아닙니다.");
						}
					} else if (select == 6) {
						System.out.println("시스템 종료");
						break;
					}
				} else {
					System.out.println("1 ~ 6의 숫자만 입력해주세요");
				}

			} catch (Exception e) {
				System.out.println("1 ~ 6의 숫자만 입력해주세요");
			}

		}

	}
}

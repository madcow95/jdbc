package com.bizpoll.ex;

import java.util.List;
import java.util.Scanner;

import com.bizpoll.dao.ClassDAO_2;
import com.bizpoll.dto.ClassDTO02;

public class ClassEx_02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ClassDAO_2 cDao2 = new ClassDAO_2();
		System.out.print("회원 검색 : ");
		String searchName = scan.nextLine();
		scan.close();
		List<ClassDTO02> classList = cDao2.search(searchName);
		if (classList.size() > 0) {
			System.out.printf("총 %d건\n",classList.size());
			for (ClassDTO02 cDto2 : classList) {
				System.out.printf("%s의 정보\n", cDto2.getName());
				System.out.printf("%s %s %s %s %s",
						cDto2.getNo(),
						cDto2.getName(),
						cDto2.getAge(),
						cDto2.getAddr(),
						cDto2.getPhone());
			}
		} else {
			System.out.println("맞는 정보가 없습니다");
		}
	}

}

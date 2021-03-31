package com.bizpoll.javaex;

import java.util.Scanner;

public class Exercise3_007 {
	// 키보드로부터 입력받은 문자형 변수 ch가 영문자(대문자 or 소문자)
	// 이거나 숫자일 때만 변수 result의 값이 true가 되도록 하는 코드
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		System.out.print("입력 >> ");
		char ch = scan.nextLine().charAt(0); // .charAt : 입력한 값중 0번째 값만 출력
		
		scan.close();
		
		boolean result = ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') || ('0' <= ch && ch <= '9');
		System.out.println(ch);
		System.out.println(result);
		
	}
	
}

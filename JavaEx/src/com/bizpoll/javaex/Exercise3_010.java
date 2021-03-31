package com.bizpoll.javaex;

public class Exercise3_010 {
	/*
	 * 대문자를 소문자로 변경하는 코드를 작성 단, 문자 ch에 저장된 문자가 대문자인 경우에만 소문자로 변경 힌트 : 문자코드는 소문자가
	 * 대문자보다 32만큼 더 큼 ex) 변수 ch에 'A'라는 대문자를 입력받았을때 'a'로 출력
	 */
	public static void main(String args[]) {

		char ch = 'A';
		int askiiCh = (int) ch + 32;
		if ((int) ch > 96) {
			askiiCh = (int) ch - 32;
		}
		System.out.println((char) askiiCh);
		
		
		char ch1 = 'B';
		char lowerCase = ('A' <= ch1 && ch1 <= 'Z') ? (char) (ch1 + 32) : ch1; 
		System.out.println("ch to lowerCase : " + lowerCase);

	}

}

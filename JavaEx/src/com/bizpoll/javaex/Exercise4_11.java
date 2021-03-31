package com.bizpoll.javaex;

import java.util.Scanner;

public class Exercise4_11 {
	/*
	 * 1과 1부터 시작하는 피보나치수열의 10번째 수는 무엇인지 계산하는 프로그램 피보나치 수열 : 
	 * 앞의 두 수를 더해서 다음 수를 만들어 나가는 수열
	 * 
	 * 예) 앞의 두 수가 1과 1이라면 그 다음수는 2가되고 그 다음 수는 1과 2를 더해서 3
	 * 1, 1, 2, 3, 5, 8, 13, 21 ...
	 */

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("몇번째 수열?");
		System.out.print("입력 : ");
		int num = scan.nextInt();
		int[] numArray = new int[num];
		int i = 0;
		for (i = 0; i < numArray.length; i++) {
			numArray[i] = 1;
			if (i >= 2) {
				numArray[i] = numArray[i - 1] + numArray[i - 2];
			}
			System.out.println((i + 1) + "번째 피보나치 수열 수 : " + numArray[i]);
		}
		

	}
}

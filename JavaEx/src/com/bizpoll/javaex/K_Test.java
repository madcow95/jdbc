package com.bizpoll.javaex;

import java.util.Scanner;

public class K_Test {
	/*
	 * 사용자가 임의의 수를 입력하면, 입력된 수의 각 자릿수의 합 
	 * ex) 임의의 수 12345를 입력할 경우 출력 : 15 (1 + 2 + 3 + 4 + 5)
	 */

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("입력 >> ");
		int userInput = scan.nextInt();
		int sum = 0;
		
		while (userInput > 0) {
			sum += userInput % 10;
			userInput /=  10;
		}
		System.out.println(sum);
		scan.close();
	}
}
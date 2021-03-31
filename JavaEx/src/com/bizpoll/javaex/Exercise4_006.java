package com.bizpoll.javaex;

public class Exercise4_006 {
	/*
	 *  두개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램
	 *  [출력] 1 + 5 = 6 / 2 + 4 = 6 / 3 + 3 = 6 / 4 + 2 = 6 / 5 + 1 = 6
	 */
	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		int j = 0;
		for (i = 1; i < 6; i++) {
			for (j = 1; j < 6; j++) {
				sum = i + j;
				if(sum == 6) {
					System.out.println(i + " + " + j + " = " + sum);
				}
			}
			
		}
	}
}

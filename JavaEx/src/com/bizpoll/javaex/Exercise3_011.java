package com.bizpoll.javaex;

public class Exercise3_011 {
	/*
	 * 1부터 100까지의 수 중에서 3의 배수와 그 갯수를 출력
	 */
	public static void main(String[] args) {
		
		int count = 0;
		System.out.println("3의 배수");
		System.out.println("-----------------------------------");
		for(int i = 0; i < 100; i++) {
			int num = i + 1;
			if(num % 3 == 0) {
				count++;
				System.out.print(num + ",\t");
				if(count % 5 == 0) {
					System.out.println();
				}
			}
		}
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("총 개수 : " + count + "개");
	}
}

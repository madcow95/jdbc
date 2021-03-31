package com.bizpoll.javaex;

public class Exercise4_004 {
	/*
	 * 1 + (-2) + 3 + (-4)+ ...와 같은 식으로 계속 더해나갔을 때 몇까지 더해야 종합이 100 이상이 되는지
	 */
	public static void main(String args[]) {
		int i = 0;
		int sum = 0;
		for (i = 0; sum < 100; i++) {
			int i2 = (i + 1);
			if (i2 % 2 == 0) {
				i2 *= -1;
			}
			sum += i2;
		}
		System.out.println(i + "까지");
		System.out.println("sum = " + sum);
	}
}

package com.bizpoll.javaex;

public class Exercise3_005 {
	// 변수 num의 값(임의의 수)중에서 일의 자리를 1로 바꾸는 코드를 작성하시오.
	// ex) 변수 num값이 333이라면 331이 되고, 777이면 771이됨

	public static void main(String[] args) {

		int num = 777;
		System.out.println(num / 10 * 10 + 1);
	}
}

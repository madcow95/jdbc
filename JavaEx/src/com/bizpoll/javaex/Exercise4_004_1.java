package com.bizpoll.javaex;

public class Exercise4_004_1 {
	
	public static void main(String[] args) {
		// 초기화를 잘 시키자
		int sum = 0;
		int s = 1;
		int num = 0;
		//     초기화 조건식 증감식 블럭
		for (int i = 1; true; i++, s = -s) { // 조건식에 true : 무한 반복
			num = s * i;
			sum += num;
			
			if(sum >= 100) {
				break;
			}
		}
		System.out.println("num = " + num);
		System.out.println("sum = " + sum);
	}

}

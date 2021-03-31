package com.bizpoll.javaex;

public class Exercise4_006_1 {

	public static void main(String[] args) {
		
		System.out.println("[Ãâ·Â]");
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				if ((i + j) == 6) {
					System.out.println(i + " + " + j + " = " + (i + j));
				}
			}
		}
	}
}

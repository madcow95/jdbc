package com.bizpoll.lambda;

public class Person1 {

	public void greeting(Say1 say) {
		int num = say.something();
		System.out.println("Number is : " + num);
	}
}

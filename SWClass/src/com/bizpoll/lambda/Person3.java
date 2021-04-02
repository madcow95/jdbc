package com.bizpoll.lambda;

public class Person3 {

	public void greeting(Say3 say) {
		int num = say.something(3, 5);
		System.out.println("Number is : " + num);
	}
}

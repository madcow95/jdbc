package com.bizpoll.anonymous;

public class AnonymousMain {
	
	public static void main(String args[]) {
		Anonymous anonymous = new Anonymous();
		
		anonymous.field.wake();
		
		anonymous.method1();
		
		anonymous.method2(new Person() {
			// 익명의 inner 클래스라고 부른다. 이 안에서 동작을 시켜서 Anonymous 클래스의 method2 메소드에 넣는 '한번'만 사용하기 때문에 이름(별명)이 필요없다. 단발성
			String studentNo;
			
			void study() {
				System.out.println("공부합니다.");
			}
			
			@Override
			void wake() {
				System.out.println("8시에 일어납니다.");
				study();
			};
		});
	}

}

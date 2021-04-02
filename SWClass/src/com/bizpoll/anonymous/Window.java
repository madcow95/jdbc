package com.bizpoll.anonymous;

public class Window {
	
	Button button1 = new Button();
	Button button2 = new Button();
	
	Button.OnClickListener listener = new Button.OnClickListener() {
		
		@Override // 오버라이드 : 재정의
		public void onClick() {
			System.out.println("전화를 겁니다.");
			
		}
	};
	
	public Window() {
		button1.setOnClickListener(listener);
		
		// java 1.7까지의 한계
//		button2.setOnClickListener(new Button.OnClickListener() {
//			
//			@Override
//			public void onClick() {
//				System.out.println("메세지를 보냅니다.");
//				
//			}
//		});
		
		// java8 Lambda 들입처럼 생긴
		button2.setOnClickListener(() -> {
			System.out.println("메세지를 보냅니다.");
		}); //java에서 람다를 표현하는 방식 : 메소드 괄호 안에 () / 화살표 기준 오른쪽이 실행된다.
	}
}

package com.bizpoll.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericEx1 {
	
	public static void main(String args[]) {
		
		List list1 = new ArrayList();
		list1.add("hello");
		
		String str = (String) list1.get(0);
		System.out.println(str);
		
		List<String> list2 = new ArrayList<>(); // 1.8ver 부터 앞에만 리턴값을 적어도 된다
		list2.add("0");
		
		String str2 = list2.get(0);
		System.out.println(str2);
		// K에 들어오는 타입 / V에 들어오는 타입 결정
		Map<String, String> map = new HashMap<>();
		
		map.put("1", "범나은");
		map.put("2", "김솔빈");
		map.put("3", "김태인");
		map.put("4", "유지수");
		map.put("5", "구연호");
		
		System.out.println(map);
		System.out.println(map.get("4"));
		
		Map<Integer, String> map1 = new HashMap<>();
	}
}

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
		
		List<String> list2 = new ArrayList<>(); // 1.8ver ���� �տ��� ���ϰ��� ��� �ȴ�
		list2.add("0");
		
		String str2 = list2.get(0);
		System.out.println(str2);
		// K�� ������ Ÿ�� / V�� ������ Ÿ�� ����
		Map<String, String> map = new HashMap<>();
		
		map.put("1", "������");
		map.put("2", "��ֺ�");
		map.put("3", "������");
		map.put("4", "������");
		map.put("5", "����ȣ");
		
		System.out.println(map);
		System.out.println(map.get("4"));
		
		Map<Integer, String> map1 = new HashMap<>();
	}
}

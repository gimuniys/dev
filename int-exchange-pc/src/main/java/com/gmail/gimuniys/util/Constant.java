package com.gmail.gimuniys.util;

import org.springframework.stereotype.Component;

@Component
public class Constant {
	String defaultTest = "접근제어자 생략하면 private";
	public String publicTest = "heap 영역에 저장, 객체를 생성해야 돼!";
	public static String STATIC_TEST = "static 영역에 저장, 객체 생성 안해도 돼! 클래스 이릅으로 바로 접근 가능";
	public final static String FINAL_TEST = "값을 이제 변경할 수 없지!";
	
	public static String TEST_TEXT = "테스트중입니다.";
	private static String API_SERVER = "http://localhost:81";
	
	public static String getApiServer() {
		return API_SERVER;
	}
}

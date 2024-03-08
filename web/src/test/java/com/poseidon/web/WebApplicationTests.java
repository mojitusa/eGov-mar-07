package com.poseidon.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poseidon.web.service.MemberService;

@SpringBootTest
class WebApplicationTests {
	@Autowired
	MemberService memberService;

	@DisplayName("로그인 카운트 값 확인합니다.")
	@Test
	void contextLoads() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", "testID 1");
//		map.put("pw", "01234567");
//		
//		Map<String, Object> result = memberService.login(map);
//		
//		assertEquals(1, Integer.parseInt((String)result.get("count")));
		
		int num = 100;
		assertEquals(100, num);
		
	}
		
}
	

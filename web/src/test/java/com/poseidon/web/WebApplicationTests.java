package com.poseidon.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poseidon.web.dto.BoardDTO;
import com.poseidon.web.service.IndexService;

@SpringBootTest
class WebApplicationTests {
	@Autowired
	IndexService indexService;

	@Test
	@DisplayName("no값 오는지 확인")
	void contextLoads() {
		BoardDTO detail = indexService.detail(406);
//		assertEquals(detail, null);
		//assertEquals("가나다", detail.getBoard_title());
	}

}

package com.poseidon.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poseidon.web.dto.BoardDTO;
import com.poseidon.web.service.IndexService;

@Controller
public class IndexController {
	
	@Autowired
	private IndexService indexService;

	@GetMapping("/index2")
	public String index(Model model) {
		model.addAttribute("test", "테스트입니다.");
		
		List<BoardDTO> list = indexService.boardList();
		
		model.addAttribute("list", list);
		return "index2";
	}
	
	@GetMapping("/index")
	public String index3() {
		
		
		return "index";
	}
	
	@GetMapping("/board")
	public String freeboard(Model model){
		List<BoardDTO> fb = indexService.freeboard();
		model.addAttribute("fb", fb);
		return "board";
	}
	
	
	
	
	//20240307 안드로이드 앱 프로그래밍 psd 
	// 상세보기 -> no 잡기 -> 확인
	// detail.html
	// 값 -> DB에 물어보기 어떤 형태로?  BoardDTO
	@GetMapping("/detail")
	public String detail(@RequestParam("no") int no, Model model) {
		BoardDTO detail = indexService.detail(no);
		model.addAttribute("detail", detail);
		return "detail";
	}
	
	
	
}

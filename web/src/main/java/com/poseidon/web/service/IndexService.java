package com.poseidon.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.web.dao.IndexDAO;
import com.poseidon.web.dto.BoardDTO;

@Service
public class IndexService {
	@Autowired
	private IndexDAO indexDAO;

	public List<BoardDTO> boardList() {
		return indexDAO.boardList();
	}

	public BoardDTO detail(int no) {
		return indexDAO.detail(no);
	}

	public List<BoardDTO> freeboard(int cate) {
		return indexDAO.freeboard(cate);
	}

	public int write(Map<String, Object> map) {
		//DB에 있는 mid, ip를 넣어 주세요.
		map.put("mid", "testID 1");
		
		return indexDAO.write(map);
	}

	public int postDel(int no) {
		 return indexDAO.postDel(no);
		
	}
	
	
}

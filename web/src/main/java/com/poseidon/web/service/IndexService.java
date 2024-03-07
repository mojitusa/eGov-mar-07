package com.poseidon.web.service;

import java.util.List;

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

	public List<BoardDTO> freeboard() {
		return indexDAO.freeboard();
	}
	
	
}

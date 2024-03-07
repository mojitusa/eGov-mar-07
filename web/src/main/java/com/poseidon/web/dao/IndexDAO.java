package com.poseidon.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.poseidon.web.dto.BoardDTO;

@Repository
@Mapper
public interface IndexDAO {

	List<BoardDTO> boardList();

	BoardDTO detail(int no);

	List<BoardDTO> freeboard();
	
}

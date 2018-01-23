package com.iu.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.util.ListData;

public interface BoardService {
	
	//list
	public List<BoardDTO> selectList(ListData listData) throws Exception;
	//one
	public BoardDTO selectOne(int num) throws Exception;
	//insert
	public int insert(BoardDTO boardDTO, MultipartFile [] f1, HttpSession session) throws Exception;
	//update
	public int update(BoardDTO boardDTO, MultipartFile [] f1, HttpSession session) throws Exception;
	//delete
	public int delete(int num, HttpSession session) throws Exception;

}

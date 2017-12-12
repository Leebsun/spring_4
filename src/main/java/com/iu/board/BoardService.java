package com.iu.board;

import java.util.List;

import javax.crypto.AEADBadTagException;

import org.springframework.web.servlet.ModelAndView;

import com.iu.util.ListData;

public interface BoardService {
	
	//selectList
	public ModelAndView selectList(ListData listData)throws Exception;
	
	//selectOne
	public BoardDTO selectOne(int num)throws Exception;
	
	//INSERT
	public int insert(BoardDTO boardDTO)throws Exception;
	
	//update
	public int update(BoardDTO boardDTO)throws Exception;
	
	//delete
	public int delete(int num) throws Exception;
	

}

package com.iu.qna;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.util.ListData;
import com.iu.util.Pager;
import com.iu.util.RowNum;

@Service
public class QnaService implements BoardService{

	@Inject
	private QnaDAO qnaDAO;
	
	
	@Override
	public ModelAndView selectList(ListData listData) throws Exception {
		ModelAndView mv = new ModelAndView();
		RowNum rowNum = listData.makeRow();
		Pager pager = listData.makePage(qnaDAO.totalCount(rowNum));
		List<BoardDTO> ar = qnaDAO.selectList(rowNum);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
		return mv;
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		qnaDAO.hitUpdate(num);
		BoardDTO boardDTO = qnaDAO.selectOne(num);
		return boardDTO;
	}

	@Override
	public int insert(BoardDTO boardDTO, HttpSession session) throws Exception {
		int result = qnaDAO.insert(boardDTO);
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		int result = qnaDAO.update(boardDTO);
		return result;
	}

	@Override
	public int delete(int num) throws Exception {
		int result = qnaDAO.delete(num);
		return result;
	}

	
}

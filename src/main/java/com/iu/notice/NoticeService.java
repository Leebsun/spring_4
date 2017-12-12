package com.iu.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.util.ListData;
import com.iu.util.Pager;
import com.iu.util.RowNum;

@Service
public class NoticeService implements BoardService {
	
	@Inject
	private NoticeDAO noticeDAO;

	@Override
	public ModelAndView selectList(ListData listData) throws Exception {
		ModelAndView mv = new ModelAndView();
		RowNum rowNum = listData.makeRow();
		Pager pager = listData.makePage(noticeDAO.totalCount(rowNum));
		//model.addAttribute("list", noticeDAO.selectList(rowNum));
		//model.addAttribute("pager", pager);
		List<BoardDTO> ar = noticeDAO.selectList(rowNum); 
		mv.addObject("board", "notice");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
	
		
		return mv;
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		NoticeDTO noticeDTO = (NoticeDTO)noticeDAO.selectOne(num);
		
		return noticeDTO;
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {

		
		return noticeDAO.insert(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.update(boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		
		return noticeDAO.delete(num);
	}

}

package com.iu.notice;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.ListData;
import com.iu.util.Pager;
import com.iu.util.RowNum;

@Service
public class NoticeService implements BoardService{

	@Inject
	private NoticeDAO noticeDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private FileDAO fileDAO;
	
	@Override
	public ModelAndView selectList(ListData listData) throws Exception {
		ModelAndView mv = new ModelAndView();
		RowNum rowNum = listData.makeRow();
		Pager pager = listData.makePage(noticeDAO.totalCount(rowNum));
		System.out.println(rowNum.getKind());
		System.out.println(rowNum.getSearch());
		List<BoardDTO> ar = noticeDAO.selectList(rowNum);
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");
		return mv;
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		noticeDAO.hitUpdate(num);
		BoardDTO boardDTO = noticeDAO.selectOne(num);
		//((NoticeDTO)boardDTO).setFileNames(fileDAO.selectList(num));
		
		return boardDTO;
	}

	@Override
	public int insert(BoardDTO boardDTO, HttpSession session) throws Exception {
		MultipartFile [] files = ((NoticeDTO)boardDTO).getFiles();
		//저장 1. 저장경로-realpath
		//List<FileDTO> names = new ArrayList<FileDTO>();
		int result = noticeDAO.insert(boardDTO);
		for (MultipartFile multipartFile : files) {
			String name=fileSaver.fileSave(multipartFile, session, "upload");
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setFileName(name);
			fileDTO.setOriName(multipartFile.getOriginalFilename());
			fileDAO.insert(fileDTO);
		}
		
		//((NoticeDTO)boardDTO).setFileNames(names);
						
		
		
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		int result = noticeDAO.update(boardDTO);
		return result;
	}

	@Override
	public int delete(int num) throws Exception {
		int result = noticeDAO.delete(num);
		return result;
	}
	
	
}

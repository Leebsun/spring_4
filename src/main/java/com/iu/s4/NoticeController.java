package com.iu.s4;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.notice.NoticeService;
import com.iu.util.ListData;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	private ModelAndView mv = new ModelAndView();
	
	
	
	//selectList
	@RequestMapping(value="noticeList")
	public ModelAndView selectList(ListData listData)throws Exception{		
		try {
			
			mv=noticeService.selectList(listData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
		
	}
	
	//selectOne
	@RequestMapping(value="noticeView")
	public ModelAndView selectOne(@RequestParam(defaultValue="0",required=false)int num){
		ModelAndView mv= new ModelAndView();
		try {
			BoardDTO boardDTO = noticeService.selectOne(num);
			mv.addObject("view", boardDTO);
			mv.addObject("board", "notice");
			mv.setViewName("board/boardView");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mv;
	}
	
	
	//insert -> form 이동
	
	//insert -> DB 처리
	
	//update -> form 이동
	
	//update -> DB처리
	
	//Delete 
	@RequestMapping(value="noticeDelete")
	public String delete(int num, RedirectAttributes rd){
		int result=0;
		try {
			result = noticeService.delete(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message="Fail";
		if(result>0){
			message="Success";
		}

		rd.addFlashAttribute("message", message);

		return "redirect:./noticeList";
	}

}

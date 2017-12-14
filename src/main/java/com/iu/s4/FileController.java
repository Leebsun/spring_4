package com.iu.s4;

import java.io.File;
import java.util.Enumeration;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.file.FileDTO;
import com.iu.file.PhotoDTO;
import com.iu.file.PhotoService;
import com.iu.util.FileSaver;

@Controller
@RequestMapping(value="/file/*")
public class FileController {
	
	@Inject
	private PhotoService photoService;
	
	//smartEdiotr image upload
	@RequestMapping(value="photoUpload")
	public String photoUpload(PhotoDTO photoDTO, HttpSession session){
		return photoService.photoUpload(photoDTO, session);
	}
	
	@RequestMapping(value="fileDown")
	public ModelAndView fileDown(FileDTO fileDTO, HttpSession session){
		String filePath = session.getServletContext().getRealPath("resources/upload");
		//저장될 실제 파일 이름
		File file = new File(filePath, fileDTO.getFileName());
		ModelAndView mv = new ModelAndView();
		mv.addObject("down", file);
		mv.addObject("oriname", fileDTO.getOriName());
		//viewName은 
		mv.setViewName("filedown");
		
		return mv;
	}

}

package com.iu.s4;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;

@RestController
@RequestMapping(value="/ajax/*")
public class AjaxController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="memberList")
	@ResponseBody
	public List<MemberDTO> selectList()throws Exception{
		List<MemberDTO> ar=memberService.selectList();
		
		
		return ar;
		
	}
	
	@RequestMapping(value="checkId",method=RequestMethod.GET)
	@ResponseBody
	public MemberDTO checkId(String id){
	
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("t1");
		memberDTO.setPw("t1");
		memberDTO.setName("iu");
		memberDTO.setAge(25);
		//{"id":"t1","pw":"t1", "name":"iu","age":25}
		
		return memberDTO;
		
		
		
	}

}

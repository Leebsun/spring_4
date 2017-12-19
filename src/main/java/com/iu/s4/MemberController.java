package com.iu.s4;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="memberLogin", method=RequestMethod.GET)
	public void membrLogin(){}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public String memberLogin(MemberDTO memberDTO, HttpSession session){
		try {
			memberDTO=memberService.login(memberDTO);
		} catch (Exception e) {
			memberDTO=null;
			e.printStackTrace();
		}
		if(memberDTO != null){
			session.setAttribute("member", memberDTO);
		}
		
		return "redirect:/";	
	}
	
	@RequestMapping(value="memberLogout")
	public String memberLogout(HttpSession session){
		session.removeAttribute("member");
		session.invalidate();
		return "redirect:/";
	}
	
	
	@RequestMapping(value="memberJoin", method=RequestMethod.GET)
	public void memberJoin(){}
	
	@RequestMapping(value="/student/memberJoin", method=RequestMethod.POST)
	public void memberJoinS(MemberDTO memberDTO){
		//파라미터 출력
		System.out.println(memberDTO.getId());
		//System.out.println(memberDTO.getStudentDTO().getTid());
		
	}
	
	@RequestMapping(value="/teacher/memberJoin", method=RequestMethod.POST)
	public void memberJoinT(MemberDTO memberDTO){
		//파라미터 출력
		System.out.println(memberDTO.getId());
		//System.out.println(memberDTO.getTeacherDTO().getSal());
	}

	
	

}

package com.iu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.member.MemberDTO;

public class AuthorInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		HttpSession session = request.getSession();
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		if(!memberDTO.getJob().equals("teacher")){
			modelAndView.setViewName("common/result");
			modelAndView.addObject("message", "룰루랄라");
		}
		
		System.out.println("Author");
	}

}

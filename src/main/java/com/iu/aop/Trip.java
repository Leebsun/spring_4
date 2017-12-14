package com.iu.aop;

import org.springframework.stereotype.Component;

@Component
public class Trip {
	
	public void go(){
		System.out.println("공항으로 출발");
		System.out.println("놀다 오기");
		System.out.println("================");
	}

}

package com.iu.aop;

import org.springframework.stereotype.Component;

@Component
public class Transport {
	
	public void subway(){
		System.out.println("자리 뺏기");
		System.out.println("남의 핸드폰 보기");
		System.out.println("=====================");
		
	}
	
	public void bus(){
		System.out.println("노래듣기");
		System.out.println("창 밖 보기");
		System.out.println("BUS++++++++++++++++++");
		
	}
		
		public void walk(int age){
			System.out.println("침뱉기");
			System.out.println("=================");
			
			
		}
	

}

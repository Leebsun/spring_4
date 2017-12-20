package com.iu.member;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s4.AbstractTest;

public class MemberTest extends AbstractTest {
	
	@Inject
	MemberDAO memberDAO;

	@Test
	public void test() {
		try {
			memberDAO.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finish");
	}

}

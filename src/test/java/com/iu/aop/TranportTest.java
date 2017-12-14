package com.iu.aop;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s4.AbstractTest;

public class TranportTest extends AbstractTest {

	@Inject
	private Transport transport;
	@Inject
	private Trip trip;
	
	
	
	@Test
	public void test() {
		trip.go();

	}

}

package com.Test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("b4 test method fires once for a whole class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After test method fires once for whole class");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

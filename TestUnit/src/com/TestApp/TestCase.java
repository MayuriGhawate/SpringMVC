/**
 * 
 */
package com.TestApp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Mayuri
 *
 */
public class TestCase {

	protected int a1,b1;
	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		a1=5;
		b1=3;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		double result = a1+b1;
		assetTrue(result==8);
	}

}

package com.gama.sha;

import junit.framework.Assert;
import junit.framework.TestCase;

import javax.swing.JOptionPane;


/**
 * lib-sha unit test
 */
public class SHATest extends TestCase {
	
	/**
	 * Test SHA.getRandomSHA256Hash method 
	 */	
	public void testGetRandomSHA256Hash() throws Exception {
		
		SHA sha = new SHA();
		
		try {
			
			String result = sha.getRandomSHA256Hash(128);
			
			assertTrue(true);
			
			
		} catch (Exception e) {
			
			assertTrue(false);
		}
		

	}

	
}
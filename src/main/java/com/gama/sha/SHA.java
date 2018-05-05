package com.gama.sha;

import java.util.Random;
import java.security.MessageDigest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * SHA256 Hash Library 
 */
public class SHA {
	
	private Logger log = LogManager.getLogger(SHA.class.getName());
		
	/**
	 * Method to create SHA-256 Hash String from a block of random bytes
	 * @param quantity : how many random bytes required to feed this method   
	 * @return 64 characters SHA-256 Hash String
	 * @throws Exception
	 */
	public String getRandomSHA256Hash(int quantity) throws Exception { 
		Random randomno = new Random();

        byte[] nbyte = new byte[quantity];

        byte[] encodedhash = null;
        StringBuffer hexString = new StringBuffer();

        randomno.nextBytes(nbyte);

          try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            encodedhash = digest.digest(nbyte);

            for (int i = 0; i < encodedhash.length; i++) {
            String hex = Integer.toHexString(0xff & encodedhash[i]);
            if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

          } catch (Exception e) {
        	  log.error("Error while create random SHA-256 Hash string");
        	  e.printStackTrace();
          }

        return hexString.toString();
	}
	
}
import java.util.Random;
import java.security.MessageDigest;

public class SHA {

    //Compile ==> javac SHA.java
    //Run     ==> java SHA
		
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
        	  e.printStackTrace();
          }

        return hexString.toString();
	}

    public static void main (String[] args) {

        try {
            SHA sha = new SHA();

            String randomHashString = sha.getRandomSHA256Hash(128);

            System.out.println(randomHashString);    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
	
}
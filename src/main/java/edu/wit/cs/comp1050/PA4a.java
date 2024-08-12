package edu.wit.cs.comp1050;


//TODO: document this class
public class PA4a {
	
	/**
	 * Error if incorrect command-line arguments are supplied
	 */
	public static final String ERR_USAGE = "Please supply correct inputs: <encrypted string> <substring>";
	
	/**
	 * Error if shift could not be found
	 */
	public static final String ERR_NONE = "No valid shifts found.";

	public static String decrypt(String message, int shift) {
        StringBuilder decrypted = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char decryptedChar = (char) ((c - base - shift + 26) % 26 + base);
                decrypted.append(decryptedChar);
            } else {
                decrypted.append(c);
            }
        }

        return decrypted.toString();
    }
	
	/**
	 * Outputs all shifts of the encrypted string
	 * that contain the supplied substring
	 * 
	 * @param args command-line arguments: <encrypted string> <substring>
	 */
	public static void main(String[] args) {
		
	}

}

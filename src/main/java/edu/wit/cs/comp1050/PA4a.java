package edu.wit.cs.comp1050;


//TODO: document this class
public class PA4a {

    /**
     * Error if incorrect command-line arguments are supplied
     */
    public static final String ERR_USAGE = "Please supply correct inputs: <encrypted string> <substring>";
    
    /**
     * Error if no valid shifts contain the substring
     */
    public static final String ERR_NONE = "No valid shifts found.";
    
    /**
     * Error if the substring is empty
     */
    public static final String ERR_EMPTY_SUBSTRING = "Substring cannot be empty.";

    /**
     * Outputs all shifts of the encrypted string
     * that contain the supplied substring
     * 
     * @param args command-line arguments: <encrypted string> <substring>
     */
    public static void main(String[] args) {
        // Check for correct number of arguments
        if (args.length != 2) {
            System.out.println(ERR_USAGE);
            return;
        }

        String encryptedString = args[0];
        String substring = args[1];

        // Check if the substring is empty
        if (substring.isEmpty()) {
            System.out.println(ERR_EMPTY_SUBSTRING);
            return;
        }

        // Create a Shifter object with the encrypted string
        Shifter shifter = new Shifter(encryptedString);
        int[] shifts = shifter.findShift(substring);

        // Output results
        if (shifts.length == 0) {
            System.out.println(ERR_NONE);
        } else {
            for (int shift : shifts) {
                System.out.println(String.format("%02d: %s", shift, shifter.shift(shift)));
            }
        }
    }
}
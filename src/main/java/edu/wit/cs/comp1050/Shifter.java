package edu.wit.cs.comp1050;

import java.util.ArrayList;

//TODO: document this class
public class Shifter {
	
	/**
	 * Number of letters in the English alphabet
	 */
	public static final int NUM_LETTERS = ('z' - 'a') + 1;
	
	/**
	 * Initializes the shifter
	 * 
	 * @param s encrypted string
	 */
	public Shifter(String s) {
		// replace with your code
	}

    /**
     * A static method that shifts a character
     * by n positions (either positive or negative).
     * Ignores any non-letter characters.
     *
     * @param c the character
     * @param n amount to shift
     * @return shifted character by a supplied amount
     * 
     * @param n number of places to shift 
     * @return shifted string
     */
    public static char shift1(char c, int n) {
        return ' ';
    }
	
	/**
	 * Returns the result of shifting
	 * by a supplied amount
	 * 
	 * @param n number of places to shift 
	 * @return shifted string
	 */
	public String shift(int n) {
		return null; // replace with your code
	}
	
	/**
	 * Finds all shifts that contain
	 * the supplied substring
	 * 
	 * @param sub substring to find
	 * @return array of shifts (0-25) that contain the substring (in order)
	 */
	public int[] findShift(String sub) {
        ArrayList<Integer> found = new ArrayList<>();

        // replace with your code

        // Convert ArrayList to int array
        // Leave alone!
        int[] foundAsArray = new int[found.size()];
        for (int i = 0; i < found.size(); i++) {
            foundAsArray[i] = found.get(i);
        }

        return foundAsArray;
	}

}

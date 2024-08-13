package edu.wit.cs.comp1050;

import java.util.ArrayList;

//TODO: document this class
public class Shifter {

    /**
     * Number of letters in the English alphabet
     */
    public static final int NUM_LETTERS = ('z' - 'a') + 1;

    private final String encryptedString;

    /**
     * Initializes the shifter
     * 
     * @param s encrypted string
     */
    public Shifter(String s) {
        this.encryptedString = s;
    }

    /**
     * Shifts a character by n positions (either positive or negative).
     * Ignores any non-letter characters.
     *
     * @param c the character
     * @param n amount to shift
     * @return shifted character by a supplied amount
     */
    public static char shift1(char c, int n) {
        if (Character.isLetter(c)) {
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            return (char) ((c - base + n + NUM_LETTERS) % NUM_LETTERS + base);
        }
        return c; // Non-letter characters are returned unchanged
    }

    /**
     * Returns the result of shifting the entire encrypted string
     * by a supplied amount
     * 
     * @param n number of places to shift 
     * @return shifted string
     */
    public String shift(int n) {
        // Normalize shift to be within 0-25
        int normalizedShift = ((n % NUM_LETTERS) + NUM_LETTERS) % NUM_LETTERS;
        StringBuilder shiftedString = new StringBuilder();
        for (char c : encryptedString.toCharArray()) {
            shiftedString.append(shift1(c, normalizedShift));
        }
        return shiftedString.toString();
    }

    /**
     * Finds all shifts that contain the supplied substring
     * 
     * @param sub substring to find
     * @return array of shifts (0-25) that contain the substring (in order)
     */
    public int[] findShift(String sub) {
        ArrayList<Integer> found = new ArrayList<>();

        for (int shift = 0; shift < NUM_LETTERS; shift++) {
            String shifted = shift(shift);
            if (shifted.contains(sub)) {
                found.add(shift);
            }
        }

        // Convert ArrayList to int array
        return found.stream().mapToInt(i -> i).toArray();
    }
}
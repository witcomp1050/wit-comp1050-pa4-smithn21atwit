package edu.wit.cs.comp1050;

import java.util.ArrayList;
import java.util.Scanner;

public class PA4c {
	
	/**
	 * Removes all duplicate values from the supplied list.
	 * 
	 * @param list list from which to remove repeated elements
	 */
	public static void removeRepeated(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			int current = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j) == current) {
					list.remove(j);
					j--; // Adjust index after removal
				}
			}
		}
	}

	/**
	 * Reads numbers from the keyboard and outputs the list of distinct values.
	 * 
	 * @param args command-line arguments, ignored
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<>();

		System.out.printf("Enter integers: ");

		// Read integers until EOF
		while (scanner.hasNextInt()) {
			numbers.add(scanner.nextInt());
		}

		// Remove duplicates
		removeRepeated(numbers);

		// Output distinct values
		if (numbers.isEmpty()) {
			System.out.println("No values entered.");
		} else {
			System.out.print("The distinct integer(s): ");
			for (int i = 0; i < numbers.size(); i++) {
				if (i > 0) {
					System.out.print(" ");
				}
				System.out.print(numbers.get(i));
			}
			System.out.println();
		}
		
		scanner.close();
	}
}
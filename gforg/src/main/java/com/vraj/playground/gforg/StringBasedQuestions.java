/**
 * 
 */
package com.vraj.playground.gforg;

/**
 * 
 * One class to accommodate string based problems.
 * 
 * @author vrajori
 *
 */
public class StringBasedQuestions {

	/**
	 * <a href=
	 * "https://www.geeksforgeeks.org/check-possible-transform-one-string-another">
	 * transformation</a>
	 * 
	 * <pre>
	 * Allowed operantions: 1. Make some lowercase letters uppercase. 2. Delete
	 * all the lowercase letters.
	 * 
	 * @param input
	 * @param base
	 * @return
	 */
	public static boolean transformationPossible(String input, String base) {
		int tracker = 0;
		int baseLen = base.length();
		for (int i = 0; i < input.length(); i++) {
			if (tracker == baseLen) {
				break;
			}
			if (Character.toLowerCase(input.charAt(i)) == Character.toLowerCase(base.charAt(tracker))) {
				tracker++;
				continue;
			}
		}
		return tracker == baseLen;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "daBcd";
		String s2 = "ABC";
		System.out.println(StringBasedQuestions.transformationPossible(s1, s2) == true ? "Yes" : "No");

	}

}

/**
 * 
 */
package com.vraj.playground.gforg;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Given two strings in lowercase, the task is to make them anagram. The only
 * allowed operation is to remove a character from any string. Find minimum
 * number of characters to be deleted to make both the strings anagram. If two
 * strings contains same data set in any order then strings are called Anagrams.
 * <pre>
 * @author vrajori
 *
 */
public class ForcedAnagrams {
	public int remAnagrams(String s, String s1) {
		int count = 0;
		Map<Character, Integer> sMap = new HashMap<>();
		Map<Character, Integer> s1Map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (sMap.get(s.charAt(i)) == null) {
				sMap.put(s.charAt(i), 0);
			}
			sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
		}

		for (int i = 0; i < s1.length(); i++) {
			if (s1Map.get(s1.charAt(i)) == null) {
				s1Map.put(s1.charAt(i), 0);
			}
			s1Map.put(s1.charAt(i), s1Map.get(s1.charAt(i)) + 1);
		}

		for (char c : sMap.keySet()) {
			if (s1Map.get(c) == null) {
				count = count + sMap.get(c);
				continue;
			} else {
				count = count + Math.abs(s1Map.get(c) - sMap.get(c));
				s1Map.remove(c);
			}
		}

		for (char c : s1Map.keySet()) {
			if (sMap.get(c) == null) {
				count = count + s1Map.get(c);
				continue;
			} else {
				count = count + Math.abs(sMap.get(c) - s1Map.get(c));
				sMap.remove(c);
			}
		}
		return count;
	}
}

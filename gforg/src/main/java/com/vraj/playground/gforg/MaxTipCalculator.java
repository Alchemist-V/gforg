package com.vraj.playground.gforg;

/**
 * https://practice.geeksforgeeks.org/problems/maximum-tip-calculator/0
 * 
 * @author vrajori
 *
 */
public class MaxTipCalculator {

	public static void main(String[] args) {
		int N = 8;
		int X = 4;
		int Y = 4;
		int[] A = { 1, 4, 3, 2, 7, 5, 9, 6 };
		int[] B = { 1, 2, 3, 6, 5, 4, 9, 8 };

		int maxTip = 0;

		int[][] track = new int[5][5];
		track[0][0] = 0;

		for (int i = 0; i < N; i++) {
			switch (compare(A[i], B[i])) {
			case ">":
				maxTip = maxTip + A[i];
				X--;
				break;
			case "<":
				break;
			case "=":
				break;
			}
		}
	}

	private static String compare(int i, int j) {
		// TODO Auto-generated method stub
		if (i > j) {
			return ">";
		}

		if (i < j) {
			return "<";
		}

		if (i == j) {
			return "=";
		}
		return "none";
	}
}

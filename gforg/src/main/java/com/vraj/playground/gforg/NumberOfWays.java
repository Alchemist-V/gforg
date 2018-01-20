package com.vraj.playground.gforg;

public class NumberOfWays {

	private static int[] dp = new int[100];
	private static int N = 5;

	public static void main(String[] args) {
		System.out.println(countWays(N)) ;
	}

	private static int countWays(int i) {
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;

		for (int j = 4; j <= i; j++) {
			dp[j] = dp[j - 1] + dp[j - 3] + dp[j - 4];
		}

		return dp[i];
	}

}

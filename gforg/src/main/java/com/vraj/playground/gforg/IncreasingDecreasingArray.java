/**
 * 
 */
package com.vraj.playground.gforg;

/**
 * Find a number in an array that is first increasing and then decreasing.
 * 
 * @author vrajori
 *
 */
public class IncreasingDecreasingArray {

	/**
	 * Method returns index at which array progression pivots.
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public static int locatePivot(int[] arr, int start, int end) {
		int mid = (start + end) / 2;
		System.out.println("mid: " + mid + ", value: " + arr[mid]);

		if (mid == start) {
			return -1;
		}

		if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
			return mid;
		} else if (arr[mid] > arr[mid + 1]) {
			return locatePivot(arr, start, mid);
		} else {
			return locatePivot(arr, mid, end);
		}
	}

	public static int binarySearch(int[] arr, int start, int end, int number, int sortOrder) {
		int mid = (start + end) / 2;
		if (start == mid) {
			if (arr[mid] == number) {
				return mid;
			} else {
				return -1;
			}
		}
		switch (sortOrder) {
		case 0:
			if (number > arr[mid]) {
				return binarySearch(arr, mid, end, number, 0);
			} else {
				return binarySearch(arr, start, mid, number, 0);
			}

		case 1:
			if (number > arr[mid]) {
				return binarySearch(arr, start, mid, number, 1);
			} else {
				return binarySearch(arr, mid, end, number, 1);
			}
		default:
			return -1;
		}

	}

	public static void main(String[] args) {
		int[] arr = { 5, 7, 11, 14, 17, 21, 48, 95, 8, 4, 1, -1, -11 };
		int number = 21;
		// arr.length
		int pivot = IncreasingDecreasingArray.locatePivot(arr, 0, arr.length);
		if (arr[pivot] == number) {
			System.out.println(pivot + " is the index");
		}

		System.out.println(IncreasingDecreasingArray.binarySearch(arr, 0, pivot, number, 0));
		System.out.println(IncreasingDecreasingArray.binarySearch(arr, pivot + 1, arr.length, number, 1));
	}
}

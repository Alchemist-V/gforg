/**
 * 
 */
package com.vraj.playground.gforg.sorting;

/**
 * 
 * Simple class to demonstrate quick sorting technique.
 * 
 * @author vrajori
 *
 */
public class QuickSorting {

	public void partition(int arr[], int start, int end) {

		if (start >= end) {
			return;
		}

		int pivotElement = arr[end];
		int index = start;
		for (int i = start; i < end; i++) {
			if (arr[i] < pivotElement) {
				swap(arr, i, index);
				index++;
			}
		}
		swap(arr, index, end);
		printArr(arr);
		partition(arr, start, index - 1);
		partition(arr, index + 1, end);
	}

	private void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("");

	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	public static void main(String[] args) {
		QuickSorting sort = new QuickSorting();
		int[] a = { 12, 3, 8, 40, 20, 10, 15, 500, 1, 200, 4 };
		sort.partition(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}

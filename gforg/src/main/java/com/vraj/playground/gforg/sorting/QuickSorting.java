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

		int pivotElement = arr[end];
		int index = start;
		for (int i = start; i < end; i++) {
			if (arr[i] < pivotElement) {
				swap(arr, i, index);
				index++;
			}
		}
		swap(arr, index, end);
		partition(arr, start, index - 1);
		partition(arr, index + 1, end);
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	public static void main(String[] args) {
		QuickSorting sort = new QuickSorting();
		int[] a = { 12, 3, 8, 40, 20, 10, 15 };
		sort.partition(a, 0, 6);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}

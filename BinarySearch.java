package binarySearch;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 66, 7, 8, 33, 12, 100, 19, 78 };
		// System.out.println(binarySearch(12, arr));
		// System.out.println(exitstBinarySearch(arr1, 0, arr1.length, 10));
		System.out.println(exitstBinarySearch(arr, 0, arr.length - 1, 33));
	}

	/*
	 * ova e spored mene so for loopovi podele ke najdesh i RECURSIVE binarySearch
	 */
	public static int binarySearch(int key, int arr[]) {
		Arrays.sort(arr);
		int last = arr[arr.length - 1];
		if (arr.length < 1)
			return -1;

		int mid = arr[0] + (last - arr[0]) / 2;
		if (mid == key)
			return mid;
		try {
			if (mid > key) {
				for (int i = 0; i < mid; i++) {
					if (arr[i] == key)
						return arr[i];
				}
			}
			if (mid < key) {
				for (int i = arr[arr.length / 2]; i < arr[arr.length - 1]; i++) {
					if (arr[i] == key)
						return arr[i];
				}
			}
		} catch (Exception e) {
			System.out.println("The element does not exist in this array.");
		}

		return -1;
	}

	/*
	 * check for mid until it is found in either right or left of the arr. if(mid <
	 * ele) -> return rec(element--) else if(mid > ele) -> return rec(ele++) else
	 * mid = key
	 */
	static boolean exitstBinarySearch(int arr[], int first, int last, int key) {
		Arrays.sort(arr);
		while (last >= first) {
			int mid = first + (last - first) / 2;

			if (arr[mid] == key)
				return true;

			if (arr[mid] > key)
				return exitstBinarySearch(arr, first, mid - 1, key);
			if (arr[mid] < key) {
				return exitstBinarySearch(arr, mid + 1, last, key);
			}

		}

		return false;
	}
}

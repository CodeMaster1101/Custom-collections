package test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MileStanislavov{

	/*
	 * 1.	Create algorithm that will accept list of numbers and will return – 20 points
		a.	the average value
		b.	sum value
	 */
	public void listAlg(List<Integer> list) {
		Integer sum = 0;
		Integer avg = 0;
		for(int i = 0; i < list.size(); i++) {
			sum = sum + list.get(i);

			avg = sum/list.size();
			System.out.println("sum: " + sum);
			System.out.println("avg: " + avg);
		}
	}

	/*
	 * 2.	Create application that will allow user to input values through console. Then Implement bublesort aerogram and use it to sort the array of inserted values and print them to colsole. 
	 * 		Use Integer data type – 25 points
	 */

	public void sortInts() {
		List<String> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Input nums then press exit to collect them");
		while(true) {
			String input = scan.nextLine();
			System.out.println("insert: ");
			if(input.equalsIgnoreCase("exit"))
				break;

			list.add(input); 
		}
		Integer arr[] = new Integer[list.size()];
		for(int i = 0; i < list.size(); i++) {
			arr[i] = Integer.parseInt(list.get(i));
		}

		printArray(bubbleSort(arr));
		scan.close();
	}

	/*
	 * 3.	Implement doubly-linked list using Integer data types– 30 points
			a.	addFirst
			b.	addFast
			c.	removeFirst
			d.	removeLast
			e.	size
			f.	sort

			!!!!!!!!!!!!!!!!
			COPY PASTE THIS IN THE TestScript:
		 	MileLinkedList<T> mileLinkedList = new MileLinkedList<T>();
		 	--check if its correct!
	 */


	/*
	 * 4.	Implement binary tree using Integer data types– 25 points
	 * 
	 *	    !!!!!!!!!!!!!!!!!!
	 *   	COPY PASTE THIS IN THE TestScript:
		 	MileBinaryTree<T> mileBinaryTree = new MileBinaryTree<T>();
		 	--check if its correct!
	 */		

	//PRIVATE METHODS
	private Integer[] bubbleSort(Integer arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if (arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
		return arr;
	}
	private void printArray(Integer arr[])
	{ 
		System.out.print("[");
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
		System.out.print("]");
	}
}

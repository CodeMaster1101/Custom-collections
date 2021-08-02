package PalindromeAndBaseConvert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 	Write program that will take number from console with base 12 (twelve digits 0,1,2,3,4,5,6,7,8,9,A, B), converts it to number with base 10 (0, .., 9) and prints it to console
	Write program that will take test from console and return the length of the biggest palindrom (palindrom is word that reads the same from left to tight, and from right to left – for example “ana”, “boob”, … ). Consider the empty spaces as character also – palindrom is also “aba aba”.
	As for extra challenge return the longest palindrome word.
 */

/*
 * 1. create a list and a scanner.
 * 	loop endlessly and add base 10 nums until user inputs exit(trimmed).
 *  check if there's an 'A' 'B' OR "AB", if so change each for every string -> "10" "11" "1011".
 *  add them to a new integer list by parsing the strings!
 *  enjoy.
 *   
 */
public class PandBconvert {

	public static void main(String[] args) {
		PandBconvert obj = new PandBconvert();
		listSysoInt(obj.baseConvert());
		System.out.println(obj.maxPalindrome());

	}

	public Scanner scan = new Scanner(System.in);

	public List<Integer> baseConvert() {
		List<String> arrList = new ArrayList<>();
		List<Integer> arrListInt = new ArrayList<>();
		System.out.println("Insert base 12 numbers to convert them into base 10. (from 0 to B");
		while (true) {
			System.out.println("insert: ");
			String base_inp = scan.nextLine();
			if (base_inp.equalsIgnoreCase("exit"))
				break;

			arrList.add(base_inp);

		}
		for (int i = 0; i < arrList.size(); i++) {

			if (arrList.get(i).contains("A") && arrList.get(i).contains("B")) {
				for (int j = 0; j < arrList.get(i).length(); j++) {
					if (arrList.get(i).charAt(j) == 'A') {
						arrList.get(i).replaceAll("A", "10");
					}
					if (arrList.get(i).charAt(j) == 'B') {
						arrList.get(i).replaceAll("B", "11");
					} else
						continue;
				}
				String AB = arrList.get(i);
				Integer str_Int = Integer.parseInt(AB, 12);
				arrListInt.add(str_Int);
			} else if (arrList.get(i).contains("A")) {
				String A = arrList.get(i).replaceAll("A", "10");
				Integer str_Int = Integer.parseInt(A, 12);
				arrListInt.add(str_Int);
			} else if (arrList.get(i).contains("B")) {
				String B = arrList.get(i).replaceAll("B", "11");
				Integer str_Int = Integer.parseInt(B, 12);
				arrListInt.add(str_Int);
			} else {
				Integer str_Int = Integer.parseInt(arrList.get(i), 12);
				arrListInt.add(str_Int);
			}

		}
		return arrListInt;
	}

	/*
	 * 2. create collection(to check who's the max element). Scanner to input
	 * strings. create another collection for the length of each string from the
	 * first coll. while loop to see if its a palindrome add to coll, if not
	 * continue. add each length of each string to coll of integers. display the
	 * strings just for fun from coll<String>. return the length of the biggest
	 * palindrome and the biggest "word" A.K.A String. Enjoy!
	 */
	public int maxPalindrome() {
		Scanner scan1 = new Scanner(System.in);
		Collection<String> coll = new ArrayList<String>();
		List<Integer> strLength = new ArrayList<Integer>();
		System.out.println(
				"Insert a string and if it's a palidnrome it will be added to the console, then it will check for the biggest palidrome");
		while (true) {
			System.out.println("insert: ");
			String pal_inp = scan.nextLine();
			Integer str_Length = (checkForBlank(pal_inp));
			if (pal_inp.trim().equalsIgnoreCase("exit"))
				break;

			trimStr(pal_inp);
			if (isPalindrome(pal_inp)) {
				strLength.add(str_Length);
				coll.add(pal_inp);
			}

		}

		System.out.println();
		listSysoStr(coll);
		System.out.println();
		System.out.print("The biggest palindrome word: ");
		System.out.println(biggestPal(coll));
		System.out.println();
		System.out.print("Biggest length: ");
		scan1.close();
		scan.close();

		if (strLength.size() <= 0) {
			return strLength.size();
		}
		return Collections.max(strLength);
	}

	// private methods for code support.
	private static void listSysoInt(Collection<Integer> list) {
		System.out.print("[");
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println("]");
	}

	private static void listSysoStr(Collection<String> list) {
		System.out.print("[");
		for (String member : list) {
			System.out.print(member + " ");
		}
		System.out.println("]");
	}

	private static boolean isPalindrome(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String rev = sb.toString();
		if (str.equals(rev)) {
			return true;
		} else {
			return false;
		}

	}

	private String biggestPal(Collection<String> coll) {
		int maxLength = 0;
		String longestString = null;
		for (String s : coll) {
			if (s.length() > maxLength) {
				maxLength = s.length();
				longestString = s;
			}
		}
		return longestString;
	}

	private int checkForBlank(String str) {
		Integer k = str.length();
		for (int j = 0; j < k; j++) {
			if (str.substring(j, j + 1).isBlank())
				k += 1;
		}
		return k;
	}

	private String trimStr(String str) {
		return str.trim();
	}

}

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
 * 	loop endlessly and add base 12 nums until user inputs exit(trimmed).
 *  add them to an Integer collection by parsing each string to a base 10
 *  enjoy.
 *   
 */
public class PandBconvert {

	public static void main(String[] args) {
		PandBconvert obj = new PandBconvert();
		listSysoInt(obj.baseConvert());
		obj.maxPolindrom();
		System.out.println(obj.PalindromeDisplay());

	}

	public Scanner scan = new Scanner(System.in);

	public List<Integer> baseConvert() {
		List<String> arrList = new ArrayList<>();
		List<Integer> arrListInt = new ArrayList<>();
		System.out.println("Insert base 12 numbers to convert them into base 10. (from 0 to B");
		while (true) {
			System.out.println("insert: ");
			String base_inp = scan.nextLine().trim();
			if (base_inp.equalsIgnoreCase("exit"))
				break;

			arrList.add(base_inp);

		}

		for (String Str : arrList) {
			Integer i = Integer.parseInt(Str, 12);
			arrListInt.add(i);
		}

		return arrListInt;

	}

	/*
	 * 2. create collection(to check who's the max element). Scanner to input
	 * strings. create another collection for the length of each string from the
	 * first coll. while loop to see if its a palindrome add to coll, if not
	 * continue. add each length of each string to coll of integers. display the
	 * strings just for fun from coll<String>. return the length of the biggest
	 * palindrome. Enjoy!
	 */
	public int PalindromeDisplay() {
		Scanner scan1 = new Scanner(System.in);
		Collection<String> coll = new ArrayList<String>();
		List<Integer> strLength = new ArrayList<Integer>();
		System.out.println(
				"Insert a string and if it's a palidnrome it will be added to the console, then it will check for the biggest palidrome");
		while (true) {
			System.out.println("insert: ");
			String pal_inp = scan.nextLine();
			Integer str_Length = pal_inp.length();
			if (pal_inp.trim().equalsIgnoreCase("exit"))
				break;

			String x = (pal_inp);
			if (isPalindrome(x)) {
				strLength.add(str_Length);
				coll.add(x);
			}

		}

		System.out.println("The collection: ");
		listSysoStr(coll);
		System.out.println();
		System.out.print("Biggest length: ");
		scan1.close();
		scan.close();

		if (strLength.size() <= 0) {
			return strLength.size();
		}
		return Collections.max(strLength);
	}

	/*
	 * create a list to add every String. Get the biggest string and use the
	 * challenge() method to check for all the substring polindrioms.
	 */
	public void maxPolindrom() {

		List<String> pol_Container = new ArrayList<String>();
		System.out.println("Insert sentences and check for substring-polindroms in the biggest one.");
		while (true) {
			System.out.println("Insert: ");
			String inputPol = scan.nextLine();
			if (inputPol.equalsIgnoreCase("exit"))
				break;

			pol_Container.add(inputPol);

		}

		System.out.println("The biggest sentence to look for substring polindroms: ");
		System.out.println(biggestPal(pol_Container));
		listSysoStr(challenge(biggestPal(pol_Container)));

	}

	// private methods for code support.
	private static void listSysoInt(Collection<Integer> list) {
		System.out.print("[");
		for (Integer integer : list) {
			System.out.print(integer + ", ");
		}
		System.out.println("]");
	}

	private static void listSysoStr(Collection<String> list) {
		System.out.print("[");
		for (String member : list) {
			System.out.print(member + ", ");
		}
		System.out.println("]");
	}

	private static boolean isPalindrome(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String rev = sb.toString();
		if (str.equalsIgnoreCase(rev) && str.length() > 1) {
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

	/*
	 * create a list to store all the strings and substrings in the sentence that
	 * are polindroms. iterate through the sentence(the String). Stop at a blank
	 * char -> end of each word and the start of another. check if that word is a
	 * polindrom and add it if it is. Then go inside that word and check if each 3
	 * or more charachters form a palindromic substring -> if yes -> add to
	 * collection. after each word, while in the first for loop set the values of
	 * both the word and insideWord to "", just to reset the values to default.
	 * return the List.
	 * 
	 * 
	 */
	public static List<String> challenge(String str) {
		String sumOfChars = "";
		String sumOfMiniChars = "";
		List<String> arrList = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {

			if (str.substring(i, i + 1).isBlank() == false) {
				sumOfChars += str.charAt(i);
			}
			if (str.substring(i, i + 1).isBlank() || i == str.length() - 1) {
				if (isPalindrome(sumOfChars))
					arrList.add(sumOfChars);

				for (int j = 0; j < sumOfChars.length(); j++) {

					if (isPalindrome(sumOfMiniChars)) {
						arrList.add(sumOfMiniChars);
						sumOfMiniChars = sumOfChars.substring(j - 1, j + 1);
					} else {
						sumOfMiniChars += sumOfChars.substring(j, j + 1);

					}

				}
				sumOfMiniChars = "";
				sumOfChars = "";

			}

		}

		return arrList;
	}

}

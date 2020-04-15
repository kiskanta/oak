package ksh.hacker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MakingAnagrams {
	// Complete the makingAnagrams function below.
	static int makingAnagrams(String s1, String s2) {
		if(s1.length() == 0 || s2.length() ==0) {
			return s1.length() == 0 ? s2.length(): s1.length();
		}
		char[] s1Char = s1.toCharArray();
		char[] s2Char = s2.toCharArray();
		int[] s1d = new int[26];
		int[] s2d = new int[26];
		
		return 0;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s1 = scanner.nextLine();

		String s2 = scanner.nextLine();

		int result = makingAnagrams(s1, s2);

		scanner.close();
	}
}

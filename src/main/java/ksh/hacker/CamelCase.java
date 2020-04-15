package ksh.hacker;

import java.io.IOException;
import java.util.Scanner;

/**
 * Alice wrote a sequence of words in CamelCase as a string of letters, , having the following properties:

It is a concatenation of one or more words consisting of English letters.
All letters in the first word are lowercase.
For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.
Given , print the number of words in  on a new line.

For example, . There are  words in the string.

Function Description

Complete the camelcase function in the editor below. It must return the integer number of words in the input string.

camelcase has the following parameter(s):

s: the string to analyze
Input Format

A single line containing string .

Constraints

Output Format

Print the number of words in string .

Sample Input

saveChangesInTheEditor
Sample Output

5
Explanation

String  contains five words:

save
Changes
In
The
Editor
Thus, we print  on a new line. 
 * @author KingShore
 *
 */
public class CamelCase {
	// Complete the camelcase function below.
	static int camelcase(String s) {
		String[] split = s.split("(?=\\p{Upper})");
		return split.length;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		//String s = scanner.nextLine();
		
		String s = "testBazer";
		int result = camelcase(s);

		//bufferedWriter.write(String.valueOf(result));
		//bufferedWriter.newLine();
		//bufferedWriter.close();

		scanner.close();
	}
}

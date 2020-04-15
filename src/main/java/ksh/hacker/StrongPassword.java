package ksh.hacker;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StrongPassword {
	static int minimumNumber(int n, String password) {
		int count = 0;
		if(!password.matches(".*[A-Z].*")) {count++;}
		if(!password.matches(".*[0-9].*")) {count++;}
		if(!password.matches(".*[a-z].*")) {count++;}	////if there is no match to a lowercase,"lc" is increased by 1.
		if(password.matches("[a-zA-Z0-9]*")) {
		        count++;
		}
		
		int lengthDifference = 6 - password.length();

	    if(lengthDifference > 0 && count <= lengthDifference) {
	        return lengthDifference;
	    }

	    return count;
	}
	// Complete the minimumNumber function below.
	/**
	static int minimumNumber(int n, String password) {
		int count =4;
		Pattern uppercase = Pattern.compile("[A-Z]");
		Pattern lowercase = Pattern.compile("[a-z]");
		Pattern number = Pattern.compile("[0-9]");
		Pattern special = Pattern.compile("[!@#$%^&*()-+]");
		
		if(uppercase.matcher(password).find()) {
			count--;
		}
		if(lowercase.matcher(password).find()) {
			count--;
		}
		if(number.matcher(password).find()) {
			count--;
		}
		if(special.matcher(password).find()) {
			count--;
		}
		return Math.max(count, 6-n);
	}*/

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String password = scanner.nextLine();
		int answer = minimumNumber(n, password);
		System.out.println(answer);
		scanner.close();
	}
}

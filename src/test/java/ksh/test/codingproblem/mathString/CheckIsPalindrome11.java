package ksh.test.codingproblem.mathString;

import java.util.stream.IntStream;

public class CheckIsPalindrome11 {
	public boolean isPalindrome(String str){
		int f=0, r = str.length()-1;
		
		while(r>f) {
			if(str.charAt(f) != str.charAt(r)) {
				return false;
			}
			f++;
			r--;
		}
		return true;
	}
	
	public boolean isPalindromeFor(String str) {
		int n= str.length();
		
		for(int i=0; i< n/2; i++) {
			if(str.charAt(i) != str.charAt(n-i-1)) {
				return false;
			}
		}
		return true;
	}

	public boolean isPalindromeSB(String str) {
		String reverse = new String (new StringBuffer(str).reverse());
		return str.equals(reverse);
	}

	public boolean isPalindromeFuntional(String str) {
		/*
		 * return IntStream.range(0, str.length()/2) .noneMatch(p -> str.charAt(p) !=
		 * str.charAt(str.length()-p-1));
		 */
		
		return IntStream.range(0, str.length()/2).noneMatch(p -> str.charAt(p) != str.charAt(str.length()-p-1));
	}
	
	public static void main(String[] args) {
		CheckIsPalindrome11 isPalindrom = new CheckIsPalindrome11();
		boolean result = isPalindrom.isPalindrome("ABCDEFEDCBA");
		System.out.println(result);
		
		boolean resultFor = isPalindrom.isPalindromeFor("ABCDEFEDCBA");
		System.out.println(resultFor);
		
		boolean resultSB = isPalindrom.isPalindromeSB("ABCDEFEDCBA");
		System.out.println(resultSB);

	}
}

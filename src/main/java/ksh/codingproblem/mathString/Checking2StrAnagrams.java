package ksh.codingproblem.mathString;

import java.util.Arrays;

public class Checking2StrAnagrams {

	private static final int EXTENDED_ASCII_CODES = 256;
	
	public boolean isAnagramsV1(String str1, String str2){
		
		char[] str1Chr =  str1.replaceAll("\\s", "").toLowerCase().toCharArray();
		char[] str2Chr =  str2.replaceAll("\\s", "").toLowerCase().toCharArray();
		
		if(str1Chr != str2Chr) {
			return false;
		}
		
		Arrays.sort(str1Chr);
		Arrays.sort(str2Chr);
		
		return Arrays.equals(str1Chr, str2Chr);
	}
	
	/*
	 * public boolean isAnagramsV2(String str1, String str2){
	 * 
	 * }
	 */
}

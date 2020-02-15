package ksh.codingproblem.mathString;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class JoinMultipleString9 {

	public String joinByDelimiterV1(char delimiter, String... str){
		if(str == null || str.length ==0) {
			//throw IllegalArgumentException("String array is null or empty");
			return "";
		}
		StringBuilder result = new StringBuilder();
		
		int i=0;
		for(i=0; i< str.length; i++) {
			result.append(str[i]).append(delimiter);
		}
		
		return result.toString();
	}
	
	public String joinByDelimiterV2(char delimiter, String... str) {
		if(str == null || str.length ==0) {
			//throw IllegalArgumentException("String array is null or empty");
			return "";
		}
		StringJoiner joiner = new StringJoiner(String.valueOf(delimiter));
		
		for(String arg: str) {
			joiner.add(arg);
		}
		return joiner.toString();
	}
	
	public String joinByDelimiterV3(char delimiter, String... str) {
		if(str == null || str.length ==0) {
			//throw IllegalArgumentException("String array is null or empty");
			return "";
		}
		
		return Arrays.stream(str, 0, str.length)
				.collect(Collectors.joining(String.valueOf(delimiter)));
	}
}

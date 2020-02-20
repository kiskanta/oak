package ksh.codingproblem.mathString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountStringInString17 {

	public int countringStringInString(String input, String findStr){
		int position = 0;
		int count = 0;
		int n = findStr.length();
		
		while((position = input.indexOf(findStr, position)) != -1) {
			position = position + n;
			count++;
		}
		return count;
	}
	
	public int countringStringInStringV2(String input, String findStr){
		int result = input.split(Pattern.quote(findStr), -1).length - 1;
		
		return result <0 ? 0: result;
	}
	
	public int countringStringInStringV3(String input, String findStr){
		
		Pattern pattern = Pattern.compile(Pattern.quote(findStr));
		Matcher matcher = pattern.matcher(input);
		
		int position = 0;
		int count = 0;
		
		while(matcher.find(position)) {
			position = matcher.start() + 1;
			count++;
		}
		
		return count++;
	}

	public int countringStringInStringV4(String input, String findStr){
		int position = 0;
		int count = 0;
		//int n = findStr.length();
		
		while((position = input.indexOf(findStr, position)) != -1) {
			position++;
			count++;
		}
		return count;
	}
	
}

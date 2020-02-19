package ksh.codingproblem.mathString;

import java.util.regex.Pattern;

public class CheckStringContainsSubstring16 {
	public boolean containsV1(String text, String subText){
		return text.matches("(?i).*"+Pattern.quote(subText)+".*");
	}
	
	public boolean containsV2(String text, String subText){
		return text.indexOf(subText) != -1;
	}
}

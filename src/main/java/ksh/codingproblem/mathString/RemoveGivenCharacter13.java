package ksh.codingproblem.mathString;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RemoveGivenCharacter13 {
	public String removeCharacterV1(String str, char ch){
		if(str == null || str.isEmpty()) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		char[] strArray  = str.toCharArray();
		
		for(char c :strArray) {
			if(c!=ch) {
				sb.append(c);
			}
		}
		return new String(sb);
	}
	
	public String removeCharacterV2(String str, char ch){
		if(str == null || str.isEmpty()) {
			return "";
		}
		return str.replaceAll(Pattern.quote(String.valueOf(ch)), "");
	}
	
	public String removeCharacterV3(String str, char ch){
		if(str == null || str.isEmpty()) {
			return "";
		}
		return str.chars()
				.filter(c -> c != ch)
				.mapToObj(c -> String.valueOf((char)c))
				.collect(Collectors.joining());
	}

	public String removeCharacterV4(String str, String ch) {
		if(str ==null || str.isEmpty()) {
			return "";
		}
		
		int codePoint = ch.codePointAt(0);
		return str.codePoints()
				.filter(c -> c != codePoint)
				.mapToObj(c -> String.valueOf(Character.toChars(c)))
				.collect(Collectors.joining());
	}
}

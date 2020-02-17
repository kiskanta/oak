package ksh.codingproblem.mathString;

import java.util.Arrays;
import java.util.Comparator;

public class SortStrArryByLen15 {
	
	public enum Sort{
		ASC, DEC;
	}
	public void sortArrayByLength(String str[], Sort direction){
		
		if(direction.equals(Sort.ASC)) {
			Arrays.sort(str, (String s1, String s2) -> Integer.compare(s1.length(), s2.length()) );
		}else {
			Arrays.sort(str, (String s1, String s2) -> (-1)* Integer.compare(s1.length(), s2.length()));
		}
	}
	
	public void sortArrayByLengthV2(String str[], Sort direction){
		if(direction.equals(Sort.ASC)) {
			Arrays.sort(str, Comparator.comparingInt(String::length));
		}else {
			Arrays.sort(str, Comparator.comparingInt(String::length).reversed());
		}
	}

	public String[] sortArrayByLengthV3(String str[], Sort direction){
		if(direction.equals(Sort.ASC)) {
			return Arrays.stream(str)
				.sorted(Comparator.comparingInt(String::length))
				.toArray(String[]::new);
		}else {
			return Arrays.stream(str)
				.sorted(Comparator.comparingInt(String::length).reversed())
				.toArray(String[]::new);
		}
	}
}

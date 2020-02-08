package ksh.codingproblem.mathString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class RemoveDuplicateInStr {
	public String removeDuplicates(String str){
		char[] chars = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(char c : chars) {
			if(sb.indexOf(String.valueOf(c)) == -1) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	
	
	
	
	public String removeDiplicateHashSet(String str) {
		char cr[] = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		var set = new HashSet<Character>();
		
		for(char c : cr) {
			if(set.add(c)) {
				sb.append(c);
			}
		}
		
		return sb.toString();
	}
	
	public String removeDiplicateStream(String str) {
		return Arrays.asList(str.split("")).stream()
			.distinct()
			.collect(Collectors.joining());
	}
	public static void main(String[] args) {
		RemoveDuplicateInStr dupStr = new RemoveDuplicateInStr();
		String TEXT = "!ABCBA;C D E-D  D  DFA;";
		long startTime = System.nanoTime();
		String dup1 =dupStr.removeDuplicates(TEXT);		
		displayExecutionTime(System.nanoTime()-startTime);
		System.out.println(dup1);
		
		long startTimeSet = System.nanoTime();
		String dup2 =dupStr.removeDiplicateHashSet(TEXT);
		displayExecutionTime(System.nanoTime() - startTimeSet);
		System.out.println(dup2);
		
		long startTimeStream = System.nanoTime();
		String dup3 = dupStr.removeDiplicateStream(TEXT);
		displayExecutionTime(System.nanoTime() - startTimeStream);
		System.out.println(dup3);
	}
	
	
	public static void displayExecutionTime(long time){
		System.out.println("Exection Time "+time+" ns ("+TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS)+" ms");
	}
}

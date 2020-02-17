package ksh.test.codingproblem.mathString;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ksh.codingproblem.mathString.SortStrArryByLen15;

public class SortStrArryByLen15Test {

	private static SortStrArryByLen15 sortArray = null; 
	
	private static String[] strs = {"one", "two", "three", "four", "five",
	        "six", "seven", "eight", "nine", "ten"};
	
	@BeforeAll
	public static void init() {
		sortArray = new SortStrArryByLen15();
	}
	
	@Test
	public void testV1() {
		long startTimeV1 = System.nanoTime();
		sortArray.sortArrayByLength(strs, SortStrArryByLen15.Sort.DEC);
		dispalyExecution(System.nanoTime()-startTimeV1);
		System.out.println("String Desc Order is "+Arrays.toString(strs));
		
		long startTimeV2 = System.nanoTime();
		sortArray.sortArrayByLengthV2(strs, SortStrArryByLen15.Sort.ASC);
		dispalyExecution(System.nanoTime() - startTimeV2);
		System.out.println("String Asec Order is "+Arrays.toString(strs));
		
		long startTimeV3 = System.nanoTime();
		String[] strArryV3 = sortArray.sortArrayByLengthV3(strs, SortStrArryByLen15.Sort.DEC);
		dispalyExecution(System.nanoTime() - startTimeV3 );
		System.out.println("String Desc Order, using Functional is "+Arrays.toString(strArryV3));
	}
	
	private void dispalyExecution(long time) {
		System.out.println("Exection time:  "+time+" ns ("+TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS)+" ms).");
	}
}

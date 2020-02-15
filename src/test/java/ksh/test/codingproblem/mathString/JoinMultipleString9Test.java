package ksh.test.codingproblem.mathString;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ksh.codingproblem.mathString.JoinMultipleString9;

public class JoinMultipleString9Test {

	private static final String TEXT_1 = "Illinois";
    private static final String TEXT_2 = "Mathematics";
    private static final String TEXT_3 = "and";
    private static final String TEXT_4 = "Science";
    private static final String TEXT_5 = "Academy";
    private static JoinMultipleString9 joinStr = null;
    
	@BeforeAll
	public static void init() {
		joinStr = new JoinMultipleString9();
	}
	
	@Test
	public void join() {
		long startJoinV1 = System.nanoTime();
		String stringV1 = String.join(" ", TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);
		
		displayExectionTime(System.nanoTime() - startJoinV1);
		System.out.println(stringV1);
		
		long startJoinV2 = System.nanoTime();
		String stringV2 = joinStr.joinByDelimiterV1(' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);
		
		displayExectionTime(System.nanoTime() - startJoinV2);
		System.out.println(stringV2);
		
		long startJoinV3 = System.nanoTime();
		String stringV3 = joinStr.joinByDelimiterV2(' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);
		
		displayExectionTime(System.nanoTime() - startJoinV3);
		System.out.println(stringV3);
		
		long startJoinV4 = System.nanoTime();
		String stringV4 = joinStr.joinByDelimiterV3(' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);
		
		displayExectionTime(System.nanoTime() - startJoinV4);
		System.out.println(stringV4);	
	}
	private static void displayExectionTime(long time) {
		System.out.println("Exection Time : "+time+" ns ("+	TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS)+" ms)");
	}
}

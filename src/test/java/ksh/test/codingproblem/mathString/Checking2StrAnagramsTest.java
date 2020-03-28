package ksh.test.codingproblem.mathString;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ksh.codingproblem.mathString.Checking2StrAnagrams;

public class Checking2StrAnagramsTest {
	
	private static Checking2StrAnagrams stsAnagrams = null;
	
	private static final String TEXT1 = "hello world";
    private static final String TEXT2 = "dh\n le rlo l wo"; 
	
	@BeforeAll
	public static void init() {
		stsAnagrams = new Checking2StrAnagrams();
	}

	@Test
	public void test2StrsAnagrams() {
		long startT1 = System.nanoTime();
		boolean v1 = stsAnagrams.isAnagramsV1(TEXT1, TEXT2);
		displayExectionTime(System.nanoTime()-startT1);
		
		long startT2 = System.nanoTime();
		boolean v2 = stsAnagrams.isAnagramsV1(TEXT1, TEXT2);
		displayExectionTime(System.nanoTime()-startT1);
		
		System.out.println(v1);
		System.out.println(v2);
	}
	
	private static void displayExectionTime(long time) {
		System.out.println("Executio time "+time+" ns ("+TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS)+" ms.)");
	}
}

package ksh.test.codingproblem.mathString;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;

import ksh.codingproblem.mathString.GenreatingAllPermutations10;

public class GenreatingAllPermutations10Test {
	private static GenreatingAllPermutations10 genratPermutation = null;
	
	@BeforeAll
	public static void init() {
		genratPermutation = new GenreatingAllPermutations10();
	}
	
	public void test(){
		long startTime = System.nanoTime();
		
		genratPermutation.permitAndPrint(" ", "kishore");
		displayExectionTime(System.nanoTime()-startTime);
		
		long systemStore = System.nanoTime();
		var genrateStore = genratPermutation.permitAndStore(" ", "kishore");
		System.out.print(genrateStore);
		displayExectionTime(System.nanoTime()-systemStore);
		
		long systemStream = System.nanoTime();
		genratPermutation.permitAndStream(" ", "kishore");
		displayExectionTime(System.nanoTime()-systemStream);
		
		long permuteAndReturn = System.nanoTime();
		var gernReturnStream = genratPermutation.permuteAndReturnStream("kishore");
		
		gernReturnStream.forEach(System.out::println );
		displayExectionTime(System.nanoTime()-permuteAndReturn);
		
	}
	
	public static void displayExectionTime(long time) {
		System.out.println("\nExecution Time "+time+" ns( "+TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS)+" ns)");
	}
}

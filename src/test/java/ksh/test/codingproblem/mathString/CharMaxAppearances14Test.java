package ksh.test.codingproblem.mathString;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ksh.codingproblem.mathString.CharMaxAppearances14;
import ksh.codingproblem.mathString.Pair;

public class CharMaxAppearances14Test {
	private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
			+ "showed me that anything is possible and that you're never too young to think big. "
			+ "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
			+ "or Fermilab. After graduating, I attended Stanford for a degree in economics and " + "computer science.";

	private static CharMaxAppearances14 charMaxApperance = null;
			
	Pair<Character, Integer> pairInte = null;
	Pair<Character, Long> pairLong = null;
	@BeforeAll
	public static void init() {
		charMaxApperance = new CharMaxAppearances14();
	}
	
	@Test
	public void test() {
		long startTimeV1 = System.nanoTime();
		pairInte = charMaxApperance.maxOccurenceCharacter(TEXT);
		displayExectionTime(System.nanoTime()-startTimeV1);
		
		System.out.println("Pair "+pairInte);
		
		long startTimeV2 = System.nanoTime();
		pairInte = charMaxApperance.maxOccurenceCharacterV2(TEXT);
		displayExectionTime(System.nanoTime()-startTimeV2);
		
		System.out.println("Pair "+pairInte);
		
		long startTimeV3 = System.nanoTime();
		pairLong = charMaxApperance.maxOccurenceCharacterV3(TEXT);
		displayExectionTime(System.nanoTime()-startTimeV3);
		System.out.println("Pair "+pairLong);
	}
	
	public static void displayExectionTime(Long time) {
		System.out.println("Exection Time : "+time+" ns ("+TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS)+" ms.)");
	}
}

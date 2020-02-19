package ksh.test.codingproblem.mathString;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ksh.codingproblem.mathString.CheckStringContainsSubstring16;

public class CheckStringContainsSubstring16Test {
	private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";
	
	private static CheckStringContainsSubstring16 checkStr = null;
	private static final String SUBTEXT = "programmer";
	
	@BeforeAll
	public static void init() {
		checkStr = new CheckStringContainsSubstring16();
	}
	
	@Test
	public void testCheckStr() {
		
	}
}

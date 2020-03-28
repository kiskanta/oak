package ksh.test.codingproblem.mathString;

import java.time.Clock;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ksh.codingproblem.mathString.CountStringInString17;

public class CountStringInString17Test {

	private static CountStringInString17 strInStr = null;
	
	@BeforeAll
	public static void init(){
		strInStr = new CountStringInString17();
	}
	
	public String string = "11111";
	public String subString = "11";
	
	@Test
	public void testStrInStr() {
		Clock clock = Clock.systemUTC();
		
		long startTimeV1 = clock.millis(); 
		int count = strInStr.countringStringInString(string, subString);
		displayExecutionTime(clock.millis() - startTimeV1);
		
		long startTimeV2 = clock.millis();
		//int count2 = strInStr.countringStringInStringV2(string, subString);
		displayExecutionTime(clock.millis() - startTimeV2);
		
		long startTimeV3 = clock.millis();
		int count3 = strInStr.countringStringInStringV3(string, subString);
		displayExecutionTime(clock.millis() - startTimeV3);
		
		long startTimeV4 = clock.millis();
		int count4 = strInStr.countringStringInStringV4(string, subString);
		displayExecutionTime(clock.millis() - startTimeV4);
		
		System.out.println(count);
		//System.out.println(count2);
		System.out.println(count3);
		System.out.println(count4);
	}
	private static void displayExecutionTime(long time){
		System.out.println("Exection Time: "+time +" ms( "+TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS)+" s.)");
	}
	
}

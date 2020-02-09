package ksh.test.codingproblem.mathString;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ksh.codingproblem.mathString.RemoveGivenCharacter13;

public class RemoveGivenCharacter13Test {
	private static final String TEXT = "oobotooorogshŜoootorgo";
    private static final char CHAR = 'Ŝ';
       
    private static final String TEXT_CP = "😍 I love 💕 you Ӝ so much 💕 😍";
    private static final String CHAR_CP = "Ӝ";   // Unicode: \u04DC, Code Point: 1244
    private static final String CHAR_CPS = "💕"; // Unicode: \uD83D\uDC95, Code Point: 128149
    
	private static RemoveGivenCharacter13 removeGivenCharacter = null;
	
	@BeforeAll
	public static void init(){
		removeGivenCharacter = new RemoveGivenCharacter13();
	}
	
	@Test
	public void v1Test(){
		long startV1 = System.nanoTime();
		String resultv1 = removeGivenCharacter.removeCharacterV1(TEXT, CHAR);
		System.out.println("After v1 "+resultv1);
		displayExectionTime(System.nanoTime()-startV1);
		 
		long startV2 = System.nanoTime();
		String resultv2 =removeGivenCharacter.removeCharacterV2(TEXT, CHAR);
		displayExectionTime(System.nanoTime()-startV2);
		System.out.println("After v2 "+resultv2);
		
		long startV3 = System.nanoTime();
		String resultv3 =removeGivenCharacter.removeCharacterV3(TEXT, CHAR);
		displayExectionTime(System.nanoTime()-startV3);
		System.out.println("After v3 "+resultv3);
		
		
		long startV4 = System.nanoTime();
		String resultv4 = removeGivenCharacter.removeCharacterV4(TEXT_CP, CHAR_CP);
		displayExectionTime(System.nanoTime()-startV4);
		System.out.println("After v4 "+resultv4);
		
		startV4 = System.nanoTime();
		resultv4 = removeGivenCharacter.removeCharacterV4(TEXT_CP, CHAR_CPS);
		displayExectionTime(System.nanoTime()-startV4);
		System.out.println("After v4 "+resultv4);
	}
	
	public static void displayExectionTime(long time){
		System.out.println("Execution time : "+time+" ns ("+TimeUnit.MILLISECONDS.convert(time, TimeUnit.MILLISECONDS)+" ms).");
	}
}

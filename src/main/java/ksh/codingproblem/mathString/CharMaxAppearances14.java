package ksh.codingproblem.mathString;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CharMaxAppearances14 {
	private static final int EXTENDED_ASCII_CODE = 256; 
	
	public static Pair<Character, Integer> maxOccurenceCharacter(String str) {
		Map<Character, Integer> counter = new HashMap<>();
		char[] chStr = str.toCharArray();

		for (int i = 0; i < chStr.length; i++) {
			char currentCh = chStr[i];
			if (!Character.isWhitespace(currentCh)) {
				Integer noCh = counter.get(currentCh);
				if (noCh == null) {
					counter.put(currentCh, 1);
				} else {
					counter.put(currentCh, ++noCh);
				}
			}
		}
		int maxOccurences = Collections.max(counter.values());
		char maxCharacter = Character.MIN_VALUE;

		for (Entry<Character, Integer> entry : counter.entrySet()) {
			if (entry.getValue() == maxOccurences) {
				maxCharacter = entry.getKey();
			}
		}

		return new Pair(maxCharacter, counter.get(maxCharacter));
	}
	
	public Pair<Character, Integer> maxOccurenceCharacterV2(String str) {
		if(str == null || str.isBlank()) {
			return Pair.of(Character.MIN_VALUE, -1);
		}
		
		int maxOccurence = -1;
		char maxCharacter = Character.MIN_VALUE;
		
		char[] chStr = str.toCharArray();
		int[] asciiCode = new int[EXTENDED_ASCII_CODE];
		
		for(int i=0; i< chStr.length; i++) {
			char currentCh = chStr[i];
			
			if(!Character.isWhitespace(currentCh)) {
				int code = (int) currentCh;
				
				asciiCode[code]++;
				
				if(asciiCode[code]> maxOccurence) {
					maxOccurence = asciiCode[code];
					maxCharacter = currentCh;
				}
			}
		}
		return Pair.of(maxCharacter, maxOccurence);
	}
	
	public Pair<Character, Long> maxOccurenceCharacterV3(String str) {
		if (str == null || str.isBlank()) {
			return Pair.of(Character.MIN_VALUE, -1L);
		}
		return str.chars() //
				.filter(c -> Character.isWhitespace(c) == false) //
				.mapToObj(c -> (char) c) //
				.collect(Collectors.groupingBy(c -> c, Collectors.counting())) //
				.entrySet() //
				.stream() //
				.max(Map.Entry.comparingByValue())//
				.map(p -> Pair.of(p.getKey(), p.getValue())) //
				.orElse(Pair.of(Character.MIN_VALUE, -1L)); //
	}
}

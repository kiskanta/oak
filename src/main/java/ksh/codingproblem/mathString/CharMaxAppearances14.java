package ksh.codingproblem.mathString;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CharMaxAppearances14 {

	public static Pair<Character, Integer> maxOccurenceCharaacter(String str) {
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

class Pair<V, C> {
	final V character;
	final C occurence;

	public Pair(V character, C occurence) {
		this.character = character;
		this.occurence = occurence;
	}

	static <V, C> Pair<V, C> of(V character, C occurence) {
		return new Pair<>(character, occurence);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((character == null) ? 0 : character.hashCode());
		result = prime * result + ((occurence == null) ? 0 : occurence.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pair)) {
			return false;
		}

		@SuppressWarnings("rawtypes")
		Pair pair = (Pair) obj;
		return this.character.equals(pair.character) && this.occurence.equals(pair.occurence);
	}

	@Override
	public String toString() {
		return "Pair [character=" + character + ", occurence=" + occurence + "]";
	}

}
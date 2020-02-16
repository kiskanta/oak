package ksh.codingproblem.mathString;

public class Pair<V, C> {
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

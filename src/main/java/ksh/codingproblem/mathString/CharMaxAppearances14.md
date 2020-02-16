14. Finding the character with the most appearances

A pretty straightforward solution relies on HashMap. This solution consists of three steps:

* First, loop the characters of the given string and put the pairs of the key-value in HashMap where the key is the current character and the value is the current number of occurrences
* Second, compute the maximum value in HashMap (for example, using Collections.max()) representing the maximum number of occurrences
* Finally, get the character that has the maximum number of occurrences by looping the HashMap entry set

The utility method returns Pair<Character, Integer> containing the character with the most appearances and the number of appearances (notice that the white spaces are ignored). If you don't prefer to have this extra class, that is, Pair, then just rely on Map.Entry<K, V>:

```java
public static Pair<Character, Integer> maxOccurenceCharacter(
  String str) {

  Map<Character, Integer> counter = new HashMap<>();
  char[] chStr = str.toCharArray();

  for (int i = 0; i < chStr.length; i++) {
    char currentCh = chStr[i];
    if (!Character.isWhitespace(currentCh)) { // ignore spaces
      Integer noCh = counter.get(currentCh);
      if (noCh == null) {
        counter.put(currentCh, 1);
      } else {
        counter.put(currentCh, ++noCh);
      }
    }
  }

  int maxOccurrences = Collections.max(counter.values());
  char maxCharacter = Character.MIN_VALUE;

  for (Entry<Character, Integer> entry: counter.entrySet()) {
    if (entry.getValue() == maxOccurrences) {
      maxCharacter = entry.getKey();
    }
  }

  return Pair.of(maxCharacter, maxOccurrences);
}
```

If using HashMap looks cumbersome, then another solution (that's a little faster) consists of relying on the ASCII codes. This solution starts with an empty array of 256 indexes (256 is the maximum number of extended ASCII table codes; more information can be found in the Finding the first non-repeated character section). Furthermore, this solution loops the characters of the given string and keeps track of the number of appearances for each character by increasing the corresponding index in this array:

```java
private static final int EXTENDED_ASCII_CODES = 256;
...
public static Pair<Character, Integer> maxOccurenceCharacter(
  String str) {

  int maxOccurrences = -1;
  char maxCharacter = Character.MIN_VALUE;
  char[] chStr = str.toCharArray();
  int[] asciiCodes = new int[EXTENDED_ASCII_CODES];

  for (int i = 0; i < chStr.length; i++) {
    char currentCh = chStr[i];
    if (!Character.isWhitespace(currentCh)) { // ignoring space
      int code = (int) currentCh;
      asciiCodes[code]++;
      if (asciiCodes[code] > maxOccurrences) {
        maxOccurrences = asciiCodes[code];
        maxCharacter = currentCh;
      }
    }
  }

  return Pair.of(maxCharacter, maxOccurrences);
}
```
The last solution we will discuss here relies on Java 8 functional style:

```java
public static Pair<Character, Long> 
    maxOccurenceCharacter(String str) {

  return str.chars()
    .filter(c -> Character.isWhitespace(c) == false) // ignoring space
    .mapToObj(c -> (char) c)
    .collect(groupingBy(c -> c, counting()))
    .entrySet()
    .stream()
    .max(comparingByValue())
    .map(p -> Pair.of(p.getKey(), p.getValue()))
    .orElse(Pair.of(Character.MIN_VALUE, -1L));
}

```
To start, this solution collects distinct characters as keys in Map, along with their number of occurrences as values. Furthermore, it uses the Java 8 Map.Entry.comparingByValue() and max() terminal operations to determine the entry in the map with the highest value (highest number of occurrences). Since max() is a terminal operation, the solution may return Optional<Entry<Character, Long>>, but this solution adds an extra step and maps this entry to Pair<Character, Long>.
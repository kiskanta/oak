A solution that relies on JDK support can exploit the String.replaceAll() method. This method replaces each substring (in our case, each character) of the given string that matches the given regular expression (in our case, the regular expression is the character itself) with the given replacement (in our case, the replacement is an empty string, ""):

```java
public static String removeCharacter(String str, char ch) {

  return str.replaceAll(Pattern.quote(String.valueOf(ch)), "");
}
```
Notice that the regular expression is wrapped in the Pattern.quote() method. This is needed to escape special characters such as <, (, [, {, \, ^, -, =, $, !, |, ], }, ), ?, *, +, ., and >. Mainly, this method returns a literal pattern string for the specified string.

Now, let's take a look at a solution that avoids regular expressions. This time, the solution relies on StringBuilder. Basically, the solution loops the characters of the given string and compares each character with the character to remove. Each time the current character is different from the character to remove, the current character is appended in StringBuilder:
```java
public static String removeCharacter(String str, char ch) {

  StringBuilder sb = new StringBuilder();
  char[] chArray = str.toCharArray();

  for (char c : chArray) {
    if (c != ch) {
      sb.append(c);
    }
  }

  return sb.toString();
}
```
Finally, let's focus on a Java 8 functional style approach. This is a four-step approach:

Convert the string into IntStream via the String.chars() method
Filter IntStream to eliminate duplicates
Map the resulted IntStream to Stream<String>
Join the strings from this stream and collect them as a single string
The code for this solution can be written as follows:

```java
public static String removeCharacter(String str, char ch) {

  return str.chars()
    .filter(c -> c != ch)
    .mapToObj(c -> String.valueOf((char) c))
    .collect(Collectors.joining());
}
```
Alternatively, if we want to remove a Unicode surrogate pair, then we can rely on codePointAt() and codePoints(), as shown in the following implementation:

```java
public static String removeCharacter(String str, String ch) {
 
   int codePoint = ch.codePointAt(0);

   return str.codePoints()
     .filter(c -> c != codePoint)
     .mapToObj(c -> String.valueOf(Character.toChars(c)))
     .collect(Collectors.joining());
 }
```
For third-party library support, please consider Apache Commons Lang, StringUtils.remove().
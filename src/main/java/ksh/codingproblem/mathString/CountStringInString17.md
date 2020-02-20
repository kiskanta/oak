17. Counting substring occurrences in a string
Counting the number of occurrences of a string in another string is a problem that can have at least two interpretations:

11 in 111 occurs 1 time.

11 in 111 occurs 2 times.

In the first case (11 in 111 occurs 1 time), the solution can rely on the String.indexOf() method. One of the flavors of this method allows us to obtain the index within this string of the first occurrence of the specified substring, starting at the specified index (or -1, if there is no such occurrence). Based on this method, the solution can simply traverse the given string and count the given substring occurrences. The traversal starts from position 0 and continues until the substring is not found:
```java
public static int countStringInString(String string, String toFind) {

  int position = 0;
  int count = 0;
  int n = toFind.length();

  while ((position = string.indexOf(toFind, position)) != -1) {
    position = position + n;
    count++;
  }

  return count;
}
```
Alternatively, the solution can use the String.split() method. Basically, the solution can split the given string using the given substring as a delimiter. The length of the resulting String[] array should be equal to the number of expected occurrences:

```java
public static int countStringInString(String string, String toFind) {

  int result = string.split(Pattern.quote(toFind), -1).length - 1;

  return result < 0 ? 0 : result;
}
```
In the second case (11 in 111 occurs 2 times), the solution can rely on the Pattern and Matcher classes in a simple implementation, as follows:

```java
public static int countStringInString(String string, String toFind) {

  Pattern pattern = Pattern.compile(Pattern.quote(toFind));
  Matcher matcher = pattern.matcher(string);

  int position = 0;
  int count = 0;

  while (matcher.find(position)) {

    position = matcher.start() + 1;
    count++;
  }

  return count;
}
```

[Example](https://www.javacodeexamples.com/java-count-occurrences-of-substring-in-string-example/724)
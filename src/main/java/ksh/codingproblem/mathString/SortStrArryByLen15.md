15. Sorting an array of strings by length
The first thing that comes to mind when sorting is the use of a comparator.

In this case, the solution should compare lengths of strings, and so the integers are returned by calling String.length() for each string in the given array. So, if the integers are sorted (ascending or descending), then the strings will be sorted.

The Java Arrays class already provides a sort() method that takes the array to sort and a comparator. In this case, Comparator<String> should do the job.

<p>Before Java 7, code that implemented a comparator relied on the compareTo() method. Common usage of this method was to compute a difference of the x1-x2 type, but this computation may lead to overflows. This makes compareTo() rather tedious. Starting with Java 7, Integer.compare() is the way to go (no overflow risks).<p>
The following is a method that sorts the given array by relying on the Arrays.sort() method:

```java
public static void sortArrayByLength(String[] strs, Sort direction) {
  if (direction.equals(Sort.ASC)) {
    Arrays.sort(strs, (String s1, String s2) 
      -> Integer.compare(s1.length(), s2.length()));
  } else {
    Arrays.sort(strs, (String s1, String s2) 
      -> (-1) * Integer.compare(s1.length(), s2.length()));
  }
}
```

Each wrapper of a primitive numeric type has a compare() method.
Starting with Java 8, the Comparator interface was enriched with a significant number of useful methods. One of these methods is comparingInt(), which takes a function that extracts an int sort key from the generic type and returns a Comparator<T> value that compares it with that sort key. Another useful method is reversed(), which reverses the current Comparator value.

Based on these two methods, we can empower Arrays.sort() as follows:

```java
public static void sortArrayByLength(String[] strs, Sort direction) {
  if (direction.equals(Sort.ASC)) {
    Arrays.sort(strs, Comparator.comparingInt(String::length));
  } else {
    Arrays.sort(strs, 
      Comparator.comparingInt(String::length).reversed());
  }
}
```
Comparators can be chained with the thenComparing() method.
The solutions we've presented here return void, which means that they sort the given array. To return a new sorted array and not alter the given array, we can use Java 8 functional style, as shown in the following snippet of code: 

```java
public static String[] sortArrayByLength(String[] strs, 
    Sort direction) {

  if (direction.equals(Sort.ASC)) {
    return Arrays.stream(strs)
      .sorted(Comparator.comparingInt(String::length))
      .toArray(String[]::new);
  } else {
    return Arrays.stream(strs)
      .sorted(Comparator.comparingInt(String::length).reversed())
      .toArray(String[]::new);
  }
}
```
So, the code creates a stream from the given array, sorts it via the sorted() stateful intermediate operation, and collects the result in another array.
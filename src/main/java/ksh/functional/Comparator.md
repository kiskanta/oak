


[Comparator(I)](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Comparator.html) is used to  order the objects of user-defined classes. A comparator object is capable of comparing two object classes.  

```java
public int compare​(T o1, T o2)
```

#### Colleactions.sort()
```java
public static <T extends Comparable<? super T>> void sort​(List<T> list)
public static <T> void sort​(List<T> list, Comparator<? super T> c)
```

Internally Sort() will call compare() of the class it is sorting. To compare two elements. It asks like  
-1 -  
0  - 
1  - 

### since jdk 8

```java
default Comparator<T> reversed()
static <T extends Comparable<? super T>> Comparator<T> reverseOrder()
static <T extends Comparable<? super T>> Comparator<T> naturalOrder()
```

```java
static <T,​U extends Comparable<? super U>> Comparator<T> comparing​(Function<? super T,​? extends U> keyExtractor)

static <T,​U> Comparator<T> comparing​(Function<? super T,​? extends U> keyExtractor, Comparator<? super U> keyComparator)

static <T> Comparator<T> comparingInt​(ToIntFunction<? super T> keyExtractor)
static <T> Comparator<T> comparingLong​(ToLongFunction<? super T> keyExtractor)
static <T> Comparator<T> comparingDouble​(ToDoubleFunction<? super T> keyExtractor)
```

```java
default Comparator<T> thenComparing​(Comparator<? super T> other)
default <U> Comparator<T> thenComparing​(Function<? super T,​? extends U> keyExtractor, Comparator<? super U> keyComparator)
default <U extends Comparable<? super U>> Comparator<T> thenComparing​(Function<? super T,​? extends U> keyExtractor)

default Comparator<T> thenComparingInt​(ToIntFunction<? super T> keyExtractor)
default Comparator<T> thenComparingLong​(ToLongFunction<? super T> keyExtractor)
default Comparator<T> thenComparingDouble​(ToDoubleFunction<? super T> keyExtractor)

```


```java
static <T> Comparator<T> nullsFirst​(Comparator<? super T> comparator)
static <T> Comparator<T> nullsLast​(Comparator<? super T> comparator)

```


## Sorting Map directly with `Comparators`.[Comparator(I)](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Map.Entry.html)


```java
static <K extends Comparable<? super K>,​V> Comparator<Map.Entry<K,​V>> comparingByKey()
static <K,​V> Comparator<Map.Entry<K,​V>> comparingByKey​(Comparator<? super K> cmp)
```

```java
static <K,​V extends Comparable<? super V>> Comparator<Map.Entry<K,​V>> comparingByValue()
static <K,​V> Comparator<Map.Entry<K,​V>> comparingByValue​(Comparator<? super V> cmp)
```



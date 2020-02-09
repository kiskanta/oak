
Stream.collect(), [Collector(I)](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/stream/Collector.html) and [Collectors(C)](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/stream/Collectors.html) 

Stream.collect() - is a terminal operation in Stream. It is a special case of reduction operation called mutable reduction operation. Because it returns mutable result container such as List, Set and Map according to supplied Collector.

`java.util.stream.Collectors (C)` contains static factory methods which perform some common operations such as accumulating elements into collection, finding min, max, average,sum of elements etc...   
	All the methods return Collector type. which will supplied to collect() as argument. 
DoubleSummaryStatistics


```java

```

```java
public static <T> Collector<T,​?,​Optional<T>> maxBy​(Comparator<? super T> comparator)
public static <T> Collector<T,​?,​Optional<T>> minBy​(Comparator<? super T> comparator)
```
returns collector that collects largest element in a stream according to supplied Comparator.
returns collector that collects smallest element in a stream according to supplied Comparator.

```java
public static <T> Collector<T,​?,​Integer> summingInt​(ToIntFunction<? super T> mapper)
public static <T> Collector<T,​?,​Long> summingLong​(ToLongFunction<? super T> mapper)
public static <T> Collector<T,​?,​Double> summingDouble​(ToDoubleFunction<? super T> mapper)
```
Returns a collector which collects sum of all input elements. 

```java
public static <T> Collector<T,​?,​Double> averagingInt​(ToIntFunction<? super T> mapper)
public static <T> Collector<T,​?,​Double> averagingLong​(ToLongFunction<? super T> mapper)
public static <T> Collector<T,​?,​Double> averagingDouble​(ToDoubleFunction<? super T> mapper)
```
Returns a collector which collects average of input elements.

```
public static <T> Collector<T,​?,​IntSummaryStatistics> summarizingInt​(ToIntFunction<? super T> mapper)
public static <T> Collector<T,​?,​LongSummaryStatistics> summarizingLong​(ToLongFunction<? super T> mapper)
public static <T> Collector<T,​?,​DoubleSummaryStatistics> summarizingDouble​(ToDoubleFunction<? super T> mapper)
```


```java
public static <T,​K> Collector<T,​?,​Map<K,​List<T>>> groupingBy​(Function<? super T,​? extends K> classifier)
public static <T,​K,​A,​D> Collector<T,​?,​Map<K,​D>> groupingBy​(Function<? super T,​? extends K> classifier, Collector<? super T,​A,​D> downstream)
public static <T,​K,​D,​A,​M extends Map<K,​D>> Collector<T,​?,​M> groupingBy​(Function<? super T,​? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,​A,​D> downstream)
```


```java
public static <T> Collector<T,​?,​Map<Boolean,​List<T>>> partitioningBy​(Predicate<? super T> predicate)
public static <T,​D,​A> Collector<T,​?,​Map<Boolean,​D>> partitioningBy​(Predicate<? super T> predicate, Collector<? super T,​A,​D> downstream)
```



```java
public static <T,​A,​R,​RR> Collector<T,​A,​RR> collectingAndThen​(Collector<T,​A,​R> downstream, Function<R,​RR> finisher)
```

### Since Jdk 9.
```java
public static <T,​U,​A,​R> Collector<T,​?,​R> flatMapping​(Function<? super T,​? extends Stream<? extends U>> mapper, Collector<? super U,​A,​R> downstream)

public static <T,​A,​R> Collector<T,​?,​R> filtering​(Predicate<? super T> predicate, Collector<? super T,​A,​R> downstream)
```

### Since Jdk 10.
```java
public static <T> Collector<T,​?,​List<T>> toUnmodifiableList()
public static <T> Collector<T,​?,​Set<T>> toUnmodifiableSet()
public static <T,​K,​U> Collector<T,​?,​Map<K,​U>> toUnmodifiableMap​(Function<? super T,​? extends K> keyMapper, Function<? super T,​? extends U> valueMapper)
public static <T,​K,​U> Collector<T,​?,​Map<K,​U>> toUnmodifiableMap​(Function<? super T,​? extends K> keyMapper, Function<? super T,​? extends U> valueMapper, BinaryOperator<U> mergeFunction)
```

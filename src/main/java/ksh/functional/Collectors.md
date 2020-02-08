`
Stream.collect()
Collector(I)
Collectors(C)
`
Stream.collect() - is a terminal operation in Stream. It is a special case of reduction operation called mutable reduction operation. Because it returns mutable result container such as List, Set and Map according to supplied Collector.



DoubleSummaryStatistics

`
public static <T> Collector<T,​?,​Optional<T>> maxBy​(Comparator<? super T> comparator)
`

`
public static <T> Collector<T,​?,​Optional<T>> minBy​(Comparator<? super T> comparator)
`

`
public static <T> Collector<T,​?,​Integer> summingInt​(ToIntFunction<? super T> mapper)
public static <T> Collector<T,​?,​Long> summingLong​(ToLongFunction<? super T> mapper)
public static <T> Collector<T,​?,​Double> summingDouble​(ToDoubleFunction<? super T> mapper)
`

`
public static <T> Collector<T,​?,​Double> averagingInt​(ToIntFunction<? super T> mapper)
public static <T> Collector<T,​?,​Double> averagingLong​(ToLongFunction<? super T> mapper)
public static <T> Collector<T,​?,​Double> averagingDouble​(ToDoubleFunction<? super T> mapper)
`

`
public static <T> Collector<T,​?,​IntSummaryStatistics> summarizingInt​(ToIntFunction<? super T> mapper)
public static <T> Collector<T,​?,​LongSummaryStatistics> summarizingLong​(ToLongFunction<? super T> mapper)
public static <T> Collector<T,​?,​DoubleSummaryStatistics> summarizingDouble​(ToDoubleFunction<? super T> mapper)
`


`
public static <T,​K> Collector<T,​?,​Map<K,​List<T>>> groupingBy​(Function<? super T,​? extends K> classifier)
public static <T,​K,​A,​D> Collector<T,​?,​Map<K,​D>> groupingBy​(Function<? super T,​? extends K> classifier, Collector<? super T,​A,​D> downstream)
public static <T,​K,​D,​A,​M extends Map<K,​D>> Collector<T,​?,​M> groupingBy​(Function<? super T,​? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,​A,​D> downstream)
`


`
public static <T> Collector<T,​?,​Map<Boolean,​List<T>>> partitioningBy​(Predicate<? super T> predicate)
public static <T,​D,​A> Collector<T,​?,​Map<Boolean,​D>> partitioningBy​(Predicate<? super T> predicate, Collector<? super T,​A,​D> downstream)
`



`
public static <T,​A,​R,​RR> Collector<T,​A,​RR> collectingAndThen​(Collector<T,​A,​R> downstream, Function<R,​RR> finisher)
`

### Since Jdk 9.
`
public static <T,​U,​A,​R> Collector<T,​?,​R> flatMapping​(Function<? super T,​? extends Stream<? extends U>> mapper, Collector<? super U,​A,​R> downstream)

public static <T,​A,​R> Collector<T,​?,​R> filtering​(Predicate<? super T> predicate, Collector<? super T,​A,​R> downstream)
`

### Since Jdk 10.
`
public static <T> Collector<T,​?,​List<T>> toUnmodifiableList()
public static <T> Collector<T,​?,​Set<T>> toUnmodifiableSet()
public static <T,​K,​U> Collector<T,​?,​Map<K,​U>> toUnmodifiableMap​(Function<? super T,​? extends K> keyMapper, Function<? super T,​? extends U> valueMapper)
public static <T,​K,​U> Collector<T,​?,​Map<K,​U>> toUnmodifiableMap​(Function<? super T,​? extends K> keyMapper, Function<? super T,​? extends U> valueMapper, BinaryOperator<U> mergeFunction)
`

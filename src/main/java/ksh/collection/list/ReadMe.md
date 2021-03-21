# [java.util.List](https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/List.html)

### About List
- List super interfaces are [java.util.Collection](https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/Collection.html) and [java.lang.Iterable](https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/Iterable.html)
- If we want to represent group of individual Objects where Insertion Order is preserved and duplicates are allowed.

<details><summary>ArrayList [since Jdk 1.2]</summary>

```java
 public class ArrayList<E> extends AbstractList<E>
implements List<E>, RandomAccess, Cloneable, Serializable{}
```

- The Underlying Data Structure for ArrayList is Resizeable Array or Growable Array.

- Insertion Object is Preserved and Duplicate Object preserved.

- Heterogeneous objects are allowed. 

```text`
  ... ArrayList();
```

- Creates an Empty ArrayList Object with inital capacity 10. Load factor is current capacity * 3/2 +1. 

</details>

<details><summary>LinkedList [since Jdk 1.2] </summary>

```java
public class LinkedList<E>
extends AbstractSequentialList<E>
implements List<E>, Deque<E>, Cloneable, Serializable{}
```

- <a href="https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/LinkedList.html">LinkedList</a> underlying Data structure is Double Linked List.

- Insertion Order is preserved. Duplicate Objects and null insertion are allowed.

- Heterogeneous objects are allowed.

- Best suitable if our frequent operation is **Insertion or Deletion in the middle**. Worrest choice if our frequest operation is retrival.

</details>

<details><summary>Vector [since Jdk 1.0] </summary>

-   In <a href="https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/Vector.html">Vector</a> every method is synchronized. 

-   At any point of time only one Thread is allowed to operate on Vector object at a time. Hence Vector is Thread Safe.

</details>

<details><summary>Deque [since Jdk 1.6] </summary>

-   In [Deque](https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/Deque.html)

-   At any point of time only one Thread is allowed to operate on Vector object at a time. Hence Vector is Thread Safe.

</details>
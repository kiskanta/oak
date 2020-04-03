## [java.util.concurrent - JDK1.5](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/concurrent/package-summary.html)


	 Defines the core features that support alternatives to the built-in approaches to synchronization and interthread communication.
	  synchronizers
	  Executors
	  Concurrent Collections
	  The Fork/Join Framework

Semaphore 	- Implements the classic Seamaphore
CountDownLatch 	- Waits until a specified number of events have occurred.
CyclicBarrier	- Enables a group of threads to wait at a prededfined execution point.
Exchanger 	- Exchanges data between two threads.
Phaser		- Synchronizes threads that adance through multiple phases of an operation.

### [Semaphore](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/concurrent/Semaphore.html)
`Semaphore controls access to a shared resource by using permits in java`.

* If permits are grater than Zero(>0), then `semaphore allow access to shared resource`.
* If permits are zero or Lesser than Zero (<= 0), then `semaphore does not allow access to shared resources`.
 
`public void release()`

Release a permit and increases the number of available permits by 1. 



[java.util.concurrent.atomic](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/concurrent/atomic/package-summary.html)
java.util.concurrent.atomic facilitates the use of variables in a concurrent environment. It provides a means of efficiently updating the value of a variable without the use of locks. This is accomplished through the use of classes, such as AtomicInteger and AtomicLong, and methods, such as compareAndSet( ), decrementAndGet( ), and getAndSet( ). These methods execute as a single, non-interruptible operation.

[java.util.concurrent.locks](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/concurrent/locks/package-summary.html)
java.util.concurrent.locks provides an alternative to the use of synchronized methods. At the core of this alternative is the Lock interface, which defines the basic mechanism used to acquire and relinquish access to an object. The key methods are lock( ), tryLock( ), and unlock( ). The advantage to using these methods is greater control over synchronization.
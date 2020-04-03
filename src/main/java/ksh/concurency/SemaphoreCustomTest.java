package ksh.concurency;

public class SemaphoreCustomTest {
	public static void main(String[] args) {
		SemaphoreCustom sc = new SemaphoreCustom(2);

		IncrementThreadSc it1 = new IncrementThreadSc(sc);
		new Thread(it1, "IncrementThread").start();

		DecrementThreadSc dt = new DecrementThreadSc(sc);
		new Thread(dt, "DecrementThread").start();
	}
}

class SemaphoreCustom {
	private int permits;

	public SemaphoreCustom(int permits){
		this.permits = permits;
	}

	public synchronized void acquire() throws InterruptedException {
		if (permits > 0) {
			permits++;
		} else {// permit is not available wait, when thread is notified it decrement the
				// permit.
			this.wait();
			permits--;
		}
	}

	public synchronized void release() {
		permits++;
		if (permits > 0) {
			this.notify();
		}
	}
}
class IncrementThreadSc implements Runnable {

	private SemaphoreCustom semaphore;

	public IncrementThreadSc(SemaphoreCustom semaphore) {
		this.semaphore = semaphore;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is waiting for permit");

		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + "has got permit");
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " > " + SemaphoreDemo.SharedValue++);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + "has released permit");

		semaphore.release();
	}
}

class DecrementThreadSc implements Runnable {

	private SemaphoreCustom semaphore;

	public DecrementThreadSc(SemaphoreCustom semaphore) {
		this.semaphore = semaphore;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is waiting for permit");

		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + "has got permit");
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " > " + SemaphoreDemo.SharedValue--);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + "has released permit");
		semaphore.release();
	}
}

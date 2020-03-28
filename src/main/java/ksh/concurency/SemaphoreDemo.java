package ksh.concurency;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	static int SharedValue = 0;

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(0);

		IncrementThread it = new IncrementThread(semaphore);
		new Thread(it, "IncrementThread").start();
		
		DecrementThread dt = new DecrementThread(semaphore);
		new Thread(dt, "DecrementThread").start();
		
	}
}

class IncrementThread implements Runnable {

	Semaphore semaphore;

	public IncrementThread(Semaphore semaphore) {
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

class DecrementThread implements Runnable {

	Semaphore semaphore;

	public DecrementThread(Semaphore semaphore) {
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



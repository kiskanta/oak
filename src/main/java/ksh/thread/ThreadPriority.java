package ksh.thread;

import java.util.concurrent.TimeUnit;

public class ThreadPriority {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.setName("thread-1");
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		
		MyThread t2 = new MyThread();
		t2.setName("thread-2");
		t2.setPriority(Thread.MAX_PRIORITY);
		t2.start();
	}
	
	private static class MyThread extends Thread {
        private int c;

        @Override
        public void run () {
            String threadName = Thread.currentThread()
                                      .getName();

            System.out.println(threadName + " started.");
            for (int i = 0; i < 1000; i++) {
                c++;
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " ended.");
        }
    }
}

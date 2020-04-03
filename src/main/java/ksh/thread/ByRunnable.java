package ksh.thread;

public class ByRunnable {
	
	public static void main(String[] args) {
		ByExtendsRunnable byExtendRunnable = new ByExtendsRunnable();
		Thread thread = new Thread(byExtendRunnable);
		thread.start();
		
		ByExtendsRunnable byExtendRunnable2 = new ByExtendsRunnable();
		Thread thread2 = new Thread(byExtendRunnable2);
		thread2.start();
		
		System.out.println(Thread.currentThread().getName());
	}
	public static class ByExtendsRunnable implements Runnable{
		
		@Override
		public void run() {
			for(int i=0; i<5; i++) {
				System.out.println(Thread.currentThread().getName()+" : "+i);
				
				try {
					Thread.sleep(100);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

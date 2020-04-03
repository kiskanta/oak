package ksh.thread;

public class ByThread {
	public static void main(String[] args) {
		ByExtendThread exTh = new ByExtendThread();
		exTh.start();
		
		ByExtendThread exTh2 = new ByExtendThread();
		exTh2.start();
		
		System.out.println(Thread.currentThread().getName());
	}
	public static class ByExtendThread extends Thread{
		@Override
		public void run() {
			for(int i=0; i<5; i++) {
				System.out.println(Thread.currentThread().getName()+":"+i);
				
				try {
					Thread.sleep(100);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

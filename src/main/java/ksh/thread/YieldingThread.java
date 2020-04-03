package ksh.thread;

public class YieldingThread {
	
	public static void main(String[] args) {
		Task t1 = new Task(true);
		t1.setName("Teard1");
		t1.start();
		
		Task t2 = new Task(false);
		t2.setName("Teard2");
		t2.start();
	}
	static class Task extends Thread{
		private int c;
		private boolean isYield;
		Task(boolean isYield){
			this.isYield = isYield;
		}
		
		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName+" started. ");
			
			for(int i=0; i< 1000; i++) {
				c++;
				if(isYield) {
					Thread.yield();
				}
			}
			System.out.println(threadName+" ended. ");
		}
	}
}

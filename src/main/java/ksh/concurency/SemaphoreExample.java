package ksh.concurency;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;

public class SemaphoreExample {
	private static final int WORK_COUNT = 6;
	private static final int PERMITS = 1;
	
	public static void main(String[] args) throws InterruptedException {
		var workPanelList = initPanels();
		Collections.shuffle(workPanelList);
		Semaphore sempahore = new Semaphore(PERMITS);
		
		ExecutorService es = Executors.newFixedThreadPool(WORK_COUNT);
		while(true) {
			for(WorkPanel workPanel : workPanelList) {
				sempahore.acquire();
				es.execute(()->{
					workPanel.work();
					sempahore.release();
				});
			}
		}
	}
	
	private static List<WorkPanel> initPanels(){
		JFrame frame = new JFrame("Permits "+PERMITS);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250, 200);
		frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		var workPanelList = new ArrayList<WorkPanel>();
		for(int i=0; i< WORK_COUNT; i++) {
			WorkPanel wp = new WorkPanel();
			frame.add(wp);
			workPanelList.add(wp);
		}
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		return workPanelList;
	}
}

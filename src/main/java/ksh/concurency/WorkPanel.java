package ksh.concurency;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;

public class WorkPanel extends JComponent{
	private static final long serialVersionUID = 1L;
	private static final int PANEL_SIZE = 60;
	private int angle = 0;
	private boolean active;
	
	public WorkPanel() {
		setPreferredSize(new Dimension(PANEL_SIZE, PANEL_SIZE));
	}
	
	public void work() {
		active = true;
		int cycle = ThreadLocalRandom.current().nextInt(100, 200);
		for(int i=0; i< cycle; i++) {
			angle += 5;
			if(angle >= 360) {
				angle = 0;
			}
			repaint();
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			}catch (InterruptedException e) {
			}
		}
		active = false;
		repaint();
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(active? Color.BLUE: Color.LIGHT_GRAY);
		g.drawArc(0, 0, PANEL_SIZE, PANEL_SIZE, 0, 360);
		g.fillArc(0, 0, PANEL_SIZE, PANEL_SIZE, angle, 30);
	}
}

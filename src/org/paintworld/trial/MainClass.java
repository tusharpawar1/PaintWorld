package org.paintworld.trial;

import javax.swing.JFrame;



public class MainClass {
    

	public static void main(String[] args) throws InterruptedException {
		CanvasTrial ct;
		JFrame f = new JFrame("Weather Wizard");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ct = new CanvasTrial();
		ct.reColor(0x7BB070);
		ct.addLabel("Tushar");
		f.add(ct);
		f.setSize(800, 800);
		f.setVisible(true);
		Thread.sleep(1000);
		ct.reColor(0x989898);
		Thread.sleep(1000);
		ct.reColor(0xAA9898);
	}

}

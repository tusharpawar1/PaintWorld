package org.paintworld.trial;

import javax.swing.JFrame;

import org.paintworld.core.tools.Brush;
import org.paintworld.core.tools.brushes.RoundBrush;



public class MainClass {
    
	
	public static void main(String[] args) throws InterruptedException {
		CanvasTrial ct;
		JFrame f = new JFrame("PaintWorld");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ct = new CanvasTrial();
		ct.reColor(0x7BB070);
		ct.addLabel("Tushar");
		f.add(ct);
		f.setSize(800, 800);
		f.setVisible(true);
		
		Thread.sleep(1000);
		ct.reColor(0x982298);
		Brush br = new RoundBrush(43);
		br.setToolOn();
		ct.setTool(br);
	}

}

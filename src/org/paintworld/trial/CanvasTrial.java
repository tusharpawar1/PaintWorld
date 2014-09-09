package org.paintworld.trial;

import static java.awt.image.BufferedImage.TYPE_USHORT_555_RGB;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class CanvasTrial extends JPanel {
	static BufferedImage img = new BufferedImage(400, 400, TYPE_USHORT_555_RGB);
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);   
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, 
				0, 0, 400, 400, 
				0, 0, img.getWidth(null),img.getHeight(null), 
				null);
	}
	public void addLabel(String Label){
		img.getGraphics().drawString("This is my custom Panel!",10,20);
		repaint();
	}
	void reColor(int color) {
		for (int x = 0; x < 400; x++) {
			for (int y = 0; y < 400; y++) {
					img.setRGB(x , y, color);
			}
		}
		repaint();
	}
}

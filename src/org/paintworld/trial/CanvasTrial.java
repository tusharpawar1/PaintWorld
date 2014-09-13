package org.paintworld.trial;

import static java.awt.image.BufferedImage.TYPE_USHORT_555_RGB;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import org.paintworld.core.tools.Tool;

public class CanvasTrial extends JPanel implements MouseMotionListener {
	static BufferedImage img = new BufferedImage(400, 400, TYPE_USHORT_555_RGB);
	Tool activeBrush = null;
	public CanvasTrial() {
		addMouseMotionListener(this);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);   
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, 
				0, 0, 400, 400, 
				0, 0, img.getWidth(null),img.getHeight(null), 
				null);
	}
	public void addLabel(String Label){
		img.getGraphics().drawString(Label,10,20);
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
	
	void setTool(Tool tool){
		this.activeBrush = tool;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(activeBrush != null){
			activeBrush.Paint(img, e.getX(), e.getY());
			repaint();
			System.out.println("mouseDragged");

		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

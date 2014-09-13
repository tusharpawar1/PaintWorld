package org.paintworld.core.tools.brushes;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import org.paintworld.core.tools.Brush;

public class RoundBrush implements Brush{
	private int Size;
	private boolean Active =false;
	
	private int Radius;
	private int brushCenterX,brushCenterY;
	ArrayList<Point> brushPoints = new ArrayList<Point>();
	boolean[][] BrushDots ;
	public RoundBrush(int Size) {
		this.Size = Size;
		Radius = brushCenterX = brushCenterY = Size/2;
		BrushDots = new boolean [Size][Size];
		brushInit();
	}
	
	private void brushInit(){
		for(int i = 0 ; i < BrushDots.length; i ++){
			for (int j = 0; j < BrushDots[i].length; j++){
				boolean bln = isColor(i,j);
				if(bln) {
					BrushDots[i][j] = bln;
					brushPoints.add(new Point(i,j));
				}
				
			}
		}

	}
	private boolean isColor(int i , int j){
		double x2 = Math.pow((brushCenterX - i), 2);
		double y2 = Math.pow((brushCenterY - j), 2);
		double radius2 = Math.pow(Radius, 2) * 1.1;
		if((x2+y2) <= radius2){
			return true;
		}
		return false;
	}
	@Override
	
	public boolean setToolOn() {
		return Active=true;
	}

	@Override
	public boolean setToolOFF() {
		// TODO Auto-generated method stub
		return Active=false;
	}
	@Override
	public void Paint(BufferedImage tempImg, int mousePositionX, int mousePositionY){
		if(Active){
			
			int startCanvasPixelX = (mousePositionX- Radius) >= 0 ? (mousePositionX- Radius): 0;
			int startCanvasPixelY = (mousePositionY- Radius) >= 0 ? (mousePositionY- Radius): 0;
			int startBrushPixelX = (mousePositionX- Radius) >= 0 ? 0 : Radius-mousePositionX;
			int startBrushPixelY = (mousePositionY- Radius) >= 0 ? 0 : Radius-mousePositionY;
			
			int CanvasMaxX = tempImg.getWidth();
			int CanvasMaxY = tempImg.getHeight();
			int endCanvasPixelX = (mousePositionX+ Radius) > CanvasMaxX ? CanvasMaxX: mousePositionX+ Radius;
			int endCanvasPixelY = (mousePositionY+ Radius) > CanvasMaxY ? CanvasMaxY: mousePositionY+ Radius;
			
			int endBrushPixelX = (mousePositionX+ Radius) > CanvasMaxX ? Size - mousePositionX +Radius-CanvasMaxX : Size;
			int endBrushPixelY = (mousePositionY+ Radius) > CanvasMaxY ? Size - mousePositionY +Radius-CanvasMaxY : Size;
			
			for (int iCanvas = startCanvasPixelX, iBrush = startBrushPixelX; 
					iCanvas <= mousePositionX + Size
					 && iBrush < Size
					 && iCanvas < endCanvasPixelX;
					
					iCanvas++, iBrush++) {

				for (int jCanvas = startCanvasPixelY, jBrush = startBrushPixelY; 
						jCanvas <= mousePositionY + Size 
								&& jBrush < Size
								&& jCanvas < endCanvasPixelY;
						jCanvas++, jBrush++) {
					try{


						if(BrushDots[iBrush][jBrush]) 
							tempImg.setRGB(iCanvas, jCanvas, getPaint());

					}catch(Throwable th){
						System.out.println(th);
					}
				}
			}
		}
	}
	private int getPaint(){
		return 0x987878;
	}
	@Override
	public Point Position() {
		return new Point(0, 0);
	}

	@Override
	public void BrushMove(int X, int Y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void BrushShape() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor(int hexColor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createToolKey() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.Size;
	}

}

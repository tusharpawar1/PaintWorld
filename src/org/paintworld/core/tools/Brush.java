package org.paintworld.core.tools;

import java.awt.Point;
import java.awt.image.BufferedImage;


public interface Brush extends Tool{
   Point Position();
   void BrushMove(int X, int Y);
   void BrushShape();
   void setColor(int hexColor);
}

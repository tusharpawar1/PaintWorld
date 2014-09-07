package org.paintworld.core.interfaces;

public interface Brush {
   void Paint();
   void Position();
   void BrushMove(int X, int Y);
   void BrushShape();
   void setColor(int hexColor);
}

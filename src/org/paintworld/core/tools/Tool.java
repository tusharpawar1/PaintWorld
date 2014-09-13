package org.paintworld.core.tools;

import java.awt.image.BufferedImage;

public interface Tool {
	boolean setToolOn();

	boolean setToolOFF();

	void createToolKey();

	int getSize();

	void Paint(BufferedImage tempImg, int startX, int startY);

}

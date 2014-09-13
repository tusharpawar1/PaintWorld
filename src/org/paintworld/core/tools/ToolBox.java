package org.paintworld.core.tools;

import java.util.LinkedHashMap;

public class ToolBox {
	LinkedHashMap<ToolKey, Tool> lmapToolBox = new LinkedHashMap<ToolKey, Tool>();
	
	public ToolBox() {

	}
	
	private boolean loadToolBox(){
		
		lmapToolBox.put(null, null);
		return false;
	}
}

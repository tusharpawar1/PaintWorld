package org.paintworld.core.tools;

public final class ToolKey {
	private String ToolName;
	public String getToolName() {
		return ToolName;
	}

	public void setToolName(String toolName) {
		ToolName = toolName;
	}

	public String getShortcut() {
		return Shortcut;
	}

	public void setShortcut(String shortcut) {
		Shortcut = shortcut;
	}

	public String getToolDescription() {
		return ToolDescription;
	}

	public void setToolDescription(String toolDescription) {
		ToolDescription = toolDescription;
	}

	public int getToolNo() {
		return ToolNo;
	}

	public void setToolNo(int toolNo) {
		ToolNo = toolNo;
	}

	private String Shortcut;
	private String ToolDescription;
	private int ToolNo;
	
	public ToolKey(String ToolName, String Shortcut, String ToolDescription, int ToolNo ) {
		this.ToolName = ToolName;
		this.Shortcut = Shortcut;
		this.ToolDescription = ToolDescription;
		this.ToolNo = ToolNo;
	}
	
	@Override
	public int hashCode() {
		// This algo needs to be improved
		return ToolName.length() + 
				Shortcut.length() + 
				ToolDescription.length() +
				ToolNo;
	}
	
	@Override
	public boolean equals(Object obj) {

		if(obj instanceof ToolKey){
			ToolKey t = (ToolKey)obj;
			return ToolName.equalsIgnoreCase(t.ToolName);
			
		}
		return false;
	}
	
}

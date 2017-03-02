package org.asdmp.restday;

import java.io.Serializable;

public class MyProcessDecision implements Serializable{
	private static final long serialVersionUID = 3L;	

	public String action = "";
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}


	public boolean getDecide() {	
		if(action.equals("approve")){
			return true;
		}else{
			return false;
		}
	}

}

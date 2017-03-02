package org.asdmp.restday;
import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String kezhang;
	
	private String zhuren;

	public String getKezhang() {
		return kezhang;
	}

	public void setKezhang(String kezhang) {
		this.kezhang = kezhang;
	}

	public String getZhuren() {
		return zhuren;
	}

	public void setZhuren(String zhuren) {
		this.zhuren = zhuren;
	}
}

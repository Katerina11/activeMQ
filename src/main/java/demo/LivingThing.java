package demo;

import java.io.Serializable;

public class LivingThing implements Serializable {
	
	private static final long serialVersionUID = -1235595773104271526L;
	
	private Integer years;

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}
}

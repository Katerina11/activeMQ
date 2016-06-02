package demo;

import java.io.Serializable;

public class Person extends LivingThing implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5768896963543719921L;

	private String name;
	private String surname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}

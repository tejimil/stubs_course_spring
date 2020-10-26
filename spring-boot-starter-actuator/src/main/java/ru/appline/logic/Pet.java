package ru.appline.logic;

public class Pet {

	private String name;
	
	private String type;
	
	private int age;
	
	public Pet() {
		
	}

	public Pet(String name, String type, int age) {
		super();
		this.name = name;
		this.type = type;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

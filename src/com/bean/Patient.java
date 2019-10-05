package com.bean;

public class Patient {
	private int id;
	private String name;
	private String disease;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}

	public Patient(int id, String name, String disease) {
		super();
		this.id = id;
		this.name = name;
		this.disease = disease;
	}
}

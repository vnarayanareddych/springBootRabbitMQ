package com.springboot.model;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private int id;

	private String fathName;

	public Student(String name, int id, String fathName) {
		super();
		this.name = name;
		this.id = id;
		this.fathName = fathName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFathName() {
		return fathName;
	}

	public void setFathName(String fathName) {
		this.fathName = fathName;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", fathName=" + fathName + "]";
	}

}

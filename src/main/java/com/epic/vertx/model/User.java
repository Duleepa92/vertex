/**
 * 
 */
package com.epic.vertx.model;

import java.io.Serializable;


/**
 * @author duleepa_w
 *
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int salary;

	public User(String id2, String name, int salary) {
		super();
		this.id = id2;
		this.name = name;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


}

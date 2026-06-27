package com.demo.StudentManagementSystem.StudentManagementSystem_Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)                // auto generation of id
	private Integer id;   // wrapper type: null = new/unsaved entity (insert)

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String email;

	// JPA/Hibernate requires a no-arg constructor   the empty constructor. JPA requires this to build objects when reading from the database.
	public Student() {
		super();
	}

	public Student(Integer id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


//	The getters/setters getId, setId,
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
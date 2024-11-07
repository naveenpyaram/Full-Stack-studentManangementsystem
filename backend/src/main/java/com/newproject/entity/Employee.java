package com.newproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "first_name")
	private String firstnme;
	@Column(name = "last_name")
	private String lastlname;
	@Column(name = "email_id",nullable = false,unique = true)
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstnme() {
		return firstnme;
	}
	public void setFirstnme(String firstnme) {
		this.firstnme = firstnme;
	}
	public String getLastlname() {
		return lastlname;
	}
	public void setLastlname(String lastlname) {
		this.lastlname = lastlname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee() {
		super();
	}
	public Employee(Long id, String firstnme, String lastlname, String email) {
		super();
		this.id = id;
		this.firstnme = firstnme;
		this.lastlname = lastlname;
		this.email = email;
	}
	
	
	
	

}

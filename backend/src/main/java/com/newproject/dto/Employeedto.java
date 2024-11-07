package com.newproject.dto;



public class Employeedto {
	
	private Long id;
	
	private String firstnme;

	private String lastlname;
	
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

	public Employeedto() {
		super();
	}

	public Employeedto(Long id, String firstnme, String lastlname, String email) {
		super();
		this.id = id;
		this.firstnme = firstnme;
		this.lastlname = lastlname;
		this.email = email;
	}
	

}

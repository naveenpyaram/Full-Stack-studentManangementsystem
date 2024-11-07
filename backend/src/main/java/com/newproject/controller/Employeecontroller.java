package com.newproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newproject.dto.Employeedto;
import com.newproject.entity.Employee;
import com.newproject.services.Employeeservice;

import lombok.AllArgsConstructor;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class Employeecontroller {
	@Autowired
	private Employeeservice employeeservice;
	//build add employee rest api
	@PostMapping
	public ResponseEntity<Employeedto> createEmployee(@RequestBody Employeedto employeedto){
		Employeedto savedemployee = employeeservice.createEmployee(employeedto);
		return new ResponseEntity<>(savedemployee,HttpStatus.CREATED);
	}
	//build getbyid employee rest api
	@GetMapping("{id}")
	public ResponseEntity<Employeedto> getEmployeebyId(@PathVariable("id") Long employeeId){
		Employeedto getbyid =	employeeservice.getEmployeebyId(employeeId);
		return ResponseEntity.ok(getbyid);
	}
	//build getallemployess rest api
	@GetMapping
	public ResponseEntity<List<Employeedto>> getallemployees(){
	List<Employeedto> allemployees =  employeeservice.getallemployees();
	return ResponseEntity.ok(allemployees);
	}
	//build updateemployee rest api
	@PutMapping("{id}")
	public ResponseEntity<Employeedto> updateemployee(@PathVariable("id") Long employeeId, @RequestBody
			Employeedto updatedemployee){
		Employeedto employee =  employeeservice.updateemployee(employeeId, updatedemployee);
		return ResponseEntity.ok(employee);
		
	}
	//build deleteemployee rest api
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteemployee(@PathVariable("id") Long employeeId){
		employeeservice.delteemployee(employeeId);
		return ResponseEntity.ok("employee deleted succesfully");
	}
	
	
}

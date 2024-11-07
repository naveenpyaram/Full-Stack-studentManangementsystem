package com.newproject.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.newproject.dto.Employeedto;
import com.newproject.entity.Employee;
import com.newproject.exceptions.ResourceNotFoundException;
import com.newproject.mapper.EmployeeMapper;
import com.newproject.repository.Employeerepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Employeeserviceimpl implements Employeeservice{

	@Autowired
	private Employeerepository employeerepository;
	@Override
	public Employeedto createEmployee(Employeedto employeedto) {
		// TODO Auto-generated method stub
		Employee employee = EmployeeMapper.mapToEmployee(employeedto);
		Employee savedemployee =  employeerepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedemployee);
	}
	@Override
	public Employeedto getEmployeebyId(Long employeeId) {
		// TODO Auto-generated method stub
	Employee employee = 	employeerepository.findById(employeeId).orElseThrow(()->
		new ResourceNotFoundException("employee is not found with given id" + employeeId));
		
	return EmployeeMapper.mapToEmployeeDto(employee);
	}
	@Override
	public List<Employeedto> getallemployees() {
		// TODO Auto-generated method stub
		List<Employee> employees =  employeerepository.findAll();
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}
	@Override
	public Employeedto updateemployee(Long employeeId, Employeedto updatedemployee) {
		// TODO Auto-generated method stub
		Employee employee = 	employeerepository.findById(employeeId).orElseThrow(()->
		new ResourceNotFoundException("employee is not found with given id" + employeeId));
		employee.setFirstnme(updatedemployee.getFirstnme());
		employee.setLastlname(updatedemployee.getLastlname());
		employee.setEmail(updatedemployee.getEmail());
		Employee updatedemployeeobj =  employeerepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedemployeeobj);
	}
	@Override
	public void delteemployee(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee = 	employeerepository.findById(employeeId).orElseThrow(()->
		new ResourceNotFoundException("employee is not found with given id" + employeeId));
		employeerepository.deleteById(employeeId);
		
	}
	
}

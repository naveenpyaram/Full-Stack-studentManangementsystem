package com.newproject.mapper;

import com.newproject.dto.Employeedto;
import com.newproject.entity.Employee;

public class EmployeeMapper {
	public static Employeedto mapToEmployeeDto(Employee employee) {
		return new Employeedto(
				employee.getId(),
				employee.getFirstnme(),
				employee.getLastlname(),
				employee.getEmail()
				);
				
	}
	public static Employee mapToEmployee(Employeedto employeedto) {
		return new Employee(
				employeedto.getId(),
				employeedto.getFirstnme(),
				employeedto.getLastlname(),
				employeedto.getEmail()
				);
				
	}

}

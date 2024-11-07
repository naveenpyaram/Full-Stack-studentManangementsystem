package com.newproject.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.newproject.dto.Employeedto;
import com.newproject.entity.Employee;

public interface Employeeservice {
	Employeedto createEmployee(Employeedto employeedto);
	Employeedto getEmployeebyId(Long employeeId);
	List<Employeedto> getallemployees();
	Employeedto updateemployee(Long employeeId,Employeedto updatedemployee);
	void delteemployee(Long employeeId);


}

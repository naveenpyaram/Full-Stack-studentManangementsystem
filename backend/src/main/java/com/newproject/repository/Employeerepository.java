package com.newproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newproject.entity.Employee;

public interface Employeerepository extends JpaRepository<Employee, Long> {

}

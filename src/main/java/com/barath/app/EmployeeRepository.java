package com.barath.app;

import org.springframework.data.orient.graph.repository.OrientGraphRepository;

import java.util.List;

public interface EmployeeRepository extends OrientGraphRepository<Employee> {

    List<Employee> findByEmployeeName(String employeeName);
}

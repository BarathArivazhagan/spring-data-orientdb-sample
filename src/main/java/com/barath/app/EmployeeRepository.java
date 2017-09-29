package com.barath.app;

import org.springframework.data.orient.graph.repository.OrientGraphRepository;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

import java.util.List;

public interface EmployeeRepository extends OrientObjectRepository<Employee> {

    List<Employee> findByEmployeeName(String employeeName);
}

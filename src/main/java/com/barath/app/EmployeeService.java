package com.barath.app;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    public Employee saveEmployee(Employee employee){

        employeeRepository.save(employee);

        return employee;
    }

    public List<Employee> saveEmployees(List<Employee> employees){

        employeeRepository.save(employees);

        return employees;
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findEmployee(String employeeId){
        return employeeRepository.findOne(employeeId);
    }


    public List<Employee> findEmployeeByName(String employeeName){
        return employeeRepository.findByEmployeeName(employeeName);
    }
}

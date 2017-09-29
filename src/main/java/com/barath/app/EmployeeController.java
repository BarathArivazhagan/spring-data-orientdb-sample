package com.barath.app;

import javafx.scene.media.Media;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private  EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Employee createEmployee(@RequestBody Employee employee){

        return employeeService.saveEmployee(employee);
    }

    @PostMapping(value = "/create/many",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Employee> createEmployees(@RequestBody List<Employee> employees){
        return employeeService.saveEmployees(employees);
    }

    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Employee findEmployee(@RequestParam String employeeId){
        return employeeService.findEmployee(employeeId);
    }

    @GetMapping(value = "/getByName",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Employee> findEmployeeByName(@RequestParam  String employeeName){
        return employeeService.findEmployeeByName(employeeName);
    }
}

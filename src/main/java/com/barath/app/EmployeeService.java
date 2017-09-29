package com.barath.app;

import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import org.springframework.data.orient.object.OrientObjectDatabaseFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private OrientObjectDatabaseFactory factory;


    public EmployeeService(EmployeeRepository employeeRepository,OrientObjectDatabaseFactory factory){
        this.employeeRepository=employeeRepository;
        this.factory=factory;
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

    @PostConstruct
    public void init(){

        OObjectDatabaseTx db = null;

        try {
            db = factory.openDatabase();
            db.getEntityManager().registerEntityClass(Employee.class);
        } finally {
            if (db != null) {
                db.close();
            }
        }
        Employee emp1=new Employee("10","BARATH",26,100000.00,1L);
        Employee emp2=new Employee("20","SENTHIL",36,500000.00,1L);
        Employee emp3=new Employee("30","SUDHI",23,60000.00,1L);
        Employee emp4=new Employee("40","VIKAS",24,500000.00,1L);
        Employee emp5=new Employee("50","VINEETH",26,200000.00,1L);
        this.saveEmployees(Arrays.asList(emp1,emp2,emp3,emp4,emp5));
    }
}

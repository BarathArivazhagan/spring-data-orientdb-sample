package com.barath.app;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Id;
import javax.persistence.Version;


@SpringBootApplication
public class OrientDBApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrientDBApplication.class, args);
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Data
@NoArgsConstructor
class Employee{

	@Id
	private String id;

	@Version
	@JsonIgnore
	private Long version;


	private String employeeId;

	private String employeeName;

	private Integer employeeAge;

	private Double employeeSalary;


	public Employee(String employeeId, String employeeName, int employeeAge, Double employeeSalary,Long version) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.employeeSalary = employeeSalary;
		this.version=version;
	}
}
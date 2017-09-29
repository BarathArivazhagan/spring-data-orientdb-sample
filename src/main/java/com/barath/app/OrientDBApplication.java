package com.barath.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;

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
class Employee{

	@Id
	private String employeeId;

	private String employeeName;

	private String employeeAge;

	private Double employeeSalary;


}
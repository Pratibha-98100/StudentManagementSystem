package com.demo.StudentManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// The repo/service/impl classes live in sibling packages (com.demo.*),
// not under com.demo.StudentManagementSystem, so widen the scan to com.demo.
@SpringBootApplication(scanBasePackages = "com.demo")
@EnableJpaRepositories(basePackages = "com.demo")
//@EntityScan(basePackages = "com.demo")
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.demo")
@EnableAutoConfiguration
@SpringBootApplication
public class SpringSecuritywithJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecuritywithJpaApplication.class, args);
		System.out.println("Server is Runing");
	}

}

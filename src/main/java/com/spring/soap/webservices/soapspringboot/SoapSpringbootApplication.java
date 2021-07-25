package com.spring.soap.webservices.soapspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = {"com.spring.soap.webservices.soapspringboot.soap"})
public class SoapSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapSpringbootApplication.class, args);
	}

}

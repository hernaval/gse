package com.javaweb.gestionSJ;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication

public class GestionS extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(GestionS.class, args);
		
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(GestionS.class);
	}
	

}

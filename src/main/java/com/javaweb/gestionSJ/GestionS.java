package com.javaweb.gestionSJ;

import com.javaweb.gestionSJ.dao.ResponsableRepository;
import com.javaweb.gestionSJ.entities.Responsable;
import com.javaweb.gestionSJ.security.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication

public class GestionS extends SpringBootServletInitializer{
	@Autowired
	ResponsableRepository respRepo;

	public static void main(String[] args) {

		SpringApplication.run(GestionS.class, args);
		
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		Hash hash = new Hash();
		Responsable resp = new Responsable();
		resp.setNom_resp("admin");
		resp.setPrenom_resp("admin");
		resp.setRole("ADMIN");
		resp.setUsername("admin");
		resp.setPassword(hash.getMd5("navalona"));
	


		respRepo.save(resp);
		// TODO Auto-generated method stub
		return builder.sources(GestionS.class);
	}
	

}

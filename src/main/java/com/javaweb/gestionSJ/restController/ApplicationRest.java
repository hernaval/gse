package com.javaweb.gestionSJ.restController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.gestionSJ.dao.ApplicationRepository;
import com.javaweb.gestionSJ.entities.Application;

@RestController
public class ApplicationRest {
	
	@Autowired
	private ApplicationRepository appRepo;
	
	@RequestMapping(value="/gse/applications/getAll",
			method=RequestMethod.GET,
			produces={MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArrayList<Application>> getApp(){
		ArrayList<Application> all = (ArrayList<Application>) appRepo.findAll();
		ResponseEntity<ArrayList<Application>> resp = new ResponseEntity<>(all,HttpStatus.OK);
		
		return resp;
	}
	
}

package com.javaweb.gestionSJ.restController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.gestionSJ.dao.ActiviteRepository;
import com.javaweb.gestionSJ.dao.DirectionRepository;
import com.javaweb.gestionSJ.entities.Activite;
import com.javaweb.gestionSJ.entities.Direction;

@RestController
public class DirectionRest {
	
	@Autowired
	private DirectionRepository dirRepo;
	@Autowired
	private ActiviteRepository activity;
	
	@RequestMapping(value="/gse/directions/getAll",
			method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE} )

	public ResponseEntity<ArrayList<Direction>> getDir(){
			ArrayList<Direction> all = (ArrayList<Direction>) dirRepo.findAll();
			ResponseEntity<ArrayList<Direction>> resp = new ResponseEntity<>(all,HttpStatus.OK);
			
			return resp;
	}
	
	//stat par direction
	@RequestMapping(value="/gse/activites/stat/direction",
			method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE} )

	public ResponseEntity<ArrayList<String>> statDir(){
			ArrayList<String> all = (ArrayList<String>) dirRepo.statByDir();
			ResponseEntity<ArrayList<String>> resp = new ResponseEntity<>(all,HttpStatus.OK);
			
			return resp;
	}
	
	

}

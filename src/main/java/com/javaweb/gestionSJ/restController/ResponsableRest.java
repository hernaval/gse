package com.javaweb.gestionSJ.restController;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.gestionSJ.dao.ResponsableRepository;
import com.javaweb.gestionSJ.entities.Responsable;

@RestController
public class ResponsableRest {
	@Autowired
	ResponsableRepository respRepo;
	
	
	@RequestMapping(value="/gse/activites/stat/responsable",
			method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE} )
	public ResponseEntity<ArrayList<String>> statDir(){
		ArrayList<String> all = (ArrayList<String>) respRepo.statByResp();
		ResponseEntity<ArrayList<String>> resp = new ResponseEntity<>(all,HttpStatus.OK);
		
		return resp;
	}

	@RequestMapping(value="/gse/responsables/getAll",
		method=RequestMethod.GET,
		produces = {MimeTypeUtils.APPLICATION_JSON_VALUE}
		)
	public ResponseEntity<ArrayList<Responsable>> getResp(){
		ArrayList<Responsable> all = (ArrayList<Responsable>) respRepo.findAll();
		ResponseEntity<ArrayList<Responsable>> resp = new ResponseEntity<>(all,HttpStatus.OK);
		
		return resp;
	}

	@RequestMapping(value="/gse/responsables/checkRef/{ref}",method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<Optional<Responsable>> check(@PathVariable("ref")String ref){
		Optional<Responsable> list =   respRepo.findById(ref);
		ResponseEntity<Optional<Responsable>> resp = new ResponseEntity<>(list,HttpStatus.OK);
		
		return resp;
	}

}

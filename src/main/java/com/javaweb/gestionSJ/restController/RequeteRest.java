package com.javaweb.gestionSJ.restController;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.gestionSJ.dao.RequeteRepository;
import com.javaweb.gestionSJ.entities.Requete;

@RestController
public class RequeteRest {
	
	@Autowired
	private RequeteRepository reqRepo;
	
	@RequestMapping(value="/gse/requetes/search/{mc}",
			method = RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArrayList<Requete>> search(@PathVariable("mc")String mc){
		ArrayList<Requete> all = (ArrayList<Requete>) reqRepo.searchObj("%"+mc+"%");
			ResponseEntity <ArrayList<Requete>> resp = new ResponseEntity<>(all,HttpStatus.OK);
			
			return resp;
	}


	@RequestMapping(value="/gse/requetes/parDate/{date1}/{date2}/{page}/{size}",
			method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE} )

	public ResponseEntity<Page<Requete>> result(
			@PathVariable("date1")String date1,
			@PathVariable("date2")String date2,
			@PathVariable("page")int p,
			@PathVariable("size")int s){
		
			Page<Requete> all =  reqRepo.findByIntervalDate(date1,date2,PageRequest.of(p,s));
			ResponseEntity <Page<Requete>> resp = new ResponseEntity<>(all,HttpStatus.OK);
			
			return resp;
	}


	@RequestMapping(value="/gse/requetes/checkRef/{ref}",method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<Optional<Requete>> check(@PathVariable("ref")String ref){
		Optional<Requete> list =   reqRepo.findById(ref);
		ResponseEntity<Optional<Requete>> resp = new ResponseEntity<>(list,HttpStatus.OK);
		
		return resp;
	}
	
}

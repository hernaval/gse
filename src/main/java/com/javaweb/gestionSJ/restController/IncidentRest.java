package com.javaweb.gestionSJ.restController;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.gestionSJ.dao.IncidentRepository;
import com.javaweb.gestionSJ.entities.Activite;
import com.javaweb.gestionSJ.entities.Incident;

@RestController
public class IncidentRest {
	
	@Autowired
	private IncidentRepository incRepo;
	
	@RequestMapping(value="/gse/incidents/stat",
			method=RequestMethod.GET,
			produces={MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArrayList<String>> statInc(){
		ArrayList<String> all = (ArrayList<String>) incRepo.statByInc();
		ResponseEntity<ArrayList<String>> resp = new ResponseEntity<>(all,HttpStatus.OK);
		
		return resp;
	}
	
	@RequestMapping(value="/gse/incidents/stat/dir/{per1}/{per2}",
			method=RequestMethod.GET,
			produces={MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArrayList<String>> statDirInc(
			@PathVariable("per1")String per1,
			@PathVariable("per2")String per2){
		ArrayList<String> all = (ArrayList<String>) incRepo.statIncPer(per1,per2);
		ResponseEntity<ArrayList<String>> resp = new ResponseEntity<>(all,HttpStatus.OK);
		
		return resp;
	}
	
	
	@RequestMapping(value="/gse/incidents/search/{mc}",
			method=RequestMethod.GET,
			produces={MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArrayList<Incident>> search(
			@PathVariable("mc")String mc){
		ArrayList<Incident> all = (ArrayList<Incident>) incRepo.searchCode("%"+mc+"%");
		ResponseEntity <ArrayList<Incident>> resp = new ResponseEntity<>(all,HttpStatus.OK);
		
		return resp;
	}
	
	@RequestMapping(value="/gse/incidents/parDate/{date1}/{date2}/{page}/{size}",
			method=RequestMethod.GET,
			produces={MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<Page<Incident>> dateFilterInc(
			@PathVariable("date1")String date1,
			@PathVariable("date2")String date2,
			@PathVariable("page")int p,
			@PathVariable("size")int s){
		Page<Incident> list =  incRepo.findByIntervalDate(date1,date2,PageRequest.of(p, s)); 
		ResponseEntity<Page<Incident>> resp = new ResponseEntity<>(list,HttpStatus.OK);
		
		return resp;
	}
	
	
	
	@RequestMapping(value="/gse/incidents/checkRef/{ref}",method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<Optional<Incident>> check(@PathVariable("ref")String ref){
		Optional<Incident> list =   incRepo.findById(ref);
		ResponseEntity<Optional<Incident>> resp = new ResponseEntity<>(list,HttpStatus.OK);
		
		return resp;
	}
	
	@RequestMapping(value="/gse/incidents/count",method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity <Long> countAct(){
		Long total =   incRepo.count();
		ResponseEntity<Long> resp = new ResponseEntity<>(total,HttpStatus.OK);
		
		return resp;
	}
	 
			
	
}

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

import com.javaweb.gestionSJ.dao.DimRepository;
import com.javaweb.gestionSJ.entities.Activite;
import com.javaweb.gestionSJ.entities.Dim;

@RestController
public class DimRest {
	
	@Autowired
	private DimRepository dimRepo;
	
	@RequestMapping(value="/gse/dims/count",method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity <Long> countAct(){
		Long total =   dimRepo.count();
		ResponseEntity<Long> resp = new ResponseEntity<>(total,HttpStatus.OK);
		
		return resp;
	}

	@RequestMapping(value="/gse/dims/search/{mc}",
			method=RequestMethod.GET,
			produces ={MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity <ArrayList<Dim>> search(@PathVariable("mc")String mc)
	{
		ArrayList <Dim> list = (ArrayList<Dim>) dimRepo.findByMc("%"+mc+"%");
		ResponseEntity <ArrayList<Dim>> resp = new ResponseEntity<>(list,HttpStatus.OK);

		return resp; 
	}
	@RequestMapping(value="/gse/dims/parDate/{date1}/{date2}/{page}/{size}")
	public ResponseEntity<Page<Dim>> filterDate(
			@PathVariable("date1")String date1,
			@PathVariable("date2")String date2,
			@PathVariable("page")int p,
			@PathVariable("size")int s){
		Page<Dim> list = dimRepo.findByInterval(date1,date2,PageRequest.of(p, s));
		ResponseEntity<Page<Dim>>resp = new ResponseEntity<>(list,HttpStatus.OK);
		
		return resp;
				
	}
	
	@RequestMapping(value="/gse/dims/checkRef/{ref}",method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<Optional<Dim>> check(@PathVariable("ref")String ref){
		Optional<Dim> list =   dimRepo.findById(ref);
		ResponseEntity<Optional<Dim>> resp = new ResponseEntity<>(list,HttpStatus.OK);
		
		return resp;
	}
	
	
	
	
}

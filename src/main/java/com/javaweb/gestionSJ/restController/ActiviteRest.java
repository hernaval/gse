package com.javaweb.gestionSJ.restController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.gestionSJ.dao.ActiviteRepository;
import com.javaweb.gestionSJ.dao.DirectionRepository;
import com.javaweb.gestionSJ.dao.ResponsableRepository;
import com.javaweb.gestionSJ.entities.Activite;
import com.javaweb.gestionSJ.entities.Direction;
import com.javaweb.gestionSJ.entities.Responsable;

@RestController
public class ActiviteRest {
	@Autowired
	private ActiviteRepository activity;
	@Autowired
	private DirectionRepository dirRepo;
	@Autowired
	private ResponsableRepository respRepo;
	
	
	
	
	@RequestMapping(value="/gse/activites/parDate/{date1}/{date2}/{page}/{size}",
			method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE} )

	public ResponseEntity<Page<Activite>> result(
			@PathVariable("date1")String date1,
			@PathVariable("date2")String date2,
			@PathVariable("page")int p,
			@PathVariable("size")int s){
		
			Page<Activite> all =  activity.findByIntervalDate(date1,date2,PageRequest.of(p,s));
			ResponseEntity <Page<Activite>> resp = new ResponseEntity<>(all,HttpStatus.OK);
			
			return resp;
	}
	
	@RequestMapping(value="/gse/activites/stat/periode/{week}")
	public ResponseEntity<ArrayList<String>> statPeriode(@PathVariable("week")int month){
		ArrayList<String> list = activity.statPeriode(month);
		ResponseEntity<ArrayList<String>> resp =new ResponseEntity<>(list,HttpStatus.OK);
		
		return resp;
	}

	@RequestMapping(value="/gse/activites/stat/dir/{per1}/{per2}",method=RequestMethod.GET,
		produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})

	public ResponseEntity <ArrayList<String>> statDirPer(
		@PathVariable("per1")String per1,
		@PathVariable("per2")String per2
	)
	{
		ArrayList<String> list = dirRepo.statActDirPer(per1,per2);
		ResponseEntity<ArrayList<String>> resp =new ResponseEntity<>(list,HttpStatus.OK);
		
		return resp;
	}


	@RequestMapping(value="/gse/activites/stat/resp/{per1}/{per2}",method=RequestMethod.GET,
		produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})

	public ResponseEntity <ArrayList<String>> statRespPer(
		@PathVariable("per1")String per1,
		@PathVariable("per2")String per2
	)
	{
		ArrayList<String> list = respRepo.statActRespPer(per1,per2);
		ResponseEntity<ArrayList<String>> resp =new ResponseEntity<>(list,HttpStatus.OK);
		
		return resp;
	}	
	
	@RequestMapping(value="/gse/activites/search/{mc}",
			method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE} )

	public ResponseEntity<ArrayList<Activite>> search(
			@PathVariable("mc")String mc){
		
			ArrayList<Activite> all = (ArrayList<Activite>) activity.searchObj("%"+mc+"%");
			ResponseEntity <ArrayList<Activite>> resp = new ResponseEntity<>(all,HttpStatus.OK);
			
			return resp;
	}
	
	@RequestMapping(value="/gse/activites/checkRef/{ref}",method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<Optional<Activite>> check(@PathVariable("ref")String ref){
		Optional<Activite> list =   activity.findById(ref);
		ResponseEntity<Optional<Activite>> resp = new ResponseEntity<>(list,HttpStatus.OK);
		
		return resp;
	}
	
	
	@RequestMapping(value="/gse/activites/count",method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity <Long> countAct(){
		Long total =   activity.count();
		ResponseEntity<Long> resp = new ResponseEntity<>(total,HttpStatus.OK);
		
		return resp;
	}
	
	
	
}

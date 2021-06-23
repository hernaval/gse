package com.javaweb.gestionSJ.restController;

import java.util.ArrayList;

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

import com.javaweb.gestionSJ.dao.DirectionRepository;
import com.javaweb.gestionSJ.dao.FaitMarquantRepository;
import com.javaweb.gestionSJ.dao.ResponsableRepository;
import com.javaweb.gestionSJ.entities.FaitMarquant;

@RestController
public class FaitMarquantRest {
	
	@Autowired
	private FaitMarquantRepository fmqRepo;
	@Autowired
	private ResponsableRepository respRepo;
	@Autowired
	private DirectionRepository dirRepo;
	
	@RequestMapping(value="/gse/faitmarquants/stat/periode/{week}")
	public ResponseEntity<ArrayList<String>> statPeriode(@PathVariable("week")int month){
		ArrayList<String> list = fmqRepo.statPeriode(month);
		ResponseEntity<ArrayList<String>> resp =new ResponseEntity<>(list,HttpStatus.OK);
		
		return resp;
	}
	
	@RequestMapping(value="/gse/faitmarquants/stat/resp/{date1}/{date2}")
	public ResponseEntity<ArrayList<String>> statRespPer(
			@PathVariable("date1")String date1,
			@PathVariable("date2")String date2){
		ArrayList<String> list = respRepo.statFmqResp(date1,date2);
		ResponseEntity<ArrayList<String>> resp =new ResponseEntity<>(list,HttpStatus.OK);
		
		return resp;
	}
	
	@RequestMapping(value="/gse/faitmarquants/search/{mc}",
			method=RequestMethod.GET,
			produces ={MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArrayList<FaitMarquant>> chercher(
			@PathVariable("mc")String mc){
		ArrayList<FaitMarquant> list = fmqRepo.findByMc("%"+mc+"%");
		ResponseEntity<ArrayList<FaitMarquant>> resp =new ResponseEntity<>(list,HttpStatus.OK);
		
		return resp;
	}
	
	@RequestMapping(value="/gse/faitmarquants/parDate/{date1}/{date2}/{page}/{size}",
			method=RequestMethod.GET,
			produces ={MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<Page<FaitMarquant>> dateFilter(
			@PathVariable("date1")String date1,
			@PathVariable("date2")String date2,
			@PathVariable("page")int p,
			@PathVariable("size")int s){
		Page<FaitMarquant> list = fmqRepo.findByIntervalDate(date1,date2,PageRequest.of(p,s));
		ResponseEntity<Page<FaitMarquant>> resp =new ResponseEntity<>(list,HttpStatus.OK);
		
		return resp;
	}
	
	
	@RequestMapping(value="/gse/faitmarquants/stat/dir/{date1}/{date2}")
	public ResponseEntity<ArrayList<String>> statDirPer(
			@PathVariable("date1")String date1,
			@PathVariable("date2")String date2){
		ArrayList<String> list = dirRepo.statFmqDir(date1,date2);
		ResponseEntity<ArrayList<String>> resp =new ResponseEntity<>(list,HttpStatus.OK);
		
		return resp;
	}
	
	
	
	
	
}

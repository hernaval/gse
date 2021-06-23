package com.javaweb.gestionSJ.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaweb.gestionSJ.dao.DirectionRepository;
import com.javaweb.gestionSJ.entities.Direction;

@Controller
public class DirectionController {
	
	@Autowired
	private DirectionRepository dirRep;
	
	@RequestMapping(value="/gse/directions")
	public String index(Model model,
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="size",defaultValue="3")int s){
		Page<Direction> list =  dirRep.findAll(PageRequest.of(p,s));
		int[] pages = new int[list.getTotalPages()];
		model.addAttribute("listDir", list);
		model.addAttribute("pages", pages);
		model.addAttribute("size",s);
		
		return "directions/directions";
	}
	
	@RequestMapping(value="/gse/directions/ajout",method=RequestMethod.POST)
	public String addDir(Model model, Direction dir){
		dirRep.save(dir);
		
		return "redirect:/gse/directions";
	}
}

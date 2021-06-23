package com.javaweb.gestionSJ.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaweb.gestionSJ.dao.ApplicationRepository;
import com.javaweb.gestionSJ.entities.Application;
import com.javaweb.gestionSJ.entities.Direction;




@Controller
public class ApplicationController {
	
	@Autowired
	private ApplicationRepository appRepo;


	
	@RequestMapping(value="/gse/applications")
	public String index(Model model,
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="size",defaultValue="3")int s){
		Page<Application> app = appRepo.findAll(PageRequest.of(p, s));
		int[] pages = new int[app.getTotalPages()];
		model.addAttribute("listApp", app);
		model.addAttribute("pages", pages);
		model.addAttribute("size",s);
		
		return "applications/applications";
	}
	
	@RequestMapping(value="/gse/applications/ajout")
	public String addApp(Model model, Application app,Direction dir){
		//appRepo.save(app);
		app.getDirection().add(dir);
		appRepo.save(app);
		
		return "redirect:/gse/applications";
	}
	
}

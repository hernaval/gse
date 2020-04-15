package com.javaweb.gestionSJ.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javaweb.gestionSJ.dao.ApplicationRepository;
import com.javaweb.gestionSJ.dao.IncidentRepository;
import com.javaweb.gestionSJ.entities.Application;
import com.javaweb.gestionSJ.entities.Incident;

@Controller
public class IncidentController {
	
	@Autowired
	private IncidentRepository incidents;
	@Autowired
	private ApplicationRepository appRepo;


	@RequestMapping("/gse/incidents")
	public String index(Model model,
			@RequestParam(name="page",defaultValue="1")int p,
			@RequestParam(name="size",defaultValue="3")int s){
		Page<Incident> list = incidents.findAll(PageRequest.of(p-1,s));
		int[] pages = new int[list.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size",s);
		model.addAttribute("listInc",list);
		return "incidents/incidents";
	}
	
	@RequestMapping(value="/gse/ajoutIncidents")
	public String formInc(){
		return "incidents/ajout";
	}
	
	@RequestMapping(value="/gse/incidents/ajout", method=RequestMethod.POST)
	public String addIncident(Model model,Incident inc,Application app,RedirectAttributes redir){
		
		incidents.save(inc);
		inc.getApplication().add(app); //reference d'une application à une incident
		incidents.save(inc);  //insertion dans la table assocation application_incident
		redir.addFlashAttribute("addSuccess", "ajout d'incident réussi");
		return "redirect:/gse/ajoutIncidents";
	}
	
	@RequestMapping(value="/gse/incidents/modification",method=RequestMethod.POST)
	public String edit(Model model,Incident inc){
		incidents.save(inc);
		model.addAttribute("modif", "updated");
		
		return "redirect:/gse/incidents";
	}
	
}

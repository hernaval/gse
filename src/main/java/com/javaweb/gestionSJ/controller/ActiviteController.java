package com.javaweb.gestionSJ.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javaweb.gestionSJ.dao.ActiviteRepository;
import com.javaweb.gestionSJ.dao.DirectionRepository;
import com.javaweb.gestionSJ.dao.ResponsableRepository;
import com.javaweb.gestionSJ.entities.Activite;
import com.javaweb.gestionSJ.entities.Direction;
import com.javaweb.gestionSJ.entities.Responsable;


@Controller
public class ActiviteController {
	
	public static String codeAct;
	
	
	@Autowired
	private ActiviteRepository activity;
	@Autowired
	private DirectionRepository directionRepo;
	@Autowired
	private ResponsableRepository respRepo;
	
	
	//navigation et liste
	@RequestMapping(value="/gse/activites")
	@Transactional
	public String activites(Model model,HttpServletRequest req,
			@RequestParam(name="page",defaultValue="1")int p,
			@RequestParam(name="size",defaultValue="3")int s){
		
		Principal principal = req.getUserPrincipal();
		String code_resp = principal.getName().toString();
		String user  = respRepo.getLogUser(code_resp);
		
		req.getSession().setAttribute("user",user);
		
		//get user login
		
		Page<Activite> list = activity.findAll(PageRequest.of(p-1 , s));
		//liste et pagination
		int[] pages = new int[list.getTotalPages()];
		model.addAttribute("listActivity", list);
		model.addAttribute("pages", pages);
		model.addAttribute("size",s);
		
		//liste dynamique des directions et responsables
		model.addAttribute("direction",listDirection());
		return "activites/activites";
	}
	
	//formulaire
	@RequestMapping(value="/gse/ajoutActivites")
	public String formActivite(){
		
		return "activites/ajout";
	}
	
	//ajout d'activite
	@RequestMapping(value="/gse/activites/ajout",method=RequestMethod.POST)
	public String addActivity(Model model, Activite act,
			HttpServletRequest req,
			RedirectAttributes redir)
	{
		String date = LocalDate.now().toString();
		Responsable resp = new Responsable();
		//information de la session activie
		Principal principal = req.getUserPrincipal();
		String code_resp = principal.getName().toString();
		
		resp.setCode_resp(code_resp);
		act.setDate_act(date);
		act.setEtat_act("ko");
		act.setResponsable(resp);
		act.setEditeur(resp); 
		
		//utilisation d'un methode de jpa pour ajouter les données
		activity.save(act);
		
		//redirection avec notification
		redir.addFlashAttribute("addSuccess","ajout activité réussi");
		
		return "redirect:/gse/ajoutActivites";
	}
	
	
	@RequestMapping(value="/gse/activites/modification",method=RequestMethod.POST)
	
	public String edit(Model model,
			HttpServletRequest req,
			Activite act,
			RedirectAttributes redir){
		Principal principal = req.getUserPrincipal();
		String code_resp = principal.getName().toString();
		Responsable resp = new Responsable();resp.setCode_resp(code_resp);
		
		act.setEditeur(resp);
		activity.save(act);
		 
		//ResponseEntity<void> response = new ResponseEntity<>(1,HttpStatus.OK);
		redir.addFlashAttribute("editSuccess");
		return "redirect:/gse/activites";
	}
	
	
	
	@RequestMapping(value="/gse/activites/req")	
	public String finish(Model model,
			@RequestParam("action")String action,
			@RequestParam("code_act")String code_act){
		
			model.addAttribute("codeAct",code_act);
		
		return "activites/finish";
	}
	
	
	
	public ArrayList<Direction> listDirection(){
		
		return (ArrayList<Direction>) directionRepo.findAll();
	}
	
	
	
	
}

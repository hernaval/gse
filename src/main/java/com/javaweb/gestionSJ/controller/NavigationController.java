package com.javaweb.gestionSJ.controller;

import java.security.Principal;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {
	
	
	@RequestMapping(value="/login")
	public String login(){
		return "responsables/login";
	}
	@RequestMapping(value="/")
	public String index(){
		return "redirect:/gse/activites";
	}
	
	
	@RequestMapping(value="/gse/activites/test")
	public String test(){
		return "gseboard";
	}
	
	
	@RequestMapping(value="/gse/parametres")
	public String setting(){
		return "settings/setting";
	}
	
	@RequestMapping(value="/dim")
	public String dim(){
		
		return "dimD";
	}
	
	
	
	
	//lien sur le gse
	@RequestMapping(value="/gse**")
	public String gse(Model model, HttpServletRequest req){
		Principal principal = req.getUserPrincipal();
		String code_resp = principal.getName().toString();
		req.getSession().setAttribute("user", code_resp);
		return "gseboard";
	}
	@RequestMapping(value="/gse/statistiques")
	public String stat(){
		return "statistiques/statistiques";
	}
	@RequestMapping(value="/gse/test")
	public String testt(Model model){
		model.addAttribute("test", "test");
		return "hello";
		
	}
}

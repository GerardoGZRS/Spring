package com.jery.contacto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jery.contacto.constant.ViewConstant;
import com.jery.contacto.model.UserCredential;

@Controller
public class LoginController {

	
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name="error",  required=false) String error, 
			@RequestParam(name="logout", required=false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ViewConstant.LOGIN;
	}
	
	@GetMapping({"/loginsuccess", "/"})
	public String loginCheck() {
		
			return "redirect:/contacts/showContacts";
		
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jery.contacto.controller;

import com.jery.contacto.constant.ViewConstant;
import com.jery.contacto.model.ContactModel;
import com.jery.contacto.service.ContactService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jery
 */
@Controller
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
@RequestMapping("/profesores")
public class ProfesorController {
    @Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
    @GetMapping("/showProfesores")
	public ModelAndView showProfesores() {
		ModelAndView modelAndView = new ModelAndView(ViewConstant.PROFESOR);
                modelAndView.addObject("contacts", contactService.listAllContact());
                

		return modelAndView;
	}
        
        @RequestMapping(value = "/addProfesores", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public  String addProfesor(@RequestBody ContactModel model, Model m) {

		if (null != contactService.addContact(model)) {
			m.addAttribute("result", 1);
                        
		} else {
			m.addAttribute("result", 0);
		}
            System.out.println("com.jery.contacto.controller.ProfesorController.addProfesor()");

	return "redirect:/profesores/showProfesores";
	}
        
        
        @GetMapping("/checkrest")
    public ResponseEntity<List<ContactModel>> checkRest(){
        List<ContactModel> cm = contactService.listAllContact();
        
        return  new ResponseEntity<List<ContactModel>>(cm, HttpStatus.OK);
    }
    
    @PostMapping(value = "/idContacto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactModel> id(){
        ContactModel cm = contactService.findContactByIdModel(30);
        
        return  new ResponseEntity<ContactModel>(cm, HttpStatus.OK);
    }
    
    
        
}

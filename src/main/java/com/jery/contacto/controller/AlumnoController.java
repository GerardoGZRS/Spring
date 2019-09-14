package com.jery.contacto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jery.contacto.constant.ViewConstant;
import com.jery.contacto.model.AlumnoModel;
import com.jery.contacto.service.AlumnoService;
import org.springframework.web.bind.annotation.RequestParam;

// TODO: Auto-generated Javadoc
/**
 * The Class AlumnoController.
 */
@Controller
@RequestMapping("/alumnos")
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
public class AlumnoController {

	
	/** The alumno service. */
	@Autowired
	@Qualifier("alumnoServiceImpl")
	private AlumnoService alumnoService;
	
	
	/**
	 * Redirect contact form.
	 *
     * @param id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/registraralumnosform")
	public String redirectAlumnoForm(@RequestParam(name = "id", required =false) int id, Model model) {
		AlumnoModel alumnoModel = new AlumnoModel();
                if (id != 0) {
                alumnoModel = alumnoService.findAlumnoByIdModel(id);
		}
		model.addAttribute("alumnoModel", alumnoModel);
		return ViewConstant.REGISTRAR_A_FORM;
	}
	
	/**
	 * Adds the contact.
	 *
	 * @param model the model
	 * @return the string
	 */
	@PostMapping("/addAlumno")
	public String addContact(@ModelAttribute(name = "alumnoModel") AlumnoModel model) {

		 alumnoService.addContact(model);
		
		
		return "redirect:/alumnos/showAlumnos";
	}
	
	/**
	 * Show contacts.
	 *
	 * @return the model and view
	 */
	@GetMapping("/showAlumnos")
	public ModelAndView showAlumnos() {
		ModelAndView modelAndView = new ModelAndView(ViewConstant.ALUMNO);
		
	
		modelAndView.addObject("alumnos", alumnoService.listAllAlumno());
		return modelAndView;
	}
	
	@GetMapping("/removedAlumno")
	public ModelAndView removedAlumno(@RequestParam(name = "id", required = true) int id) {
		alumnoService.removeContact(id);
		return showAlumnos();
	}

}

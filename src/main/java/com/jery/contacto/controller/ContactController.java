package com.jery.contacto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jery.contacto.constant.ViewConstant;
import com.jery.contacto.entity.Contact;
import com.jery.contacto.model.ContactModel;
import com.jery.contacto.service.ContactService;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactController.
 */
@Controller
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
@RequestMapping("/contacts")
public class ContactController {
Contact c = new Contact();
	/** The contact service. */
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;

	/**
	 * Cancel.
	 *
	 * @return the string
	 */
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contacts/showContacts";
	}
	

        @GetMapping("/contactform")
	public String modificarContact(@RequestParam(name = "id", required=false) int id, Model model) {
		ContactModel contactModel = new ContactModel();
                System.err.println("id "+ id);
                try{
                   if (id !=0) {
contactModel =	contactService.findContactByIdModel(id);
                       System.err.println("" + lista());    
		} 
                }catch(Exception e){
                    System.out.println("com.jery.contacto.controller.ContactController.redirectContactForm()" +e);
                }
		
		model.addAttribute("contactModel", contactModel);
return ViewConstant.CONTACT_FORM;
	}
	/**
	 * Adds the contact.
	 *
	 * @param model the model
	 * @param m the m
	 * @return the string
	 */
	@PostMapping("/addContact")
	public String addContact(@ModelAttribute(name = "contactModel") ContactModel model, Model m) {

		if (null != contactService.addContact(model)) {
			m.addAttribute("result", 1);
                        
		} else {
			m.addAttribute("result", 0);
		}

		return "redirect:/contacts/showContacts";
	}

	/**
	 * Show contacts.
	 *
	 * @return the model and view
	 */
	@GetMapping("/showContacts")
	public ModelAndView showContacts() {
		ModelAndView modelAndView = new ModelAndView(ViewConstant.CONTACTS);
		
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelAndView.addObject("username", user.getUsername());
		modelAndView.addObject("contacts", contactService.listAllContact());
		return modelAndView;
	}

	/**
	 * Removes the contact.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@GetMapping("/removedContact")
	public ModelAndView removeContact(@RequestParam(name = "id", required = true) int id) {
		contactService.removeContact(id);
		return showContacts();
	}
        
        private int lista(){
            return contactService.listAllContact().size();
        }

}

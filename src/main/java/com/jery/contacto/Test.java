/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jery.contacto;

import com.jery.contacto.model.ContactModel;
import com.jery.contacto.service.ContactService;
import com.jery.contacto.service.impl.ContactServiceImpl;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Jery
 */
@EnableJpaRepositories(basePackages = {"com.jery.contacto.repository"})
@EntityScan(value = {"com.jery.contacto.entity"})
@Controller
@SpringBootApplication
public class Test {
    /** The contact service. */
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService = new ContactServiceImpl();
    public static void main(String[] args) {
		SpringApplication.run(ContactoApplication.class, args);
                
	}
    
    private String lista(){
   List<ContactModel>  c=  new ArrayList<ContactModel>();    
contactService.listAllContact();
for(ContactModel cm : c){
       System.out.println("Nombre: " + cm.getFirstname());
   }
        return null;
    }
}

package com.jery.contacto.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.jery.contacto.component.ContactConvert;
import com.jery.contacto.entity.Contact;
import com.jery.contacto.model.ContactModel;
import com.jery.contacto.repository.ContactRepository;
import com.jery.contacto.service.ContactService;
import groovy.transform.ToString;

@EnableJpaRepositories(basePackages = { "com.jery.contacto.repository" })
@EntityScan(value = { "com.jery.contacto.entity" })
@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	@Qualifier("contactComponent")
	private ContactConvert contactConvert;

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConvert.convertConctactModelToContact(contactModel));
		return contactConvert.convertContactToContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContact() {
		List<Contact> listContact = contactRepository.findAll();
		List<ContactModel> listContactModel = new ArrayList<ContactModel>();
		for (Contact c : listContact) {
			listContactModel.add(contactConvert.convertContactToContactModel(c));
                        
		}
		return listContactModel;
	}

	@Override
	public Contact findContactById(int id) {
		return  contactRepository.findById(id);
	}

	
        @Override
	public ContactModel findContactByIdModel(int id) {
            System.err.println("id controller contacto" + id);
            Contact contact = contactRepository.findById(id);
            System.out.println(contact.toString());
	return	contactConvert.convertContactToContactModel(contact);
	}
	
	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
                 System.out.println(contact.toString());
		if (null != contact) {
			contactRepository.delete(contact);
		}

	}

    @Override
    public String select(int id) {
        Contact c = new Contact();
        try{
          c   = findContactById(id);
        }catch(Exception e){
            System.err.println("No he recibido el parametro");
        }
          
          return  c.toString();
    }

   

}

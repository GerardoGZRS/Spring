package com.jery.contacto.service;

import java.util.List;

import com.jery.contacto.entity.Contact;
import com.jery.contacto.model.ContactModel;

public interface ContactService {
	public abstract ContactModel addContact(ContactModel contactModel);
	public abstract List<ContactModel>  listAllContact();
	public abstract Contact findContactById(int id);
	public abstract void removeContact(int id);
	public abstract ContactModel findContactByIdModel(int id);
        public abstract String select(int id);
        
}

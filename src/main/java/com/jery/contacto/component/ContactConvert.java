package com.jery.contacto.component;

import org.springframework.stereotype.Component;

import com.jery.contacto.entity.Contact;
import com.jery.contacto.model.ContactModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactConvert.
 */
@Component("contactComponent")
public class ContactConvert {

	/**
	 * Convert conctact model to contact.
	 *
	 * @param contactModel the contact model
	 * @return the contact
	 */
	public Contact convertConctactModelToContact(ContactModel contactModel) {
		Contact contact = new Contact();
		contact.setFirstname(contactModel.getFirstname());
		contact.setLastname(contactModel.getLastname());
		contact.setCity(contactModel.getCity());
		contact.setTelephone(contactModel.getTelephone());
		contact.setId(contactModel.getId());
		return contact;
	}
	
	/**
	 * Convert contact to contact model.
	 *
	 * @param contact the contact
	 * @return the contact model
	 */
	public ContactModel convertContactToContactModel(Contact contact) {
		ContactModel contactModel = new ContactModel();
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setLastname(contact.getLastname());
		contactModel.setCity(contact.getCity());
		contactModel.setTelephone(contact.getTelephone());
		contactModel.setId(contact.getId());
		return contactModel;
	}
	
}

package com.psl.DBconnection;

import java.util.List;
import java.util.Set;

import com.psl.contact.Contact;

public class AddNewToExisting {
	
	//11.	Boolean addContacts(List<Contacts> existingContact,Set<Contact> newContacts)
	public boolean addContacts(List<Contact> existingContact, Set<Contact> newContacts)
	{
		for(Contact c: newContacts)
		{
			existingContact.add(c);
		}
		for(Contact c: existingContact)
		{
			System.out.println(c);
		}
		return true;
	}

}

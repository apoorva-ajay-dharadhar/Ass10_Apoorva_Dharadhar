package com.psl.DBconnection;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.psl.contact.Contact;

public class SortContactsByNames {

	public static void sortContactsByName(List<Contact> contacts)
	{
		Collections.sort(contacts, Contact.comparator1);
		for(Contact c: contacts)
		{
			System.out.println(c);
		}
	}
}

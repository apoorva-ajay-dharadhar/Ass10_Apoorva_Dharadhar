package com.psl.DBconnection;

import java.util.List;
import java.util.Scanner;

import com.psl.contact.Contact;

public class UpdateContact {
/*
 * addContactNumber(int contactId, String contactNo, List<contact> contacts)
Implement method to add provided contactNo to the existing list of contact numbers of the specified contact 
Id. Update the appropriate contact object.

 * */
	
	public void addContactNumber(int contactId, String contactNo, List<Contact> contacts)
	{
		for(Contact c: contacts)
		{
			int cId=c.getContactID();
			if(cId==contactId)
			{
				List<String> cn=c.getContactNumber();
				cn.add(contactNo);
				c.setContactNumber(cn);
			}
		}
		for(Contact c: contacts)
		{
			System.out.println(c);
		}
		System.out.println();
	}
	public void process()
	{
		
		//addContact(id,newNum);
	}
	
}

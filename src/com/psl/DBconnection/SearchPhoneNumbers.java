package com.psl.DBconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.psl.contact.Contact;

public class SearchPhoneNumbers {

//	4.	Search should be able to find the contacts based on the partial input
//	For example contact No is -8977448730
//		Then it should be able to find contacts based on any of the i/p provided as mentioned below:-
//	a)	74
//	b)	448
//	c)	8730
//	All contacts present these values should be added in searched list
//	List<Contact> SearchContactByNumber(String number, List<Contact> contact) throws ContactNotFoundException
	
	public static List<Contact> searchDB()
	{
		Connection cn=ConnectionUtil.getConnection();
		
		List<Contact> m=new ArrayList<Contact>();
		try {
			
			Statement st=cn.createStatement();
			
			String qry="select * from contact_tbl;";
			ResultSet rs=st.executeQuery(qry);
			
			while(rs.next())
			{
				Contact cont=new Contact();
				int contactId=rs.getInt(1);
				cont.setContactID(contactId);
				String name=rs.getString(2);
				cont.setContactName(name);
				String email=rs.getString(3);
				cont.setEmailAddress(email);
				String contactNums=rs.getString("contactList");
				List<String> conts=new ArrayList<String>();
				String n="";
				if(contactNums!=null)
				{
					String[] li=contactNums.split(",");
					for(String s: li)
					{
						conts.add(s);
						
						
					}
					cont.setContactNumber(conts);
				}
				else
				{
					n=null;
					conts.add(n);
					cont.setContactNumber(conts);
				}
				m.add(cont); 
				
//				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	public static List<Contact> searchContactByNumber(String number, List<Contact> contact)
	{
		List<Contact> searchList=new ArrayList<Contact>();
		Connection cn=ConnectionUtil.getConnection();
		
			//System.out.println("1");
			Statement st1;
			try {
				
				st1 = cn.createStatement();
				String qry="select * from contact_tbl where contactList like '%"+number+"%';";
				ResultSet rs=st1.executeQuery(qry);
				
				while(rs.next())
				{
				//	System.out.println("2");
					Contact cont=new Contact();
				int contactId=rs.getInt(1);
				cont.setContactID(contactId);
				String name=rs.getString(2);
				cont.setContactName(name);
				String email=rs.getString(3);
				cont.setEmailAddress(email);
				String contactNums=rs.getString("contactList");
				List<String> conts=new ArrayList<String>();
				String n="";
				if(contactNums!=null)
				{
					String[] li=contactNums.split(",");
					for(String s: li)
					{
						conts.add(s);
					}
					cont.setContactNumber(conts);
					//System.out.println(cont);
				}
				else
				{
					n=null;
					conts.add(n);
					cont.setContactNumber(conts);
				}
				searchList.add(cont);
				//System.out.println(cont);
				}//try	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			return searchList;
		}
	
	
	public static void main(String[] args)
	{
		SearchPhoneNumbers sp=new SearchPhoneNumbers();
		//sp.search();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the phone number to be search..");
		String number=sc.nextLine();
		List<Contact> list=searchDB();
		for(Contact c: list)
		{
			//System.out.println(c);
		}
		List<Contact> finalSearchList=searchContactByNumber(number, list);
		for(Contact c: finalSearchList)
		{
			System.out.println(c);
			
		}
		
	}

	
}

package com.psl.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.psl.contact.Contact;



public class AddContactToDB {

	Connection cn=ConnectionUtil.getConnection();
	
	public void insertContact(List<Contact> contactList)
	{
		PreparedStatement pstmt = null;
		int id=0;
		String name="";
		String email="";
		String val="";
		List<String> nums=new ArrayList<String>();
		for(Contact ct: contactList)
		{
			id=ct.getContactID();
			name=ct.getContactName();
			email=ct.getEmailAddress();
			nums=ct.getContactNumber();
			String[] list=new String[nums.size()];
		
			for(int j=0;j<nums.size();j++)
			{
				list[j]=nums.get(j);
				if(j<nums.size()-1)
				{
					val=val+list[j];
				}
				else
				{
					val=val+","+list[j];
				}
				
			}
		}
		//System.out.println(id+","+name+","+email+","+val+".");
		try
		{
			pstmt = cn.prepareStatement("insert into contact_tbl values(?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, val);
			pstmt.executeUpdate();
			//String qry="insert into contact_tbl values(101, 'Radha', 'rad@rediffmail.com', null);";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}
	
	
	
}

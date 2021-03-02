package com.psl.contact;

import java.util.ArrayList;
import java.util.List;

import com.psl.Exceptions.ContactNotFoundException;


public class trial {

	
	public List<Contact> searchContactByNumber(String number, List<Contact> contact) throws ContactNotFoundException
	{
		List<Contact> searchList=new ArrayList<Contact>();
		int flag=1;
		for(Contact c: contact)
		{
			flag=0;
			List<String> nums=new ArrayList<String>();
			List<String> number1=c.getContactNumber();
			int cnt=0;
			for(String str: number1)
			{
				for(int i=0;i<str.length();i++)
				{
					if(str.substring(i).contains(number))
					{
						cnt++;
						//searchList.add(c);
					}
				}
				if(cnt>1)
				{
					flag=1;
					break;
				}
				
				
			}
			if(flag==1)
			{
				
					searchList.add(c);
				
			}
			cnt=0;
//			if(number1.contains(nums))
//			{
//				searchList.add(c);
//			}
			
		}
		
		if(searchList.isEmpty())
		{
			throw new ContactNotFoundException("Could not find the record with this number");
//			for(Contact c: searchList)
//			{
//				System.out.println(c);
//			}
		}
	
		
		
		return searchList;
	}
	
	public static void main(String[] args) {
	//String number, List<Contact> contact
		
		String number="34";
		List<Contact> list=new ArrayList<Contact>();
		Contact c1=new Contact();
		c1.setContactID(1);
		c1.setContactName("ramesh");
		c1.setEmailAddress("ramesh@gmail.com");
		List<String> contactNum=new ArrayList<String>();
		contactNum.add("2345");
		contactNum.add("3456");
		c1.setContactNumber(contactNum);
		
		List<Contact> listC=new ArrayList<Contact>();
		listC.add(c1);
		Contact c2=new Contact();
		c2.setContactID(1);
		c2.setContactName("suresh");
		c2.setEmailAddress("suresh@gmail.com");
		List<String> contactNum1=new ArrayList<String>();
		contactNum1.add("3489");
		contactNum1.add("9034");
		c2.setContactNumber(contactNum1);
		
		listC.add(c2);
		
		trial t=new trial();
		try {
			List<Contact> l1=t.searchContactByNumber(number,listC);
			for(Contact c: l1)
			{
				System.out.println(c);
			}
		} catch (ContactNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	

}

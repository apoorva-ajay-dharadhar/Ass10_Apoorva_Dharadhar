package com.psl.contact;

import java.util.ArrayList;
import java.util.List;

public class trial {

	public static void main(String[] args) {
		List<String> number1=new ArrayList<String>();
		String number="12";
		number1.add("123344");
		number1.add("129876");
		for(String str: number1)
		{
			for(int i=0;i<str.length();i++)
			{
				if(str.substring(i).contains(number))
				{
					System.out.println("ahe");
				}
			}
			
		}
	}

}

package com.psl.contact;

import java.util.List;

public class Contact {

	private int contactID;
	public int getContactID() {
		return contactID;
	}
	public void setContactID(int contactID) {
		this.contactID = contactID;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public List<String> getContactNumber() {
		return contactNumber;
	}
	@Override
	public String toString() {
		return "Contact [contactID=" + contactID + ", contactName=" + contactName + ", emailAddress=" + emailAddress
				+ ", contactNumber=" + contactNumber + "]";
	}
	public void setContactNumber(List<String> contactNumber) {
		this.contactNumber = contactNumber;
	}
	private String contactName;
	private String emailAddress;
	private List<String> contactNumber;
	

	
	
}

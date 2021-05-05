package com.domloge.catholiconmsclublibrary;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.micronaut.core.annotation.Introspected;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Introspected
public class Contact {
	
	private String name;
	
	private String email;
	
	private ContactRole committeeRole;
	
	private List<PhoneNumber> contactNumbers;

	private String clubName;
	
	public Contact() {
	}

	public Contact(String name, String email, ContactRole committeeRole, List<PhoneNumber> contactNumbers, String clubName) {
		super();
		this.name = name;
		this.email = email;
		this.committeeRole = committeeRole;
		this.contactNumbers = contactNumbers;
		this.clubName = clubName;
	}

	public Contact(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public ContactRole getCommitteeRole() {
		return committeeRole;
	}

	public List<PhoneNumber> getContactNumbers() {
		return contactNumbers;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContactNumbers(List<PhoneNumber> contactNumbers) {
		this.contactNumbers = contactNumbers;
	}

	public String getClubName() {
		return clubName;
	}
	
}
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clubName == null) ? 0 : clubName.hashCode());
		result = prime * result + ((committeeRole == null) ? 0 : committeeRole.hashCode());
		result = prime * result + ((contactNumbers == null) ? 0 : contactNumbers.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (clubName == null) {
			if (other.clubName != null)
				return false;
		} else if (!clubName.equals(other.clubName))
			return false;
		if (committeeRole != other.committeeRole)
			return false;
		if (contactNumbers == null) {
			if (other.contactNumbers != null)
				return false;
		} else if (! CommonUtil.compare(contactNumbers, other.contactNumbers))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
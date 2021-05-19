package com.domloge.catholiconmsclublibrary;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class PhoneNumber {
	
	private PhoneNumberType type;
	
	private String number;

	public PhoneNumber() {
	}

	public PhoneNumber(PhoneNumberType type, String number) {
		super();
		this.type = type;
		this.number = number;
	}

	public PhoneNumberType getType() {
		return type;
	}

	public String getNumber() {
		return number;
	}

	public void setType(PhoneNumberType type) {
		this.type = type;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		PhoneNumber other = (PhoneNumber) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}

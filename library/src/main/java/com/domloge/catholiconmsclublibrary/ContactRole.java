package com.domloge.catholiconmsclublibrary;

import com.fasterxml.jackson.annotation.JsonValue;

import io.micronaut.core.annotation.Introspected;

@Introspected
public enum ContactRole {
	CHAIRMAN("Chairman"), 
	SECRETARY("Secretary"), 
	MATCHSECRETARY("Match Secretary"), 
	TREASURER("Treasurer"),
	FIXTURESSECRETARY("Fixtures Secretary"),
	TOURNAMENTS("Tournaments"),
	JUNIORDEVELOPMENT("Junior Development"),
	WEBSITEADMINISTRATOR("Website Administrator"),
	MEMBER("Committee Member");
	
	private String jsonValue;
	
	private ContactRole(String jsonValue) {
		this.jsonValue = jsonValue;
	}

	public static ContactRole forPageText(String s) {
		for (ContactRole role : values()) {
			if(role.jsonValue.equalsIgnoreCase(s)) return role;
		}
		return MEMBER;
	}
	
	@JsonValue
	public String getJsonValue() {
		return jsonValue;
	}
}

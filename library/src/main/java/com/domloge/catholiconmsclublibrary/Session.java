package com.domloge.catholiconmsclublibrary;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Session {

	private String locationName;
	private String locationAddr;
	private String days;
	private String numCourts;
	private String start;
	private String end;


	public Session() {
	}

	public Session(String locationName, String locationAddr, String days, String numCourts, String start, String end) {
		this.locationName = locationName;
		this.locationAddr = locationAddr;
		this.days = days;
		this.numCourts = numCourts;
		this.start = start;
		this.end = end;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationAddr() {
		return locationAddr;
	}

	public void setLocationAddr(String locationAddr) {
		this.locationAddr = locationAddr;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getNumCourts() {
		return numCourts;
	}

	public void setNumCourts(String numCourts) {
		this.numCourts = numCourts;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
}

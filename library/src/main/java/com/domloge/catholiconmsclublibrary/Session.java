package com.domloge.catholiconmsclublibrary;

import org.joda.time.DateTimeConstants;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Session {

	private String locationName;
	private String locationAddr;
	private String days;
	private int numCourts;
	private String start;
	private String end;


	public Session() {
	}

	public Session(String locationName, String locationAddr, String days, int numCourts, String start, String end) {
		this.locationName = locationName;
		this.locationAddr = locationAddr;
		this.days = days;
		this.numCourts = numCourts;
		this.start = start;
		this.end = end;
	}

	public int daysAsJodaDayOfWeekInt() {
		if("Mondays".equalsIgnoreCase(days)) return DateTimeConstants.MONDAY;
		if("Tuesdays".equalsIgnoreCase(days)) return DateTimeConstants.TUESDAY;
		if("Wednesdays".equalsIgnoreCase(days)) return DateTimeConstants.WEDNESDAY;
		if("Thursdays".equalsIgnoreCase(days)) return DateTimeConstants.THURSDAY;
		if("Fridays".equalsIgnoreCase(days)) return DateTimeConstants.FRIDAY;
		if("Saturdays".equalsIgnoreCase(days)) return DateTimeConstants.SATURDAY;
		if("Sundays".equalsIgnoreCase(days)) return DateTimeConstants.SUNDAY;
		throw new RuntimeException("Could not map "+days);
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

	public int getNumCourts() {
		return numCourts;
	}

	public void setNumCourts(int numCourts) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((locationAddr == null) ? 0 : locationAddr.hashCode());
		result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
		result = prime * result + numCourts;
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		Session other = (Session) obj;
		if (days == null) {
			if (other.days != null)
				return false;
		} else if (!days.equals(other.days))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (locationAddr == null) {
			if (other.locationAddr != null)
				return false;
		} else if (!locationAddr.equals(other.locationAddr))
			return false;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		if (numCourts != other.numCourts)
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

	
}

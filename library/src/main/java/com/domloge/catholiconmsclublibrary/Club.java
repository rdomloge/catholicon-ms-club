package com.domloge.catholiconmsclublibrary;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Club {
    
    private int clubId;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z ]{3,}") // any case, spaces, at least 3 characters
	private String clubName;

    private int seasonId;
    
    private Contact chairMan;
	private Contact secretary;
	private Contact matchSec;
	private Contact treasurer;
	
    private List<Team> teams;
	private List<Session> clubSessions;
	private List<Session> matchSessions;

    public Club() {
    }

    public Club(int clubId, @NotBlank @Pattern(regexp = "[a-zA-Z ]{3,}") String clubName, int seasonId,
            Contact chairMan, Contact secretary, Contact matchSec, Contact treasurer, List<Session> clubSessions,
            List<Session> matchSessions, List<Team> teams) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.seasonId = seasonId;
        this.chairMan = chairMan;
        this.secretary = secretary;
        this.matchSec = matchSec;
        this.treasurer = treasurer;
        this.clubSessions = clubSessions;
        this.matchSessions = matchSessions;
        this.teams = teams;
    }

    public void fillOutRoles(String chairMan, String secretary, String matchSec, String treasurer) {
		this.chairMan = null != CommonUtil.nullIfEmpty(chairMan) ? new Contact(chairMan) : null;
		this.secretary = null != CommonUtil.nullIfEmpty(secretary) ? new Contact(secretary) : null;
		this.matchSec = null != CommonUtil.nullIfEmpty(matchSec) ? new Contact(matchSec) : null;
		this.treasurer = null != CommonUtil.nullIfEmpty(treasurer) ? new Contact(treasurer) : null;
	}
	
	public void fillOutPhoneNumbers(PhoneNumber[] chairManPhone, PhoneNumber[] secretaryPhone, PhoneNumber[] matchSecPhone, PhoneNumber[] treasurerPhone) {
		if(chairManPhone.length > 0) chairMan.setContactNumbers(Arrays.asList(chairManPhone));
		if(secretaryPhone.length > 0) secretary.setContactNumbers(Arrays.asList(secretaryPhone));
		if(matchSecPhone.length > 0) matchSec.setContactNumbers(Arrays.asList(matchSecPhone));
		if(treasurerPhone.length > 0) treasurer.setContactNumbers(Arrays.asList(treasurerPhone));
	}

    public void linkTeam(Team t) {
        if(null == teams) teams = new LinkedList<>();
        this.teams.add(t);
    }
	
	public void fillOutEmailAddresses(String chairmanEmail, String secretaryEmail, String matchSecEmail,
			String treasurerEmail) {
		
		if(null != chairMan) {
			chairMan.setEmail(null != CommonUtil.nullIfEmpty(chairmanEmail) ? chairmanEmail : null);
		}
		if(null != secretary) {
			secretary.setEmail(null != CommonUtil.nullIfEmpty(secretaryEmail) ? secretaryEmail : null);
		}
		if(null != matchSec) {
			matchSec.setEmail(null != CommonUtil.nullIfEmpty(matchSecEmail) ? matchSecEmail : null);
		}
		if(null != treasurer) {
			treasurer.setEmail(null != CommonUtil.nullIfEmpty(treasurerEmail) ? treasurerEmail : null);
		}
	}

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getClubId() {
        return clubId;
    }
    
    public void setClubId(int clubId) {
        this.clubId = clubId;
    }
    
    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Contact getChairMan() {
        return chairMan;
    }

    public void setChairMan(Contact chairMan) {
        this.chairMan = chairMan;
    }

    public Contact getSecretary() {
        return secretary;
    }

    public void setSecretary(Contact secretary) {
        this.secretary = secretary;
    }

    public Contact getMatchSec() {
        return matchSec;
    }

    public void setMatchSec(Contact matchSec) {
        this.matchSec = matchSec;
    }

    public Contact getTreasurer() {
        return treasurer;
    }

    public void setTreasurer(Contact treasurer) {
        this.treasurer = treasurer;
    }

    public List<Session> getClubSessions() {
        return clubSessions;
    }

    public void setClubSessions(List<Session> clubSessions) {
        this.clubSessions = clubSessions;
    }

    public List<Session> getMatchSessions() {
        return matchSessions;
    }

    public void setMatchSessions(List<Session> matchSessions) {
        this.matchSessions = matchSessions;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "Club [chairMan=" + chairMan + ", clubId=" + clubId + ", clubName=" + clubName + ", clubSessions="
                + clubSessions + ", matchSec=" + matchSec + ", matchSessions=" + matchSessions + ", seasonId="
                + seasonId + ", secretary=" + secretary + ", teams=" + teams + ", treasurer=" + treasurer + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((chairMan == null) ? 0 : chairMan.hashCode());
        result = prime * result + clubId;
        result = prime * result + ((clubName == null) ? 0 : clubName.hashCode());
        result = prime * result + ((clubSessions == null) ? 0 : clubSessions.hashCode());
        result = prime * result + ((matchSec == null) ? 0 : matchSec.hashCode());
        result = prime * result + ((matchSessions == null) ? 0 : matchSessions.hashCode());
        result = prime * result + seasonId;
        result = prime * result + ((secretary == null) ? 0 : secretary.hashCode());
        result = prime * result + ((teams == null) ? 0 : teams.hashCode());
        result = prime * result + ((treasurer == null) ? 0 : treasurer.hashCode());
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
        Club other = (Club) obj;
        if (chairMan == null) {
            if (other.chairMan != null)
                return false;
        } else if (!chairMan.equals(other.chairMan))
            return false;
        if (clubId != other.clubId)
            return false;
        if (clubName == null) {
            if (other.clubName != null)
                return false;
        } else if (!clubName.equals(other.clubName))
            return false;
        if (clubSessions == null) {
            if (other.clubSessions != null)
                return false;
        } else if (! CommonUtil.compare(clubSessions, other.clubSessions))
            return false;
        if (matchSec == null) {
            if (other.matchSec != null)
                return false;
        } else if (!matchSec.equals(other.matchSec))
            return false;
        if (matchSessions == null) {
            if (other.matchSessions != null)
                return false;
        } else if (! CommonUtil.compare(matchSessions, other.matchSessions))
            return false;
        if (seasonId != other.seasonId)
            return false;
        if (secretary == null) {
            if (other.secretary != null)
                return false;
        } else if (!secretary.equals(other.secretary))
            return false;
        if (teams == null) {
            if (other.teams != null)
                return false;
        } else if (! CommonUtil.compare(teams, other.teams))
            return false;
        if (treasurer == null) {
            if (other.treasurer != null)
                return false;
        } else if (!treasurer.equals(other.treasurer))
            return false;
        return true;
    }

    
}

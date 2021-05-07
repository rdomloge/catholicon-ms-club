package com.domloge.catholiconmsclublibrary;

import java.util.Arrays;
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
    
    // private Contact chairMan;
	// private Contact secretary;
	// private Contact matchSec;
	// private Contact treasurer;
	
	// private List<Session> clubSessions;
	// private List<Session> matchSessions;

    public Club() {
    }

    public Club(int clubId, @NotBlank @Pattern(regexp = "[a-zA-Z ]{3,}") String clubName, int seasonId,
            Contact chairMan, Contact secretary, Contact matchSec, Contact treasurer, List<Session> clubSessions,
            List<Session> matchSessions) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.seasonId = seasonId;
        // this.chairMan = chairMan;
        // this.secretary = secretary;
        // this.matchSec = matchSec;
        // this.treasurer = treasurer;
        // this.clubSessions = clubSessions;
        // this.matchSessions = matchSessions;
    }

    public void fillOutRoles(String chairMan, String secretary, String matchSec, String treasurer) {
		// this.chairMan = null != ParserUtil.nullIfEmpty(chairMan) ? new Contact(chairMan) : null;
		// this.secretary = null != ParserUtil.nullIfEmpty(secretary) ? new Contact(secretary) : null;
		// this.matchSec = null != ParserUtil.nullIfEmpty(matchSec) ? new Contact(matchSec) : null;
		// this.treasurer = null != ParserUtil.nullIfEmpty(treasurer) ? new Contact(treasurer) : null;
	}
	
	public void fillOutPhoneNumbers(PhoneNumber[] chairManPhone, PhoneNumber[] secretaryPhone, PhoneNumber[] matchSecPhone, PhoneNumber[] treasurerPhone) {
		// if(chairManPhone.length > 0) chairMan.setContactNumbers(Arrays.asList(chairManPhone));
		// if(secretaryPhone.length > 0) secretary.setContactNumbers(Arrays.asList(secretaryPhone));
		// if(matchSecPhone.length > 0) matchSec.setContactNumbers(Arrays.asList(matchSecPhone));
		// if(treasurerPhone.length > 0) treasurer.setContactNumbers(Arrays.asList(treasurerPhone));
	}
	
	public void fillOutEmailAddresses(String chairmanEmail, String secretaryEmail, String matchSecEmail,
			String treasurerEmail) {
		
		// if(null != chairMan) {
		// 	chairMan.setEmail(null != ParserUtil.nullIfEmpty(chairmanEmail) ? chairmanEmail : null);
		// }
		// if(null != secretary) {
		// 	secretary.setEmail(null != ParserUtil.nullIfEmpty(secretaryEmail) ? secretaryEmail : null);
		// }
		// if(null != matchSec) {
		// 	matchSec.setEmail(null != ParserUtil.nullIfEmpty(matchSecEmail) ? matchSecEmail : null);
		// }
		// if(null != treasurer) {
		// 	treasurer.setEmail(null != ParserUtil.nullIfEmpty(treasurerEmail) ? treasurerEmail : null);
		// }
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

    // public Contact getChairMan() {
    //     return chairMan;
    // }

    // public void setChairMan(Contact chairMan) {
    //     this.chairMan = chairMan;
    // }

    // public Contact getSecretary() {
    //     return secretary;
    // }

    // public void setSecretary(Contact secretary) {
    //     this.secretary = secretary;
    // }

    // public Contact getMatchSec() {
    //     return matchSec;
    // }

    // public void setMatchSec(Contact matchSec) {
    //     this.matchSec = matchSec;
    // }

    // public Contact getTreasurer() {
    //     return treasurer;
    // }

    // public void setTreasurer(Contact treasurer) {
    //     this.treasurer = treasurer;
    // }

    // public List<Session> getClubSessions() {
    //     return clubSessions;
    // }

    // public void setClubSessions(List<Session> clubSessions) {
    //     this.clubSessions = clubSessions;
    // }

    // public List<Session> getMatchSessions() {
    //     return matchSessions;
    // }

    // public void setMatchSessions(List<Session> matchSessions) {
    //     this.matchSessions = matchSessions;
    // }

    @Override
    public String toString() {
        return "Club [clubId=" + clubId + ", clubName=" + clubName + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + clubId;
        result = prime * result + ((clubName == null) ? 0 : clubName.hashCode());
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
        if (clubId != other.clubId)
            return false;
        if (clubName == null) {
            if (other.clubName != null)
                return false;
        } else if (!clubName.equals(other.clubName))
            return false;
        return true;
    }
}

package com.hashtag.cricketGuru.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cricket_match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;

    private String teamHeading;
    private String matchNumberVenue;
    private String battingTeam;
    private String battingTeamScore;
    private String bowlingTeam;
    private String bowlingTeamScore;
    private String liveText;
    private String matchLink;
    private String textComplete;

    @Enumerated
    private MatchStatus status;

    private Date date= new Date();

    public void setMatchStatus(){
        if(textComplete.isBlank()){
            this.status=MatchStatus.LIVE;
        }else{
            this.status=MatchStatus.COMPLETED;
        }
    }

}

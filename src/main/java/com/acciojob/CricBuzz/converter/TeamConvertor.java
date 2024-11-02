package com.acciojob.CricBuzz.converter;

import com.acciojob.CricBuzz.dto.request.TeamRequest;
import com.acciojob.CricBuzz.dto.response.TeamResponse;
import com.acciojob.CricBuzz.model.Team;

public class TeamConvertor {

    public static Team teamRequestToTeam(TeamRequest teamRequest) {
        return Team.builder()
                .teamName(teamRequest.getTeamName())
                .ranking(teamRequest.getRanking())
                .iccPoints(teamRequest.getIccPoints())
                .build();
    }

    public static TeamResponse teamToTeamResponse(Team team) {
        return TeamResponse.builder()
                .ranking(team.getRanking())
                .teamName(team.getTeamName())
                .build();
    }
}

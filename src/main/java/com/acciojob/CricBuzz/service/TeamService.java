package com.acciojob.CricBuzz.service;

import com.acciojob.CricBuzz.converter.TeamConvertor;
import com.acciojob.CricBuzz.dto.request.TeamRequest;
import com.acciojob.CricBuzz.dto.response.TeamResponse;
import com.acciojob.CricBuzz.model.Team;
import com.acciojob.CricBuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    public TeamResponse addTeam(TeamRequest teamRequest) {
        Team team = TeamConvertor.teamRequestToTeam(teamRequest);
        Team savedTeam = teamRepository.save(team);
        return TeamConvertor.teamToTeamResponse(savedTeam);
    }
}

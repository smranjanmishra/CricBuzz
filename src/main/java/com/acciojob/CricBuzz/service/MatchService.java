package com.acciojob.CricBuzz.service;

import com.acciojob.CricBuzz.converter.MatchConvertor;
import com.acciojob.CricBuzz.dto.request.CricketMatchRequest;
import com.acciojob.CricBuzz.dto.response.CricketMatchResponse;
import com.acciojob.CricBuzz.exception.CricketMatchRepo;
import com.acciojob.CricBuzz.exception.TeamNotFoundException;
import com.acciojob.CricBuzz.model.CricketMatch;
import com.acciojob.CricBuzz.model.Team;
import com.acciojob.CricBuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    CricketMatchRepo cricketMatchRepo;

    public CricketMatchResponse registerMatch(CricketMatchRequest cricketMatchRequest,
                                              int teamAId,
                                              int teamBId) {

        Optional<Team> optionalTeamA = teamRepository.findById(teamAId);
        Optional<Team> optionalTeamB = teamRepository.findById(teamBId);

        if(optionalTeamA.isEmpty() || optionalTeamB.isEmpty()) {
            throw new TeamNotFoundException("Invalid team details");
        }

        Team teamA = optionalTeamA.get();
        Team teamB = optionalTeamB.get();

        CricketMatch match = MatchConvertor.cricketMatchRequestToCricketMatch(cricketMatchRequest);

        List<Team> teams = List.of(teamA,teamB);
        match.setTeams(teams);

        teamA.getMatches().add(match);
        teamB.getMatches().add(match);

        CricketMatch savedMatch = cricketMatchRepo.save(match);
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        return MatchConvertor.cricketMatchToCricketMatchResponse(savedMatch);
    }
}

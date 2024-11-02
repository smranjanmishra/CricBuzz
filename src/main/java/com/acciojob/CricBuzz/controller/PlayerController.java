package com.acciojob.CricBuzz.controller;

import com.acciojob.CricBuzz.dto.request.PlayerRequest;
import com.acciojob.CricBuzz.dto.response.PlayerResponse;
import com.acciojob.CricBuzz.model.Enum.Gender;
import com.acciojob.CricBuzz.model.Enum.Speciality;
import com.acciojob.CricBuzz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @PostMapping
    public ResponseEntity addPlayer(@RequestBody PlayerRequest playerRequest) {
        PlayerResponse response = playerService.addPlayer(playerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public PlayerResponse getPlayer(@RequestParam("player-id") int playerId) {
        return playerService.getPlayer(playerId);
    }

    // get all the players of a particular gender
    // input -> gender
    // output -> List<PlayerResponse>
    @GetMapping("/gender/{gender}")
    public List<PlayerResponse> getPlayerByGender(@PathVariable("gender") Gender gender) {
        return playerService.getPlayerByGender(gender);
    }

    // get all the players of a particular gender and a particular
    // input -> gender and speciality
    @GetMapping("/gender/{gender}/speciality/{speciality}")
    public List<PlayerResponse> getPlayerByGenderAndSpeciality(@PathVariable("gender") Gender gender,
                                                               @PathVariable("speciality") Speciality speciality) {
        return playerService.getPlayerByGenderAndSpeciality(gender,speciality);
    }
}

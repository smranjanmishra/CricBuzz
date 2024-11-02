package com.acciojob.CricBuzz.controller;

import com.acciojob.CricBuzz.dto.request.StatsRequest;
import com.acciojob.CricBuzz.exception.PlayerNotFoundException;
import com.acciojob.CricBuzz.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stats")
public class StatsController {
    @Autowired
    StatsService statsService;

    @PostMapping
    public ResponseEntity addStatsForPlayer(@RequestBody StatsRequest statsRequest,
                                            @RequestParam("player-id") int playerId) {
        try{
            return new ResponseEntity(statsService.addStatsForPlayer(statsRequest,playerId), HttpStatus.CREATED);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

package com.acciojob.CricBuzz.converter;

import com.acciojob.CricBuzz.dto.request.StatsRequest;
import com.acciojob.CricBuzz.model.Stats;

public class StatsConvertor {
    public static Stats statsRequestToStats(StatsRequest statsRequest) {
        return Stats.builder()
                .battingAverage(statsRequest.getBattingAverage())
                .bowlingAverage(statsRequest.getBowlingAverage())
                .wicketsTaken(statsRequest.getWicketsTaken())
                .runsScored(statsRequest.getRunsScored())
                .build();
    }
}

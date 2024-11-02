package com.acciojob.CricBuzz.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatsRequest {
    int runsScored;

    int wicketsTaken;

    double battingAverage;

    double bowlingAverage;
}

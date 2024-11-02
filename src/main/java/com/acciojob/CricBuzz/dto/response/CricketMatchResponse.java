package com.acciojob.CricBuzz.dto.response;

import com.acciojob.CricBuzz.model.Enum.MatchType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CricketMatchResponse {
    String title;

    MatchType matchType;

    int overs;

    String place;

    Date startedAt;

    List<TeamResponse> teams;
}

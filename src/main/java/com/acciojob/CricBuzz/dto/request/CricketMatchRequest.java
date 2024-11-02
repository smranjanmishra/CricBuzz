package com.acciojob.CricBuzz.dto.request;

import com.acciojob.CricBuzz.model.Enum.MatchType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CricketMatchRequest {
    String title;

    MatchType matchType;

    int overs;

    String place;
}

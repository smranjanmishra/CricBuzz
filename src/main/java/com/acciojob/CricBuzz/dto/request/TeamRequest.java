package com.acciojob.CricBuzz.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamRequest {
    String teamName;

    int ranking;

    int iccPoints;
}

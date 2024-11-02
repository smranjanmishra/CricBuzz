package com.acciojob.CricBuzz.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamResponse {
    String teamName;

    int ranking;
}

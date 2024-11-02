package com.acciojob.CricBuzz.dto.response;

import com.acciojob.CricBuzz.model.Enum.Speciality;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerResponse {
    String name;
    Speciality speciality;
}

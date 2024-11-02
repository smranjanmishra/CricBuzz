package com.acciojob.CricBuzz.dto.request;

import com.acciojob.CricBuzz.model.Enum.Gender;
import com.acciojob.CricBuzz.model.Enum.Speciality;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerRequest {
    String name;

    int age;

    Gender gender;

    Speciality speciality;

    String email;
}

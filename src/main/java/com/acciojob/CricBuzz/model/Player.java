package com.acciojob.CricBuzz.model;

import com.acciojob.CricBuzz.model.Enum.Gender;
import com.acciojob.CricBuzz.model.Enum.Speciality;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Enumerated(EnumType.STRING)
    Speciality speciality;

    String email;

    @ManyToOne
    @JoinColumn
    Team team;

    @OneToOne(mappedBy = "player",cascade = CascadeType.ALL)
    Stats stats;
}

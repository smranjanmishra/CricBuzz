package com.acciojob.CricBuzz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int runsScored;

    int wicketsTaken;

    double battingAverage;

    double bowlingAverage;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    Player player;
}

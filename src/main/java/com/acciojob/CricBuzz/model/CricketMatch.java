package com.acciojob.CricBuzz.model;

import com.acciojob.CricBuzz.model.Enum.MatchType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CricketMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    MatchType matchType;

    int overs;

    String place;

    @CreationTimestamp
    Date startedAt;

    @ManyToMany
    @JoinTable( name = "match_team",
            joinColumns = {
                    @JoinColumn(name = "cricket_match_id") },
            inverseJoinColumns = { @JoinColumn(name = "team_id") })
    List<Team> teams = new ArrayList<>();
}

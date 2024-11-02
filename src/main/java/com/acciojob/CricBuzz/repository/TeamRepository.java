package com.acciojob.CricBuzz.repository;

import com.acciojob.CricBuzz.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}

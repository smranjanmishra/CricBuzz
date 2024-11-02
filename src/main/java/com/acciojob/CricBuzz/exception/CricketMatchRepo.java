package com.acciojob.CricBuzz.exception;

import com.acciojob.CricBuzz.model.CricketMatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CricketMatchRepo extends JpaRepository<CricketMatch, Integer> {
}

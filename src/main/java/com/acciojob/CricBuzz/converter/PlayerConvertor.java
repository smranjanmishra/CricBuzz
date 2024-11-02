package com.acciojob.CricBuzz.converter;

import com.acciojob.CricBuzz.dto.request.PlayerRequest;
import com.acciojob.CricBuzz.dto.response.PlayerResponse;
import com.acciojob.CricBuzz.model.Player;

public class PlayerConvertor {
    public static Player playerRequestToPlayer(PlayerRequest playerRequest) {
        return Player.builder()
                .name(playerRequest.getName())
                .age(playerRequest.getAge())
                .gender(playerRequest.getGender())
                .speciality(playerRequest.getSpeciality())
                .email(playerRequest.getEmail())
                .build();
    }

    public static PlayerResponse playerToPlayerResponse(Player player) {
        return PlayerResponse.builder()
                .name(player.getName())
                .speciality(player.getSpeciality())
                .build();
    }
}

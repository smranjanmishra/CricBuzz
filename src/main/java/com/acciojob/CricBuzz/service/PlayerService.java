package com.acciojob.CricBuzz.service;

import com.acciojob.CricBuzz.converter.PlayerConvertor;
import com.acciojob.CricBuzz.dto.request.PlayerRequest;
import com.acciojob.CricBuzz.dto.response.PlayerResponse;
import com.acciojob.CricBuzz.exception.PlayerNotFoundException;
import com.acciojob.CricBuzz.model.Enum.Gender;
import com.acciojob.CricBuzz.model.Enum.Speciality;
import com.acciojob.CricBuzz.model.Player;
import com.acciojob.CricBuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public PlayerResponse addPlayer(PlayerRequest playerRequest) {
        Player player = PlayerConvertor.playerRequestToPlayer(playerRequest);
        Player savedPlayer = playerRepository.save(player);

        sendEmail(savedPlayer);
        return PlayerConvertor.playerToPlayerResponse(savedPlayer);
    }

    private void sendEmail(Player savedPlayer) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        String text = "Hey "+savedPlayer.getName()+" you have been successfully registered in Cricbuzz application."
                + " with speciality as " + savedPlayer.getSpeciality();

        mailMessage.setSubject("Registration successful");
        mailMessage.setFrom("acciojobspring@gmail.com");
        mailMessage.setTo(savedPlayer.getEmail());
        mailMessage.setText(text);

        javaMailSender.send(mailMessage);
    }


    public PlayerResponse getPlayer(int playerId) {
        Optional<Player> playerOptinal = playerRepository.findById(playerId);
        if(playerOptinal.isEmpty()) {
            throw new PlayerNotFoundException("Invalid player id");
        }
        Player player = playerOptinal.get();
        return PlayerConvertor.playerToPlayerResponse(player);
    }

    public List<PlayerResponse> getPlayerByGender(Gender gender) {
        List<Player> players = playerRepository.findByGender(gender);

        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConvertor.playerToPlayerResponse(player));
        }

        return playerResponses;
    }

    public List<PlayerResponse> getPlayerByGenderAndSpeciality(Gender gender,
                                                               Speciality speciality) {
        List<Player> players = playerRepository.findPlayerBasedOnGenderAndSpeciality(gender,speciality);

        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConvertor.playerToPlayerResponse(player));
        }

        return playerResponses;
    }
}

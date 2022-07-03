package com.example.demo.controller.api;

import com.example.demo.model.Player;
import com.example.demo.repository.IPlayerRepository;
import com.example.demo.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {
    @Autowired
    //@Qualifier("mainPlayerService")
    //private IPlayerService playerService;
    private IPlayerRepository playerRepository;
    public PlayerController(){

    }

    /*@PostMapping("/api/players")
    public ResponseEntity<Player> createTutorial(@RequestBody Player player) {
        try {
            Player _tutorial = playerRepository.save(new Player(player.getMaglia(), player.getNome()));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    //fare meglio con postman!
    @RequestMapping("/api/players/create")
    public void create(){
        playerRepository.save(new Player(11, "Ronaldo"));
    }

    @RequestMapping("/api/players")
    public List<Player> getAll(){
        return playerRepository.findAll();
    }

    @RequestMapping("/api/players/{maglia}")
    public Player getById(@PathVariable int maglia){
        Optional<Player> player = playerRepository.findById(maglia);
        if (player.isEmpty() == true){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
        }
        return player.get();
    }

    @RequestMapping("/api/players/{nome}")
    public Player getByName(@PathVariable String nome){
        Optional<Player> player = playerRepository.findByNome(nome);
        if (player.isEmpty() == true){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
        }
        return player.get();
    }
}

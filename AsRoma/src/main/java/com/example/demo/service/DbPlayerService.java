package com.example.demo.service;

import com.example.demo.model.Player;
import com.example.demo.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("mainPlayerService")
public class DbPlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepository playerRepository;

    @Override
    public Player create(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Optional<Player> getById(int maglia) {
        return playerRepository.findById(maglia);
    }

    @Override
    public Iterable<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public Optional<Player> update(int maglia, Player player) {

        Optional<Player> foundPlayer = playerRepository.findById(maglia);
        if (foundPlayer.isEmpty() == true){
            return Optional.empty();
        }
        foundPlayer.get().setNome(player.getNome());
        playerRepository.save(foundPlayer.get());
        return foundPlayer;
    }

    @Override
    public boolean delete(int maglia) {
        Optional<Player> foundPlayer = playerRepository.findById(maglia);
        if (foundPlayer.isEmpty() == true){
            return false;
        }
        playerRepository.delete(foundPlayer.get());
        return true;
    }
}

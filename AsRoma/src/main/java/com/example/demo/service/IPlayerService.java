package com.example.demo.service;

import com.example.demo.model.Player;

import java.util.Optional;

public interface IPlayerService {
    public Player create(Player player);

    public Optional<Player> getById(int maglia);

    public Iterable<Player> getAll();

    public Optional<Player> update(int maglia, Player player);

    public boolean delete(int maglia);
}

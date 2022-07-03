package com.example.demo.repository;

import com.example.demo.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlayerRepository extends MongoRepository<Player, Integer> {
    @Query("{nome:'?0'}")
    Player findByNome(String nome);

    //List<Player> findAll();
}

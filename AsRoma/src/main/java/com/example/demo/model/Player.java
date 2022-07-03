package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "squadra")
public class Player {
    @Id
    private int maglia;
    private String nome;

    public Player(){}
    public Player(int maglia, String nome){
        this.maglia = maglia;
        this.nome = nome;
    }
    public int getMaglia() {
        return maglia;
    }
    public void setMaglia(int maglia) {
        this.maglia = maglia ;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}

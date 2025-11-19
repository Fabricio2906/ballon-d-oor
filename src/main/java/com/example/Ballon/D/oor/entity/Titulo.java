package com.example.Ballon.D.oor.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity

public class Titulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int importancia;

    @ManyToOne
    @JoinColumn(name = "jogador_id")
    @JsonIgnore
    private Jogador jogador;


    public Titulo(Long id, String nome, int importancia, Jogador jogador) {
        this.id = id;
        this.nome = nome;
        this.importancia = importancia;
        this.jogador = jogador;
    }

    public Titulo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImportancia() {
        return importancia;
    }

    public void setImportancia(int importancia) {
        this.importancia = importancia;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}

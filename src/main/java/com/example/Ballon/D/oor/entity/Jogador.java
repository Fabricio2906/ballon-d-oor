package com.example.Ballon.D.oor.entity;

import jakarta.persistence.*;
import org.hibernate.action.internal.OrphanRemovalAction;

import java.util.List;
import java.util.Objects;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String nome;
    private int idade;
    private int assistencia;
    private int gols;
    private String time;
    private int ga;

    @OneToMany(mappedBy = "jogador", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Titulo> titulo;


    public Jogador(Long id,String nome, int idade, int assistencia, int gols,String time, int ga,List<Titulo> titulo) {
        this.id=id;
        this.nome = nome;
        this.idade = idade;
        this.assistencia = assistencia;
        this.gols = gols;
        this.time=time;
        this.titulo=titulo;
        this.ga=ga;
    }
    public Jogador(){

    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getAssistencia() {
        return assistencia;
    }

    public void setAssistencia(int assistencia) {
        this.assistencia = assistencia;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getGa() {
        return ga;
    }

    public void setGa(int ga) {
        this.ga = ga;
    }

    public List<Titulo> getTitulo() {
        return titulo;
    }

    public void setTitulo(List<Titulo> titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return Objects.equals(id, jogador.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

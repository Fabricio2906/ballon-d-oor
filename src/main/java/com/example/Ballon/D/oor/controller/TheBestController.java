package com.example.Ballon.D.oor.controller;

import com.example.Ballon.D.oor.dto.JogadorDto;
import com.example.Ballon.D.oor.service.BolaOuroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bolaDeOuro")
public class TheBestController {

    private final BolaOuroService bolaOuroService;

    public TheBestController(BolaOuroService bolaOuroService) {
        this.bolaOuroService = bolaOuroService;
    }
    // Criar jogador
    @PostMapping("/criar")
    public ResponseEntity<JogadorDto> criar(@RequestBody JogadorDto jogadorDto) {
        JogadorDto novoJogador = bolaOuroService.criar(jogadorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoJogador);
    }
    // Listar todos jogadores
    @GetMapping("/listar")
    public ResponseEntity<List<JogadorDto>> listar() {
        return ResponseEntity.ok(bolaOuroService.listar());
    }
    // Buscar jogador por ID
    @GetMapping("/jogadores/{id}")
    public ResponseEntity<JogadorDto> buscarPorId(@PathVariable Long id) {
        JogadorDto jogador = bolaOuroService.buscarId(id);
        return ResponseEntity.ok(jogador);
    }
    // Atualizar jogador
    @PutMapping("/att/{id}")
    public ResponseEntity<JogadorDto> atualizar(@PathVariable Long id, @RequestBody JogadorDto jogadorDto) {
        JogadorDto atualizado = bolaOuroService.atualizar(id, jogadorDto);
        return ResponseEntity.ok(atualizado);
    }
    // Deletar jogador
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        bolaOuroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    // Sortear campeão (aleatório ponderado por G.A + títulos)
    @GetMapping("/campeao")
    public ResponseEntity<JogadorDto> sortearCampeao() {
        JogadorDto campeao = bolaOuroService.sortearCampeao();
        return ResponseEntity.ok(campeao);
    }
    //Verdadeiro melhor do mundo
    @GetMapping("/verdadeiro-melhor-do-mundo")
    public ResponseEntity<JogadorDto> melhorDoMundo() {
        JogadorDto melhor = bolaOuroService.melhorDoMundo();
        return ResponseEntity.ok(melhor);
    }
}


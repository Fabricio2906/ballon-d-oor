package com.example.Ballon.D.oor.service;

import com.example.Ballon.D.oor.dto.JogadorDto;
import com.example.Ballon.D.oor.dto.TituloDto;
import com.example.Ballon.D.oor.entity.Jogador;
import com.example.Ballon.D.oor.entity.Titulo;
import com.example.Ballon.D.oor.mapper.JogadorMapper;
import com.example.Ballon.D.oor.repository.BolaOuroRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
public class BolaOuroService implements IBolaOuroService {

    private final BolaOuroRepository bolaOuroRepository;
    private final JogadorMapper jogadorMapper;

    public BolaOuroService(BolaOuroRepository bolaOuroRepository, JogadorMapper jogadorMapper) {
        this.bolaOuroRepository = bolaOuroRepository;
        this.jogadorMapper = jogadorMapper;
    }

    // Criar jogador
    public JogadorDto criar(@NotNull JogadorDto jogadorDto) {
        Jogador jogador = jogadorMapper.toEntity(jogadorDto);
        // Ajusta títulos
        if (jogador.getTitulo() != null) {
            for (Titulo t : jogador.getTitulo()) {
                t.setJogador(jogador);
            }
        }
        // Calcula GA
        jogador.setGa(jogador.getGols() + jogador.getAssistencia());
        // Salva
        Jogador salvo = bolaOuroRepository.save(jogador);
        // Retorna DTO
        return jogadorMapper.toDto(salvo);
    }

    // Listar todos
    public List<JogadorDto> listar() {
        return bolaOuroRepository.findAll()
                .stream()
                .map(jogadorMapper::toDto)
                .toList();
    }

    // Buscar por ID
    public JogadorDto buscarId(Long id) {
        Jogador jogador = bolaOuroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));

        return jogadorMapper.toDto(jogador);
    }

    // Atualizar jogador
    public JogadorDto atualizar(Long id, JogadorDto dto) {

        Jogador existente = bolaOuroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));

        // Atualizar dados simples
        existente.setNome(dto.nome());
        existente.setIdade(dto.idade());
        existente.setGols(dto.gols());
        existente.setAssistencia(dto.assistencia());
        existente.setTime(dto.time());

        // GA
        existente.setGa(dto.gols() + dto.assistencia());

        // Títulos
        existente.getTitulo().clear();
        if (dto.titulo() != null) {
            for (TituloDto tDto : dto.titulo()) {
                Titulo t = jogadorMapper.toTituloEntity(tDto, existente);
                existente.getTitulo().add(t);
            }
        }

        // Salvar
        Jogador salvo = bolaOuroRepository.save(existente);

        return jogadorMapper.toDto(salvo);
    }

    // Deletar
    public void deletar(Long id) {
        bolaOuroRepository.deleteById(id);
    }

    // Cálculo da pontuação
    private int calcularPontuacao(Jogador jogador) {
        int ga = jogador.getGols() + jogador.getAssistencia();
        int pontosTitulos = jogador.getTitulo()
                .stream()
                .mapToInt(Titulo::getImportancia)
                .sum();
        return ga + pontosTitulos;
    }

    // Melhor do mundo
    public JogadorDto melhorDoMundo() {
        Jogador melhor = bolaOuroRepository.findAll()
                .stream()
                .max(Comparator.comparingInt(this::calcularPontuacao))
                .orElseThrow(() -> new RuntimeException("Nenhum jogador cadastrado"));

        return jogadorMapper.toDto(melhor);
    }
    // Sorteio ponderado
    public JogadorDto sortearCampeao() {
        List<Jogador> jogadores = bolaOuroRepository.findAll();
        if (jogadores.isEmpty()) {
            throw new RuntimeException("Nenhum jogador cadastrado!");
        }
        List<Jogador> urna = new ArrayList<>();
        for (Jogador j : jogadores) {
            int pontos = calcularPontuacao(j);
            for (int i = 0; i < pontos; i++) {
                urna.add(j);
            }
        }
        Random random = new Random();
        Jogador sorteado = urna.get(random.nextInt(urna.size()));

        return jogadorMapper.toDto(sorteado);
    }
}
package com.example.Ballon.D.oor.mapper;

import com.example.Ballon.D.oor.dto.JogadorDto;
import com.example.Ballon.D.oor.dto.TituloDto;
import com.example.Ballon.D.oor.entity.Jogador;
import com.example.Ballon.D.oor.entity.Titulo;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class JogadorMapper {

    // ENTITY → DTO
    public JogadorDto toDto(Jogador jogador) {
        List<TituloDto> titulos = jogador.getTitulo() == null
                ? null
                : jogador.getTitulo()
                .stream()
                .map(JogadorMapper::toTituloDto)
                .toList();

        return new JogadorDto(
                jogador.getId(),
                jogador.getNome(),
                jogador.getIdade(),
                jogador.getGols(),
                jogador.getAssistencia(),
                jogador.getTime(),
                jogador.getGa(),
                titulos
        );
    }

    public static TituloDto toTituloDto(Titulo titulo) {
        return new TituloDto(
                titulo.getId(),
                titulo.getNome(),          // ✔ AQUI ESTAVA O ERRO
                titulo.getImportancia()
        );
    }

    // DTO → ENTITY
    public Jogador toEntity(JogadorDto dto) {
        Jogador jogador = new Jogador();
        jogador.setId(dto.id());
        jogador.setNome(dto.nome());
        jogador.setIdade(dto.idade());
        jogador.setGols(dto.gols());
        jogador.setAssistencia(dto.assistencia());
        jogador.setTime(dto.time());
        jogador.setGa(dto.ga());

        if (dto.titulo() != null) {
            List<Titulo> titulos = dto.titulo()
                    .stream()
                    .map(t -> toTituloEntity(t, jogador))
                    .toList();

            jogador.setTitulo(titulos);
        }

        return jogador;
    }

    public static Titulo toTituloEntity(TituloDto dto, Jogador jogador) {
        Titulo t = new Titulo();
        t.setId(dto.id());
        t.setNome(dto.nome());
        t.setImportancia(dto.importancia());
        t.setJogador(jogador);
        return t;
    }
}

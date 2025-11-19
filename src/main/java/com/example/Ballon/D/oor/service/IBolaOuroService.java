package com.example.Ballon.D.oor.service;

import com.example.Ballon.D.oor.dto.JogadorDto;

import com.example.Ballon.D.oor.dto.TituloDto;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface IBolaOuroService {

    public JogadorDto criar(@NotNull JogadorDto jogadorDto);
    public List<JogadorDto> listar();
    public void deletar(Long id);
    public JogadorDto buscarId(Long id);
    public JogadorDto atualizar(Long id, JogadorDto jogadorDto);
    public JogadorDto sortearCampeao();
    public JogadorDto melhorDoMundo();
    private int calcularPontuacao(JogadorDto jogadorDto) {
        return 0;
    }
}

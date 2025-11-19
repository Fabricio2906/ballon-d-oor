package com.example.Ballon.D.oor.dto;

import java.util.List;

public record JogadorDto(
        Long id,
        String nome,
        Integer idade,
        Integer gols,
        Integer assistencia,
        String time,
        Integer ga,
        List<TituloDto> titulo
) {
}

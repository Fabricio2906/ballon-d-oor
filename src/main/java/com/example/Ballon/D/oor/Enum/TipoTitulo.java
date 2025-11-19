package com.example.Ballon.D.oor.Enum;

public enum TipoTitulo {
    CHAMPIONS_LEAGUE(5),
    LIBERTADORES(4),
    COPA_DO_MUNDO(6),
    CAMPEONATO_NACIONAL(3),
    COPAS(2);

    private final int importancia;

    TipoTitulo(int importancia) {
        this.importancia = importancia;
    }

    public int getImportancia() {
        return importancia;
    }
}
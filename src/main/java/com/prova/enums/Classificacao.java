package com.prova.enums;

public enum Classificacao {
    SAIDA("Saída"),
    ENTRADA("Entrada"),
    observacao("Observação");
    private final String descricao;

    Classificacao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return this.descricao;
    }
}

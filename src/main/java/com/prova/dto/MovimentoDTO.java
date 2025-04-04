package com.prova.dto;

import com.prova.enums.Classificacao;

import java.util.Date;
import java.util.Objects;

public class MovimentoDTO {
    private Long id;
    private Date data_movimento;
    private Double valor;
    private Classificacao classificacao;

    public MovimentoDTO() {
    }

    public MovimentoDTO(Long id, Date data_movimento, Double valor, Classificacao classificacao) {
        this.id = id;
        this.data_movimento = data_movimento;
        this.valor = valor;
        this.classificacao = classificacao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData_movimento() {
        return data_movimento;
    }

    public void setData_movimento(Date data_movimento) {
        this.data_movimento = data_movimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MovimentoDTO that = (MovimentoDTO) o;
        return valor == that.valor && Objects.equals(id, that.id) && Objects.equals(data_movimento, that.data_movimento) && classificacao == that.classificacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data_movimento, valor, classificacao);
    }
}

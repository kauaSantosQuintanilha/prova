package com.prova.models;

import com.prova.enums.Classificacao;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "movimento")
public class Movimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_movimento")
    private Date data_movimento;
    private Double valor;
    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

    public Movimento() {
    }

    public Movimento(Long id, Date data_movimento, Double valor, Classificacao classificacao) {
        this.id = id;
        this.data_movimento = data_movimento;
        this.valor =  valor;
        this.classificacao = classificacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor =  valor;
    }

    public Date getData_movimento() {
        return data_movimento;
    }

    public void setData_movimento(Date data_movimento) {
        this.data_movimento = data_movimento;
    }
}
package com.javachess.persistencyData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
public class Log_xadrez {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String peca;
    private int saida_x;
    private int saida_y;
    private int chegada_x;
    private int chegada_y;
    private Date data_partida;
    private Time hora_jogada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeca() {
        return peca;
    }

    public void setPeca(String peca) {
        this.peca = peca;
    }

    public int getSaida_x() {
        return saida_x;
    }

    public void setSaida_x(int saida_x) {
        this.saida_x = saida_x;
    }

    public int getSaida_y() {
        return saida_y;
    }

    public void setSaida_y(int saida_y) {
        this.saida_y = saida_y;
    }

    public int getChegada_x() {
        return chegada_x;
    }

    public void setChegada_x(int chegada_x) {
        this.chegada_x = chegada_x;
    }

    public int getChegada_y() {
        return chegada_y;
    }

    public void setChegada_y(int chegada_y) {
        this.chegada_y = chegada_y;
    }

    public Date getData_partida() {
        return data_partida;
    }

    public void setData_partida(Date data_jogada) {
        this.data_partida = data_jogada;
    }

    public Time getHora_jogada() {
        return hora_jogada;
    }

    public void setHora_jogada(Time hora_jogada) {
        this.hora_jogada = hora_jogada;
    }
}

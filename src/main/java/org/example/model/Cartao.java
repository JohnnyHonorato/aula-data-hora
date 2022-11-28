package org.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cartao {

    private String id;

    private LocalDate dataDaFatura;

    private LocalDateTime dataDePagamento;

    public Cartao(String id, LocalDate dataDaFatura) {
        this.id = id;
        this.dataDaFatura = dataDaFatura;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDataDaFatura() {
        return dataDaFatura;
    }

    public void setDataDaFatura(LocalDate dataDaFatura) {
        this.dataDaFatura = dataDaFatura;
    }

    public String getDataFormatadaByPattern(String pattern) {
        var formatter = DateTimeFormatter.ofPattern(pattern);
        return this.getDataDaFatura().format(formatter);
    }

    public LocalDateTime getDataDePagamento() {
        return dataDePagamento;
    }

    public void setDataDePagamento(LocalDateTime dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }
}

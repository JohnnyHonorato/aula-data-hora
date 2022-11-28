package org.example.model;

import java.time.LocalDate;

public class Cliente {

    public Cliente(String id, String nome, Cartao cartao) {
        this.id = id;
        this.nome = nome;
        this.cartao = cartao;
    }

    private String id;

    private String nome;

    private Cartao cartao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}

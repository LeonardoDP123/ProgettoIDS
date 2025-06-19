package com.example.ProgettoIDS_SpringBoot.Model;

import jakarta.persistence.*;

@Entity
public class Acquirente implements EventoObserver {

    @Id
    private String nome;

    @Transient
    private Carrello carrello;

    public Acquirente() {
        this.carrello = new Carrello();
    }

    public Acquirente(String nome) {
        this.nome = nome;
        this.carrello = new Carrello();
    }

    public String getNome() {
        return nome;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }


    @Override
    public void notifica(Evento evento) {
        System.out.println("📢 Notifica a " + nome + ": nuovo evento disponibile - " + evento.getNome());
    }
}

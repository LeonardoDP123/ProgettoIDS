package com.example.ProgettoIDS_SpringBoot.Model;

import jakarta.persistence.*;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String descrizione;
    private String data;
    private String animatore;

    private boolean approvato = false;

    public Evento() {}

    public Evento(String nome, String descrizione, String data, String animatore) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.data = data;
        this.animatore = animatore;
        this.approvato = false;
    }

    public int getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getAnimatore() { return animatore; }
    public void setAnimatore(String animatore) { this.animatore = animatore; }

    public boolean isApprovato() {
        return approvato;
    }

    public void setApprovato(boolean approvato) {
        this.approvato = approvato;
    }
}

package com.example.ProgettoIDS_SpringBoot.Model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Articolo {

    @Id
    protected int id;

    protected String nome;
    protected double prezzo;
    protected int quantita;

    public Articolo() {}

    public Articolo(int id, String nome, double prezzo, int quantita) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPrezzo() { return prezzo; }
    public int getQuantita() { return quantita; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }
    public void setQuantita(int quantita) { this.quantita = quantita; }

    public abstract Articolo cloneArticoloConQuantita(int quantita);
}

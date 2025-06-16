package com.example.ProgettoIDS_SpringBoot.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class DistributoreTipicita {

    @Id
    private String nome;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Prodotto> magazzino = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Pacchetto> pacchettiCreati = new ArrayList<>();

    public DistributoreTipicita() {}

    public DistributoreTipicita(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Prodotto> getMagazzino() {
        return magazzino;
    }

    public List<Pacchetto> getPacchettiCreati() {
        return pacchettiCreati;
    }

    public void riceviProdotto(Prodotto prodotto) {
        for (Prodotto p : magazzino) {
            if (p.getId() == prodotto.getId()) {
                throw new IllegalArgumentException("Prodotto già presente nel magazzino.");
            }
        }
        magazzino.add(prodotto);
    }

    public void creaPacchetto(int id, String nome, String descrizione, List<Prodotto> selezionati) {
        if (selezionati.size() < 2) {
            throw new IllegalArgumentException("Deve inserire almeno 2 prodotti");
        }

        Pacchetto pacchetto = new Pacchetto(id, nome, descrizione, selezionati);
        pacchettiCreati.add(pacchetto);

        for (Prodotto p : selezionati) {
            magazzino.remove(p);
        }
    }



    public Pacchetto getPacchettoById(int id) {
        return pacchettiCreati.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Pacchetto non trovato"));
    }

    public void rimuoviPacchetto(Pacchetto p) {
        pacchettiCreati.remove(p);
    }
}

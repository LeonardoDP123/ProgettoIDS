package com.example.ProgettoIDS_SpringBoot.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pacchetto extends Articolo {

    private String descrizione;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "pacchetto_prodotti",
            joinColumns = @JoinColumn(name = "pacchetto_id"),
            inverseJoinColumns = @JoinColumn(name = "prodotto_id")
    )
    private List<Prodotto> prodotti = new ArrayList<>();

    public Pacchetto() {}

    public Pacchetto(int id, String nome, String descrizione, List<Prodotto> prodotti) {
        super(id, nome, calcolaPrezzoTotaleScontato(prodotti), 1);
        this.descrizione = descrizione;
        this.prodotti = prodotti;
    }

    private static double calcolaPrezzoTotaleScontato(List<Prodotto> prodotti) {
        double totale = prodotti.stream()
                .mapToDouble(p -> p.getPrezzo() * p.getQuantita())
                .sum();
        return totale * 0.85;
    }

    public String getDescrizione() { return descrizione; }
    public List<Prodotto> getProdotti() { return prodotti; }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
        this.prezzo = calcolaPrezzoTotaleScontato(prodotti);
    }

    @Override
    public Articolo cloneArticoloConQuantita(int quantita) {
        if (quantita != 1)
            throw new UnsupportedOperationException("Un pacchetto si può acquistare solo in quantità pari a 1");

        List<Prodotto> prodottiClonati = new ArrayList<>();
        for (Prodotto p : prodotti) {
            prodottiClonati.add((Prodotto) p.cloneArticoloConQuantita(p.getQuantita()));
        }

        return new Pacchetto(this.id, this.nome, this.descrizione, prodottiClonati);
    }
}

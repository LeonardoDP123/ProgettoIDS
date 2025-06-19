package com.example.ProgettoIDS_SpringBoot.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Carrello {

    @Transient
    private List<Articolo> articoli = new ArrayList<>();

    public void aggiungiArticolo(Articolo articolo) {
        articoli.add(articolo);
    }

    public void rimuoviArticolo(Articolo articolo) {
        articoli.remove(articolo);
    }

    public List<Articolo> getArticoli() {
        return articoli;
    }

    public double calcolaTotale() {
        return articoli.stream()
                .mapToDouble(a -> a.getPrezzo() * a.getQuantita())
                .sum();
    }

    public void rimuoviArticoloConQuantita(int idArticolo, int quantitaDaRimuovere) {
        int quantitaTotale = articoli.stream()
                .filter(a -> a.getId() == idArticolo)
                .mapToInt(Articolo::getQuantita)
                .sum();

        if (quantitaDaRimuovere > quantitaTotale) {
            throw new IllegalArgumentException("Quantità da rimuovere superiore a quella presente nel carrello.");
        }

        List<Articolo> daRimuovere = new ArrayList<>();

        for (Articolo a : articoli) {
            if (a.getId() == idArticolo && quantitaDaRimuovere > 0) {
                if (a.getQuantita() <= quantitaDaRimuovere) {
                    daRimuovere.add(a);
                    quantitaDaRimuovere -= a.getQuantita();
                } else {
                    a.setQuantita(a.getQuantita() - quantitaDaRimuovere);
                    quantitaDaRimuovere = 0;
                }
            }
        }

        articoli.removeAll(daRimuovere);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Carrello{\n");
        for (Articolo a : articoli) {
            sb.append("- ").append(a.getNome())
                    .append(" x").append(a.getQuantita())
                    .append(" → ").append(a.getPrezzo() * a.getQuantita()).append("€\n");
        }
        sb.append("Totale: ").append(calcolaTotale()).append("€\n}");
        return sb.toString();
    }
}

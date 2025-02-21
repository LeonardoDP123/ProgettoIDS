package Entity.Model;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private List<Articolo> articoli;

    public Marketplace() {
        this.articoli = new ArrayList<>();
    }

    public void aggiungiArticolo(Articolo articolo) {
        if (!articoli.contains(articolo)) {
            articoli.add(articolo);
            System.out.println("Articolo aggiunto al marketplace: " + articolo.getNome());
        } else {
            System.out.println("Articolo già presente nel marketplace: " + articolo.getNome());
        }
    }

    public void rimuoviArticolo(Articolo articolo) {
        if (articoli.remove(articolo)) {
            System.out.println("Articolo rimosso dal marketplace: " + articolo.getNome());
        } else {
            System.out.println("Articolo non trovato nel marketplace: " + articolo.getNome());
        }
    }

    public Articolo getArticoloByID(int ID) {
        for (Articolo articolo : articoli) {
            if (articolo.getID() == ID) {
                return articolo;
            }
        }
        return null;
    }

    public List<Articolo> getArticoli() {
        return articoli;
    }

    public void mostraArticoliDisponibili() {
        if (articoli.isEmpty()) {
            System.out.println("Nessun articolo disponibile nel marketplace.");
            return;
        }

        System.out.println("Articoli disponibili nel marketplace:");
        for (Articolo articolo : articoli) {
            System.out.println(articolo);
        }
    }
}
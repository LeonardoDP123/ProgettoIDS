package Entity.Model;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private static volatile Marketplace instance;
    private List<Articolo> articoli;

    private Marketplace() {
        articoli = new ArrayList<>();
    }

    public static Marketplace getInstance() {
        if (instance == null) {
            synchronized (Marketplace.class) {
                if (instance == null) {
                    instance = new Marketplace();
                }
            }
        }
        return instance;
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

    public List<Articolo> getArticoli() {
        return articoli;
    }

    public Articolo getArticoloByID(int ID) {
        for (Articolo articolo : articoli) {
            if (articolo.getID() == ID) {
                return articolo;
            }
        }
        return null; // Articolo non trovato
    }

    public void aggiornaQuantita(Articolo articolo, int nuovaQuantita) {
        articolo.setQuantitaDisponibile(nuovaQuantita);
        if (nuovaQuantita == 0) {
            rimuoviArticolo(articolo); // Rimuove l'articolo se la quantità è 0
        }
    }

}
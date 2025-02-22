package Entity.Model;

import java.util.HashMap;
import java.util.Map;

public class Carrello {
    private Map<Integer, Integer> articoli; // Map di ID articolo e la relativa quantità

    public Carrello() {
        this.articoli = new HashMap<>();
    }

    // Aggiungi un articolo usando l'ID e la quantità
    public void aggiungiArticolo(int articoloID, int quantita) {
        Articolo articolo = Marketplace.getInstance().getArticoloByID(articoloID);
        if (articolo != null) {
            if (articolo.getQuantitaDisponibile() >= quantita) {
                articoli.put(articoloID, articoli.getOrDefault(articoloID, 0) + quantita);
                Marketplace.getInstance().aggiornaQuantita(articolo, articolo.getQuantitaDisponibile() - quantita); // Aggiorna quantità nel marketplace
                System.out.println("Articolo con ID " + articoloID + " aggiunto al carrello (Quantita: " + quantita + ")");
            } else {
                System.out.println("Quantita richiesta maggiore di quella disponibile nel marketplace per l'articolo con ID " + articoloID);
            }
        } else {
            System.out.println("Articolo con ID " + articoloID + " non trovato nel marketplace.");
        }
    }

    // Rimuovi un articolo usando l'ID
    public void rimuoviArticolo(int articoloID) {
        if (articoli.containsKey(articoloID)) {
            articoli.remove(articoloID);
            System.out.println("Articolo con ID " + articoloID + " rimosso dal carrello.");
        } else {
            System.out.println("Articolo con ID " + articoloID + " non trovato nel carrello.");
        }
    }

    // Svuota il carrello
    public void svuotaCarrello() {
        articoli.clear();
        System.out.println("Carrello svuotato.");
    }

    // Ottieni gli articoli del carrello
    public Map<Integer, Integer> getArticoli() {
        return articoli;
    }

    // Verifica se il carrello è vuoto
    public boolean isEmpty() {
        System.out.println("Il carrello non ha articoli.");
        return articoli.isEmpty();

    }
}

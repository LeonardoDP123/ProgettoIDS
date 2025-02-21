package Entity;
import Entity.Model.Articolo;
import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private List<Articolo> articoli;

    public Carrello() {
        this.articoli = new ArrayList<>();
    }

    public void aggiungiArticolo(Articolo articolo) {
        articoli.add(articolo);
        System.out.println("Articolo aggiunto al carrello: " + articolo.getNome());
    }

    public void rimuoviArticolo(Articolo articolo) {
        if (articoli.remove(articolo)) {
            System.out.println("Articolo rimosso dal carrello: " + articolo.getNome());
        } else {
            System.out.println("Articolo non trovato nel carrello: " + articolo.getNome());
        }
    }

    public void svuotaCarrello() {
        articoli.clear();
        System.out.println("Carrello svuotato.");
    }

    public List<Articolo> getArticoli() {
        return articoli;
    }

    public boolean isEmpty() {
        return articoli.isEmpty();
    }
}
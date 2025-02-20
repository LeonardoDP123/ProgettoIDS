package Entity.Model;

import java.util.ArrayList;
import java.util.List;
import Entity.Controller.*;

public class Marketplace {
    private List<Articolo> articoli;

    public Marketplace() {
        this.articoli = new ArrayList<>();
    }

    public void aggiungiArticolo(Articolo articolo) {
        articoli.add(articolo);
    }

    public void rimuoviArticolo(Articolo articolo) {
        articoli.remove(articolo);
    }

    public ArticoloIterator getIterator() {
        return new ArticoloIterator(articoli);
    }

    public List<Articolo> getArticoli() {
        return articoli;
    }
}

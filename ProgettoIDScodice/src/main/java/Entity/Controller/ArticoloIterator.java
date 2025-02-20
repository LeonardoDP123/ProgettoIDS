package Entity.Controller;

import Entity.Model.Articolo;

import java.util.List;

public class ArticoloIterator {
    private List<Articolo> articoli;
    private int posizione;

    public ArticoloIterator(List<Articolo> articoli) {
        this.articoli = articoli;
        this.posizione = 0;
    }

    public boolean hasNext() {
        return posizione < articoli.size();
    }

    public Articolo next() {
        return hasNext() ? articoli.get(posizione++) : null;
    }
}

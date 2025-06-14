import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private List<Articolo> articoli;

    public Carrello() {
        this.articoli = new ArrayList<>();
    }

    public void aggiungiArticolo(Articolo articolo) {
        articoli.add(articolo);
    }

    public List<Articolo> getArticoli() {
        return articoli;
    }

    public void svuota() {
        articoli.clear();
    }

    @Override
    public String toString() {
        return "Carrello{" +
                "articoli=" + articoli +
                '}';
    }

    public double calcolaTotale() {
        double totale = 0.0;
        for (Articolo articolo : articoli) {
            double valoreArticolo = articolo.getPrezzo() * articolo.getQuantita();
            totale += valoreArticolo;
        }
        return totale;
    }

}




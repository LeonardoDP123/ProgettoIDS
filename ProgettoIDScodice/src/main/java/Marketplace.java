import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private static Marketplace instance;
    private List<Articolo> articoliInVendita;

    private Marketplace() {
        articoliInVendita = new ArrayList<>();
    }

    public static Marketplace getInstance() {
        if (instance == null) {
            instance = new Marketplace();
        }
        return instance;
    }

    public void pubblicaArticolo(Articolo articolo) {
        articoliInVendita.add(articolo);
    }

    public List<Articolo> getArticoliInVendita() {
        return articoliInVendita;
    }
    public Articolo getArticoloById(int id) {
        for (Articolo a : articoliInVendita) {
            if (a.getId() == id) {
                return a;
            }
        }
        throw new IllegalArgumentException("Articolo non trovato");
    }

    public void rimuoviArticolo(Articolo articolo) {
        articoliInVendita.remove(articolo);
    }
}
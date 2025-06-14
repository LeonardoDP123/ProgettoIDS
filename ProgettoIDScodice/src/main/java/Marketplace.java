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
}
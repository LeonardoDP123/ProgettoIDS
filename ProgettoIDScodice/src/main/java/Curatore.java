import java.util.ArrayList;
import java.util.List;

public class Curatore {
    private List<Articolo> articoliDaApprovare;

    public Curatore() {
        this.articoliDaApprovare = new ArrayList<>();
    }

    //metodo richiamato da Venditore per aggiungere articoli per approvazione
    public void aggiungiArticoloDaApprovare(Articolo articolo) {
        articoliDaApprovare.add(articolo);
    }

    public List<Articolo> getArticoliDaApprovare() {
        return articoliDaApprovare;
    }

    /*Cerca con iterazione tramite ID, l'articolo nel suo inventario per l'approvazione
    Se presente lo rimuove dal suo inventario e lo inserisce come "approvato" nel marketplace
    Altrimenti lancia eccezione
    */
    public void approvaArticolo(int id) {
        for (int i = 0; i < articoliDaApprovare.size(); i++) {
            if (articoliDaApprovare.get(i).getId() == id) {
                Articolo approvato = articoliDaApprovare.remove(i);
                Marketplace.getInstance().pubblicaArticolo(approvato);
                return;
            }
        }
        throw new IllegalArgumentException("Articolo con ID " + id + " non trovato.");
    }
}
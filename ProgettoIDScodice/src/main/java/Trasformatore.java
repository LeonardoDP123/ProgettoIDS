import java.util.ArrayList;
import java.util.List;

public class Trasformatore extends Venditore {

    private List<Prodotto> inventarioTrasformati;

    public Trasformatore(String nome) {
        super(nome);
        this.inventarioTrasformati = new ArrayList<>();
    }

    public List<Prodotto> getInventarioTrasformati() {
        return inventarioTrasformati;
    }

    public void aggiungiArticoloDaTrasformare(Prodotto prodotto) {
        inventario.add(prodotto);
    }

    public void trasformaProdotto(Prodotto daTrasformare, StrategiaTrasformazione strategia) {
        Prodotto trasformato = strategia.trasforma(daTrasformare);
        inventario.remove(daTrasformare);
        inventarioTrasformati.add(trasformato);
    }

    public Prodotto getProdottoTrasformatoById(int id) {
        for (Prodotto p : inventarioTrasformati) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new IllegalArgumentException("Prodotto trasformato non trovato.");
    }
}
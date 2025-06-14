import java.util.ArrayList;
import java.util.List;

public abstract class Venditore {
    protected String nome;
    protected List<Prodotto> inventario;

    public Venditore(String nome) {
        this.nome = nome;
        this.inventario = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Prodotto> getInventario() {
        return inventario;
    }

    public boolean aggiungiProdotto(Prodotto prodotto) {
        for (Prodotto p : inventario) {
            if (p.getId() == prodotto.getId()) {
                return false; // già presente
            }
        }
        inventario.add(prodotto);
        return true;
    }

    public boolean rimuoviProdottoById(int id) {
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getId() == id) {
                inventario.remove(i);
                return true;
            }
        }
        return false;
    }

    public Prodotto getProdottoById(int id) {
        for (Prodotto p : inventario) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new IllegalArgumentException("Prodotto con ID " + id + " non trovato nell'inventario.");
    }
}
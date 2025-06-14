import java.util.List;

public class Pacchetto extends Articolo {

    private String descrizione;
    private List<Prodotto> prodottiInclusi;

    public Pacchetto(int id, String nome, double prezzo, int quantita, String descrizione, List<Prodotto> prodottiInclusi) {
        super(id, nome, prezzo, quantita);
        this.descrizione = descrizione;
        this.prodottiInclusi = prodottiInclusi;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public List<Prodotto> getProdottiInclusi() {
        return prodottiInclusi;
    }

    @Override
    public String toString() {
        return "Pacchetto{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", prezzo=" + getPrezzo() +
                ", quantita=" + getQuantita() +
                ", descrizione='" + descrizione + '\'' +
                ", prodottiInclusi=" + prodottiInclusi +
                '}';
    }
}

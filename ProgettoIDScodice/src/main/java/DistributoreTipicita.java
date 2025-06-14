import java.util.ArrayList;
import java.util.List;

public class DistributoreTipicita extends Venditore {

    private List<Pacchetto> pacchettiCreati;

    public DistributoreTipicita(String nome) {
        super(nome);
        this.pacchettiCreati = new ArrayList<>();
    }

    public void aggiungiArticoloPerPacchetto(Prodotto prodotto) {
        inventario.add(prodotto);
    }

    public List<Pacchetto> getPacchettiCreati() {
        return pacchettiCreati;
    }

    public void aggiungiPacchettoCreato(Pacchetto pacchetto) {
        pacchettiCreati.add(pacchetto);
    }

    public void rimuoviPacchetto(Pacchetto pacchetto) {
        pacchettiCreati.remove(pacchetto);
    }

    public Pacchetto getPacchettoById(int id) {
        for (Pacchetto p : pacchettiCreati) {
            if (p.getId() == id) return p;
        }
        throw new IllegalArgumentException("Pacchetto con ID " + id + " non trovato.");
    }

}
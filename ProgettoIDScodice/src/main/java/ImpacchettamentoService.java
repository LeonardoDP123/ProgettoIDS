import java.util.ArrayList;
import java.util.List;

public class ImpacchettamentoService {

    public Pacchetto creaPacchetto(DistributoreTipicita distributore,
                                   int id,
                                   String nome,
                                   String descrizione,
                                   List<Integer> idProdotti) {

        List<Prodotto> selezionati = new ArrayList<>();
        double prezzoTotale = 0.0;

        for (int idProdotto : idProdotti) {
            Prodotto p = distributore.getProdottoById(idProdotto);
            selezionati.add(p);
            prezzoTotale += p.getPrezzo();
        }

        double prezzoScontato = prezzoTotale * 0.85; // -15% di sconto promozionale

        Pacchetto pacchetto = new Pacchetto(id, nome, prezzoScontato, 1, descrizione, selezionati);
        distributore.aggiungiPacchettoCreato(pacchetto);

        for (Prodotto p : selezionati) {
            distributore.rimuoviProdottoById(p.getId());
        }

        return pacchetto;
    }
}
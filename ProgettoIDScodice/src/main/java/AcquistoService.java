import java.util.List;
import java.util.Iterator;

public class AcquistoService {

    public void aggiungiAlCarrello(Acquirente acquirente, int idArticolo, int quantitaDesiderata) {
        if (quantitaDesiderata <= 0) {
            System.out.println("Quantità non valida: deve essere almeno 1. Articolo non aggiunto al carrello di " + acquirente.getNome());
            return;
        }

        try {
            Articolo disponibile = Marketplace.getInstance().getArticoloById(idArticolo);

            if (disponibile.getQuantita() < quantitaDesiderata) {
                System.out.println(" Quantità non disponibile per l'articolo con ID " + idArticolo);
                return;
            }

            Articolo clone = disponibile.cloneArticoloConQuantita(quantitaDesiderata);
            acquirente.getCarrello().aggiungiArticolo(clone);
        } catch (IllegalArgumentException e) {
            System.out.println(" Errore: " + e.getMessage());
        }
    }



    public void acquista(Acquirente acquirente) {
        Marketplace marketplace = Marketplace.getInstance();
        List<Articolo> carrello = acquirente.getCarrello().getArticoli();

        Iterator<Articolo> iterator = carrello.iterator();

        while (iterator.hasNext()) {
            Articolo articoloCarrello = iterator.next();

            try {
                Articolo articoloMarketplace = marketplace.getArticoloById(articoloCarrello.getId());

                int disponibili = articoloMarketplace.getQuantita();
                int richiesti = articoloCarrello.getQuantita();

                if (disponibili < richiesti) {
                    System.out.println(" Quantità insufficiente per '" + articoloCarrello.getNome()
                            + "' nel carrello di " + acquirente.getNome());
                    continue;
                }

                int nuovaQuantita = disponibili - richiesti;

                if (nuovaQuantita == 0) {
                    marketplace.rimuoviArticolo(articoloMarketplace);
                } else {
                    articoloMarketplace.setQuantita(nuovaQuantita);
                }

            } catch (IllegalArgumentException e) {
                System.out.println(" Articolo non trovato nel marketplace, rimosso dal carrello di "
                        + acquirente.getNome() + ": " + articoloCarrello.getNome());
                iterator.remove();
            }
        }

        acquirente.getCarrello().svuota();
    }

}

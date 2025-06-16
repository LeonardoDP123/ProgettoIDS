package com.example.ProgettoIDS_SpringBoot.Service;

import com.example.ProgettoIDS_SpringBoot.Model.*;
import com.example.ProgettoIDS_SpringBoot.Model.Articolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcquistoService {

    @Autowired
    private Marketplace marketplace;

    public void aggiungiAlCarrello(Acquirente acquirente, int idArticolo, int quantitaRichiesta) {
        if (quantitaRichiesta <= 0) {
            throw new IllegalArgumentException("Quantità non valida");
        }

        Articolo articoloOriginale = marketplace.getArticoloById(idArticolo);

        if (articoloOriginale instanceof Pacchetto) {
            if (quantitaRichiesta != 1) {
                throw new IllegalArgumentException("Un pacchetto può essere acquistato solo in quantità pari a 1");
            }
        } else {
            if (articoloOriginale.getQuantita() < quantitaRichiesta) {
                throw new IllegalArgumentException("Quantità non disponibile");
            }
        }

        Articolo articoloClonato = articoloOriginale.cloneArticoloConQuantita(quantitaRichiesta);
        acquirente.getCarrello().aggiungiArticolo(articoloClonato);
    }


    public void acquistaTutto(Acquirente acquirente) {
        for (Articolo daAcquistare : acquirente.getCarrello().getArticoli()) {
            Articolo marketplaceArticolo = marketplace.getArticoloById(daAcquistare.getId());

            if (marketplaceArticolo.getQuantita() < daAcquistare.getQuantita()) {
                throw new IllegalArgumentException("Quantità insufficiente per: " + daAcquistare.getNome());
            }

            int nuovaQuantita = marketplaceArticolo.getQuantita() - daAcquistare.getQuantita();
            marketplaceArticolo.setQuantita(nuovaQuantita);
        }

        double totale = acquirente.getCarrello().calcolaTotale();
        acquirente.getCarrello().getArticoli().clear();

        System.out.println("Acquisto completato! Totale pagato: €" + totale);
    }

}

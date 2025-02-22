package Entity.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Acquirente extends UtenteGenerico {
    private List<Articolo> storicoOrdini;
    private Carrello carrello;

    public Acquirente(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
                      String numeroDiTelefono, String indirizzo) {
        super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo, Ruolo.ACQUIRENTE);
        this.storicoOrdini = new ArrayList<>();
        this.carrello = new Carrello();
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void acquistaCarrello(Marketplace marketplace) {
        if (carrello.isEmpty()) {
            System.out.println("Il carrello è vuoto.");
            return;
        }

        for (Map.Entry<Integer, Integer> entry : carrello.getArticoli().entrySet()) {
            int articoloID = entry.getKey();
            int quantitaRichiesta = entry.getValue();

            // Ottieni l'articolo dal Marketplace usando l'ID
            Articolo articoloInMarketplace = marketplace.getArticoloByID(articoloID);

            if (articoloInMarketplace == null || !articoloInMarketplace.isStato()) {
                System.out.println("Articolo con ID " + articoloID + " non disponibile.");
                continue;
            }

            if (articoloInMarketplace.getQuantitaDisponibile() < quantitaRichiesta) {
                System.out.println("Quantità insufficiente per l'articolo con ID " + articoloID);
                continue;
            }

            // Aggiorna la quantità nel Marketplace
            int nuovaQuantita = articoloInMarketplace.getQuantitaDisponibile() - quantitaRichiesta;
            marketplace.aggiornaQuantita(articoloInMarketplace, nuovaQuantita);

            // Se la quantità diventa 0, rimuovi l'articolo dal marketplace
            if (nuovaQuantita == 0) {
                marketplace.rimuoviArticolo(articoloInMarketplace);
            }

            // Aggiungi l'articolo acquistato allo storico ordini
            for (int i = 0; i < quantitaRichiesta; i++) {
                storicoOrdini.add(articoloInMarketplace);
            }
            System.out.println("Acquistato: " + articoloInMarketplace.getNome() + " (Quantità: " + quantitaRichiesta + ")");
        }

        // Svuota il carrello dopo l'acquisto
        carrello.svuotaCarrello();
    }

    public void visualizzaStoricoOrdini() {
        if (storicoOrdini.isEmpty()) {
            System.out.println("Non hai effettuato nessun acquisto.");
            return;
        }

        System.out.println("Storico degli ordini:");
        for (Articolo articolo : storicoOrdini) {
            System.out.println(articolo);
        }
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Acquirente: " + getNome() + " " + getCognome() +
                " | Username: " + getUsername());
    }
}
package Entity.Model;


import Entity.Carrello;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Acquirente extends User {
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
        for (Articolo articolo : carrello.getArticoli()) {
            Articolo articoloInMarketplace = marketplace.getArticoloByID(articolo.getID());

            if (articoloInMarketplace == null || !articoloInMarketplace.isStato()) {
                System.out.println("Articolo non disponibile: " + articolo.getNome());
                continue;
            }

            if (articoloInMarketplace.getQuantitaDisponibile() <= 0) {
                System.out.println("Articolo esaurito: " + articolo.getNome());
                continue;
            }

            articoloInMarketplace.setQuantitaDisponibile(articoloInMarketplace.getQuantitaDisponibile() - 1);
            storicoOrdini.add(articoloInMarketplace);
            System.out.println("Acquistato: " + articolo.getNome());
        }

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
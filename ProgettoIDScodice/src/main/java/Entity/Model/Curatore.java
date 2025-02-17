package Entity.Model;

import Entity.Controller.Ruolo;
import java.time.LocalDate;


public class Curatore extends User {
    public Curatore(int ID, String username, String nome, String cognome,
                    LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
        super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo, Ruolo.CURATORE);
    }

    // Approva un prodotto solo se supera i controlli
    public void valutaProdotto(Prodotto prodotto) {
        if (prodotto.getQuantitaDisponibile() <= 0) {
            System.out.println("Prodotto RIFIUTATO: " + prodotto.getNome() + " (Quantità insufficiente)");
            return;
        }
        if (prodotto.getNome() == null || prodotto.getNome().trim().isEmpty()) {
            System.out.println("Prodotto RIFIUTATO: Nome non valido");
            return;
        }
        if (prodotto.getDescrizione() == null || prodotto.getDescrizione().trim().length() < 5) {
            System.out.println("Prodotto RIFIUTATO: " + prodotto.getNome() + " (Descrizione troppo breve)");
            return;
        }

        prodotto.approvaProdotto();
        System.out.println("Prodotto APPROVATO: " + prodotto.getNome());
    }

    // Approva un pacchetto solo se è valido
    public void valutaPacchetto(Pacchetto pacchetto) {
        if (pacchetto.getProdotti().isEmpty()) {
            System.out.println("Pacchetto RIFIUTATO: " + pacchetto.getNome() + " (Non contiene prodotti)");
            return;
        }

        if (pacchetto.getQuantitaDisponibile() <= 0) {
            System.out.println("Pacchetto RIFIUTATO: " + pacchetto.getNome() + " (Quantità insufficiente)");
            return;
        }

        for (Prodotto prodotto : pacchetto.getProdotti()) {
            if (!prodotto.isStato()) {
                System.out.println("Pacchetto RIFIUTATO: " + pacchetto.getNome() + " (Contiene prodotti non approvati)");
                return;
            }
        }

        pacchetto.approvaPacchetto();
        System.out.println("Pacchetto APPROVATO: " + pacchetto.getNome());
    }



    @Override
    public void mostraDettagli() {
        System.out.println("Curatore: " + getNome() + " " + getCognome() +
                " | Username: " + getUsername() +
                " | Ruolo: " + getRuolo());
    }
}
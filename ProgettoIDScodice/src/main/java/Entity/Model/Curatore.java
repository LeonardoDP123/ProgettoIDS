package Entity.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Curatore extends UtenteGenerico {
    private final Marketplace marketplace;
    private final List<Articolo> articoliDaValutare;

    public Curatore(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
                    String numeroDiTelefono, String indirizzo) {
        super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo, Ruolo.CURATORE);
        this.marketplace = Marketplace.getInstance();
        this.articoliDaValutare = new ArrayList<>();
    }

    public void aggiungiArticoloDaValutare(Articolo articolo) {
        articoliDaValutare.add(articolo);
        System.out.println("Articolo aggiunto alla lista da valutare: " + articolo.getNome());
    }

    public void approvaArticoli() {
        System.out.println("Inizio valutazione degli articoli...");

        for (Articolo articolo : articoliDaValutare) {
            valutaArticolo(articolo);
        }

        articoliDaValutare.clear();
        System.out.println("Valutazione completata e lista svuotata.");
    }

    private void valutaArticolo(Articolo articolo) {
        if (articolo.getQuantitaDisponibile() <= 0) {
            System.out.println("Articolo RIFIUTATO: " + articolo.getNome() + " (Quantità insufficiente)");
            return;
        }
        if (articolo.getNome() == null || articolo.getNome().trim().isEmpty()) {
            System.out.println("Articolo RIFIUTATO: Nome non valido");
            return;
        }
        if (articolo.getDescrizione() == null || articolo.getDescrizione().trim().length() < 5) {
            System.out.println("Articolo RIFIUTATO: " + articolo.getNome() + " (Descrizione troppo breve)");
            return;
        }

        if (articolo instanceof Pacchetto pacchetto) {
            if (!pacchetto.isCompletato()) {
                System.out.println("Pacchetto RIFIUTATO: " + pacchetto.getNome() + " (Non completato)");
                return;
            }

            if (pacchetto.getProdotti().isEmpty()) {
                System.out.println("Pacchetto RIFIUTATO: " + pacchetto.getNome() + " (Non contiene articoli)");
                return;
            }

            for (Articolo a : pacchetto.getProdotti()) {
                if (!a.isStato()) {
                    System.out.println("Pacchetto RIFIUTATO: " + pacchetto.getNome() + " (Contiene articoli non approvati)");
                    return;
                }
            }
        }

        articolo.approvaArticolo();
        marketplace.aggiungiArticolo(articolo);
        System.out.println("Articolo APPROVATO e aggiunto al marketplace: " + articolo.getNome());
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Curatore: " + getNome() + " " + getCognome() +
                " | Username: " + getUsername());
    }
}
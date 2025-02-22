package Entity.Model;

import java.time.LocalDate;

public class Curatore {
    private int ID;
    private String username;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private String numeroDiTelefono;
    private String indirizzo;
    private Marketplace marketplace;

    public Curatore(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
                    String numeroDiTelefono, String indirizzo, Marketplace marketplace) {
        this.ID = ID;
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroDiTelefono = numeroDiTelefono;
        this.indirizzo = indirizzo;
        this.marketplace = marketplace;
    }

    public void valutaArticolo(Articolo articolo) {
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

        // Controllo specifico per Pacchetto
        if (articolo instanceof Pacchetto) {
            Pacchetto pacchetto = (Pacchetto) articolo;

            // Verifica se il pacchetto è completato
            if (!pacchetto.isCompletato()) {
                System.out.println("Pacchetto RIFIUTATO: " + pacchetto.getNome() + " (Il pacchetto non è ancora completato)");
                return;
            }

            // Verifica se il pacchetto ha prodotti e che tutti siano approvati
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

        // Se tutti i controlli sono superati, il curatore approva l'articolo
        articolo.approvaArticolo();
        marketplace.aggiungiArticolo(articolo);
        System.out.println("Articolo APPROVATO e aggiunto al marketplace: " + articolo.getNome());
    }
}

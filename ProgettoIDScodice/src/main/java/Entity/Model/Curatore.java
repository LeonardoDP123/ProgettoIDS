package Entity.Model;

import Entity.Controller.Ruolo;
import java.time.LocalDate;


public class Curatore {
    private int ID;
    private String username;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private String numeroDiTelefono;
    private String indirizzo;

    public Curatore(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
                    String numeroDiTelefono, String indirizzo) {
        this.ID = ID;
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroDiTelefono = numeroDiTelefono;
        this.indirizzo = indirizzo;
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

        // Se l'articolo è un pacchetto, controlliamo il contenuto
        if (articolo instanceof Pacchetto) {
            Pacchetto pacchetto = (Pacchetto) articolo;
            if (pacchetto.getPacchetti().isEmpty()) {
                System.out.println("Pacchetto RIFIUTATO: " + pacchetto.getNome() + " (Non contiene articoli)");
                return;
            }
            for (Articolo a : pacchetto.getPacchetti()) {
                if (!a.isStato()) {
                    System.out.println("Pacchetto RIFIUTATO: " + pacchetto.getNome() + " (Contiene articoli non approvati)");
                    return;
                }
            }
        }

        articolo.approvaArticolo();
        System.out.println("Articolo APPROVATO: " + articolo.getNome());
    }
}
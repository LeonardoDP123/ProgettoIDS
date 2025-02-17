package Entity.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trasformatore extends Venditore {
    private String tipologia;
    private String processo;
    private List<Prodotto> prodottiCaricati;
    private boolean listaCreata;

    public Trasformatore(int ID, String username, String nome, String cognome,
                         LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
        super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo);
        this.prodottiCaricati = new ArrayList<>();
        this.listaCreata = false;
    }

    public void visualizzaInfoVenditore() {
        System.out.println("Trasformatore: " + getNome() + " " + getCognome());
        System.out.println("Tipologia: " + tipologia);
        System.out.println("Processo di trasformazione: " + processo);
        System.out.println("Prodotti caricati: " + prodottiCaricati.size());
    }

    public void aggiornaInfoVenditore(String tipologia, String processo) {
        this.tipologia = tipologia;
        this.processo = processo;
        System.out.println("Informazioni aggiornate per " + getNome());
    }

    public void mostraProdottiCaricati() {
        if (prodottiCaricati.isEmpty()) {
            System.out.println("Nessun prodotto trasformato disponibile.");
        } else {
            prodottiCaricati.forEach(System.out::println);
        }
    }

    @Override
    public void mostraDettagli() {
        super.mostraDettagli();
        System.out.println("Ruolo: Trasformatore | Prodotti trasformati: " + prodottiCaricati.size());
    }
}
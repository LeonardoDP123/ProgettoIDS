package Entity.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trasformatore extends Venditore {
    private String tipologia;
    private String processo;
    private List<Prodotto> prodottiCaricati;  // Prodotti ricevuti dal produttore
    private List<Prodotto> prodottiTrasformati; // Prodotti trasformati
    private boolean listaCreata;

    public Trasformatore(int ID, String username, String nome, String cognome,
                         LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
        super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo);
        this.prodottiCaricati = new ArrayList<>();
        this.prodottiTrasformati = new ArrayList<>();
        this.listaCreata = false;
    }

    // Metodo per ricevere prodotti dal Produttore
    public void riceviProdotto(Prodotto prodotto) {
        prodottiCaricati.add(prodotto);
        System.out.println("Prodotto ricevuto dal Produttore: " + prodotto.getNome());
    }

    // Metodo per trasformare un prodotto ricevuto
    public Prodotto trasformaProdotto(int prodottoID, double nuovoPrezzo) {
        Prodotto prodottoBase = trovaProdotto(prodottoID);
        if (prodottoBase == null) {
            System.out.println("Il prodotto non esiste o non è stato ricevuto.");
            return null;
        }

        StrategiaTrasformazione strategia = GestoreStrategie.getStrategia(prodottoBase.getCategoria());
        if (strategia != null) {
            Prodotto prodottoTrasformato = strategia.trasforma(prodottoBase, nuovoPrezzo);
            prodottiCaricati.remove(prodottoBase); // Rimuoviamo il prodotto originale
            prodottiTrasformati.add(prodottoTrasformato);
            System.out.println("Prodotto trasformato: " + prodottoTrasformato.getNome());
            return prodottoTrasformato;
        } else {
            System.out.println("Nessuna strategia di trasformazione disponibile per la categoria: " + prodottoBase.getCategoria());
            return null;
        }
    }

    // Metodo per inviare SOLO i prodotti trasformati al Curatore
    @Override
    public void inviaProdottoAlCuratore(Curatore curatore) {
        System.out.println("Il Trasformatore sta inviando prodotti trasformati al Curatore...");
        for (Prodotto p : prodottiTrasformati) {
            if (!p.isStato()) { // Solo i prodotti non ancora approvati vengono inviati
                curatore.valutaProdotto(p);
            }
        }
    }

    // Trova un prodotto per ID tra i prodotti ricevuti
    private Prodotto trovaProdotto(int ID) {
        for (Prodotto p : prodottiCaricati) {
            if (p.getID() == ID) return p;
        }
        return null;
    }

    // Metodi originali della tua classe

    public void visualizzaInfoVenditore() {
        System.out.println("Trasformatore: " + getNome() + " " + getCognome());
        System.out.println("Tipologia: " + tipologia);
        System.out.println("Processo di trasformazione: " + processo);
        System.out.println("Prodotti caricati: " + prodottiCaricati.size());
        System.out.println("Prodotti trasformati: " + prodottiTrasformati.size());
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

    public void mostraProdottiTrasformati() {
        if (prodottiTrasformati.isEmpty()) {
            System.out.println("Nessun prodotto trasformato disponibile.");
        } else {
            prodottiTrasformati.forEach(System.out::println);
        }
    }

    @Override
    public void mostraDettagli() {
        super.mostraDettagli();
        System.out.println("Ruolo: Trasformatore | Prodotti caricati: " + prodottiCaricati.size() +
                " | Prodotti trasformati: " + prodottiTrasformati.size());
    }
}
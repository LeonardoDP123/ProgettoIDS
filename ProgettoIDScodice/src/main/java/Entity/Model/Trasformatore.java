package Entity.Model;

import Entity.Controller.*;
import java.time.LocalDate;
import java.util.*;

public class Trasformatore extends Venditore {
    private Map<Categoria, StrategiaTrasformazione> strategieTrasformazione;
    private List<Prodotto> prodottiCaricati;

    public Trasformatore(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
                         String numeroDiTelefono, String indirizzo) {
        super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo, Ruolo.TRASFORMATORE);
        this.strategieTrasformazione = new HashMap<>();
        this.prodottiCaricati = new ArrayList<>();
    }


    public void riceviProdotto(Prodotto prodotto) {
        prodottiCaricati.add(prodotto);
        System.out.println("Prodotto ricevuto: " + prodotto.getNome());
    }

    public Prodotto trasformaProdotto(int prodottoID, double nuovoPrezzo) {
        Prodotto prodottoBase = trovaProdotto(prodottoID);
        if (prodottoBase == null) {
            System.out.println("Errore: Il prodotto non esiste o non è stato ricevuto.");
            return null;
        }

        Prodotto prodottoTrasformato = null;

        switch (prodottoBase.getCategoria()) {
            case LATTICINI:
                prodottoTrasformato = new TrasformaLatteInFormaggio().trasforma(prodottoBase, nuovoPrezzo);
                break;
            // Puoi aggiungere altri case per altre categorie in futuro
            default:
                System.out.println("Errore: Nessuna strategia disponibile per la categoria: " + prodottoBase.getCategoria());
                return null;
        }

        prodottiCaricati.remove(prodottoBase);
        aggiungiArticolo(prodottoTrasformato);
        System.out.println("Prodotto trasformato: " + prodottoTrasformato.getNome());

        return prodottoTrasformato;
    }

    private Prodotto trovaProdotto(int ID) {
        for (Prodotto p : prodottiCaricati) {
            if (p.getID() == ID) return p;
        }
        return null;
    }

    public void mostraProdottiCaricati() {
        if (prodottiCaricati.isEmpty()) {
            System.out.println("Nessun prodotto caricato disponibile.");
        } else {
            prodottiCaricati.forEach(System.out::println);
        }
    }

    public void mostraProdottiTrasformati() {
        if (getArticoli().isEmpty()) {
            System.out.println("Nessun prodotto trasformato disponibile.");
        } else {
            getArticoli().forEach(System.out::println);
        }
    }
}

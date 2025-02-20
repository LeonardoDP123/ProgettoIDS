package Entity.Model;

import Entity.Controller.Categoria;
import Entity.Controller.StrategiaTrasformazione;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trasformatore extends Venditore {
    private Map<Categoria, StrategiaTrasformazione> strategieTrasformazione;
    private List<Prodotto> prodottiCaricati;
    private List<Prodotto> prodottiTrasformati;

    public Trasformatore(int ID, String username, String nome, String cognome,
                         LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
        super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo);
        this.prodottiCaricati = new ArrayList<>();
        this.prodottiTrasformati = new ArrayList<>();
        this.strategieTrasformazione = new HashMap<>();
    }

    public void registraStrategia(Categoria categoria, StrategiaTrasformazione strategia) {
        strategieTrasformazione.put(categoria, strategia);
    }

    public void riceviProdotto(Prodotto prodotto) {
        prodottiCaricati.add(prodotto);
        System.out.println("Prodotto ricevuto dal Produttore: " + prodotto.getNome());
    }

    public Prodotto trasformaProdotto(int prodottoID, double nuovoPrezzo) {
        Prodotto prodotto = trovaProdotto(prodottoID);
        if (prodotto == null) {
            System.out.println("Il prodotto non esiste o non è stato ricevuto.");
            return null;
        }

        StrategiaTrasformazione strategia = strategieTrasformazione.get(prodotto.getCategoria());
        if (strategia != null) {
            Prodotto prodottoTrasformato = strategia.trasforma(prodotto, nuovoPrezzo);
            prodottiCaricati.remove(prodotto);
            prodottiTrasformati.add(prodottoTrasformato);
            System.out.println("Prodotto trasformato: " + prodottoTrasformato.getNome());
            return prodottoTrasformato;
        } else {
            System.out.println("Nessuna strategia di trasformazione disponibile per la categoria: " + prodotto.getCategoria());
            return null;
        }
    }

    public void inviaProdottoAlCuratore(Curatore curatore) {
        System.out.println("Il Trasformatore sta inviando prodotti trasformati al Curatore...");
        for (Prodotto p : prodottiTrasformati) {
            if (!p.isStato()) {
                curatore.valutaArticolo(p);
            }
        }
    }

    private Prodotto trovaProdotto(int ID) {
        for (Prodotto p : prodottiCaricati) {
            if (p.getID() == ID) return p;
        }
        return null;
    }



}


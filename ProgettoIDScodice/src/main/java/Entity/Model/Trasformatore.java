package Entity.Model;

import java.time.LocalDate;
import java.util.*;

public class Trasformatore extends Venditore {
    private Map<Categoria, StrategiaTrasformazione> strategieTrasformazione;
    private List<Prodotto> prodottiCaricati; //lista dei prodotti inviati dal produttore

    public Trasformatore(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
                         String numeroDiTelefono, String indirizzo) {
        super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo, Ruolo.TRASFORMATORE);
        this.prodottiCaricati = new ArrayList<>();

        this.strategieTrasformazione = new HashMap<>();
        this.strategieTrasformazione.put(Categoria.LATTE, new TrasformaLatteInFormaggio());
        this.strategieTrasformazione.put(Categoria.FRUTTA, new TrasformaFruttaInSucco());
        this.strategieTrasformazione.put(Categoria.VERDURA, new TrasformaVerduraInSottoOlio());
        this.strategieTrasformazione.put(Categoria.CARNE, new TrasformaCarneInEssiccati());
        this.strategieTrasformazione.put(Categoria.PESCE, new TrasformaPesceInAffumicati());
        this.strategieTrasformazione.put(Categoria.CEREALI, new TrasformaCerealiInFarine());
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

        StrategiaTrasformazione strategia = strategieTrasformazione.get(prodottoBase.getCategoria());

        if (strategia == null) {
            System.out.println("Errore: Nessuna strategia disponibile per la categoria: " + prodottoBase.getCategoria());
            return null;
        }

        Prodotto prodottoTrasformato = strategia.trasforma(prodottoBase, nuovoPrezzo);

        if (prodottoTrasformato == null) {
            System.out.println("Errore durante la trasformazione.");
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

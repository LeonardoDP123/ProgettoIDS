package Entity.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trasformatore extends Venditore {
    private Map<Categoria, StrategiaTrasformazione> strategieTrasformazione;
    private List<Prodotto> prodottiCaricati;

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
        System.out.println("Prodotto ricevuto per trasformazione: " + prodotto.getNome());
    }

    public Prodotto trasformaProdotto(int prodottoID, double nuovoPrezzo) {
        Prodotto prodottoBase = trovaProdotto(prodottoID);
        if (prodottoBase == null) {
            System.out.println("Errore: Il prodotto con ID " + prodottoID + " non esiste o non è stato ricevuto.");
            return null;
        }

        StrategiaTrasformazione strategia = strategieTrasformazione.get(prodottoBase.getCategoria());
        if (strategia == null) {
            System.out.println("Errore: Nessuna strategia di trasformazione per la categoria " + prodottoBase.getCategoria());
            return null;
        }

        Prodotto prodottoTrasformato = strategia.trasforma(prodottoBase, nuovoPrezzo);
        prodottiCaricati.remove(prodottoBase);
        aggiungiArticolo(prodottoTrasformato);
        System.out.println("Prodotto trasformato con successo: " + prodottoTrasformato.getNome());
        return prodottoTrasformato;
    }

    private Prodotto trovaProdotto(int ID) {
        for (Prodotto p : prodottiCaricati) {
            if (p.getID() == ID) return p;
        }
        return null;
    }

    // Usa direttamente il metodo aggiornato di Venditore
    @Override
    public void inviaArticoliAlCuratore(Curatore curatore) {
        super.inviaArticoliAlCuratore(curatore);
    }

    // Metodo per rimuovere un articolo già approvato dal Marketplace
    @Override
    public void rimuoviArticoloDaMarketplace(int ID) {
        super.rimuoviArticoloDaMarketplace(ID);
    }
}
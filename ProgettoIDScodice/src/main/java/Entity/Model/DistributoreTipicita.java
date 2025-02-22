package Entity.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DistributoreTipicita extends Venditore {
    private List<Prodotto> prodottiCaricati;

    public DistributoreTipicita(int ID, String username, String nome, String cognome,
                                LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
        super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo, Ruolo.DISTRIBUTORE_TIPICITA);
        this.prodottiCaricati = new ArrayList<>();
    }

    public void riceviProdottoDaProduttore(Prodotto prodotto) {
        if (prodotto != null) {
            prodottiCaricati.add(prodotto);
            System.out.println("Prodotto ricevuto: " + prodotto.getNome() + " | Totale prodotti: " + prodottiCaricati.size());
        } else {
            System.out.println("Errore: Prodotto nullo ricevuto.");
        }
    }

    public Pacchetto creaPacchetto(int ID, String nome, String descrizione, int quantitaDisponibile) {
        Pacchetto pacchetto = new Pacchetto(ID, nome, descrizione, quantitaDisponibile);
        pacchetto.setCompletato(false);
        aggiungiArticolo(pacchetto);
        System.out.println("Pacchetto creato: " + pacchetto.getNome());
        return pacchetto;
    }

    public void aggiungiProdottoAlPacchetto(Pacchetto pacchetto, Prodotto prodotto) {
        if (pacchetto.isCompletato()) {
            System.out.println("Errore: Il pacchetto " + pacchetto.getNome() + " è completato e non può essere modificato.");
            return;
        }

        if (!prodottiCaricati.contains(prodotto)) {
            System.out.println("Errore: Il prodotto " + prodotto.getNome() + " non è disponibile nel distributore.");
            return;
        }

        pacchetto.getProdotti().add(prodotto);
        prodottiCaricati.remove(prodotto);
        System.out.println("Aggiunto al pacchetto: " + prodotto.getNome() + " | Prodotti nel pacchetto: " + pacchetto.getProdotti().size());
    }

    public void completaPacchetto(Pacchetto pacchetto, double prezzo) {
        if (pacchetto.getProdotti().isEmpty()) {
            System.out.println("Errore: Il pacchetto " + pacchetto.getNome() + " è vuoto!");
            return;
        }

        pacchetto.setCompletato(true);
        pacchetto.setPrezzo(prezzo);
        System.out.println("Pacchetto completato: " + pacchetto.getNome() + " con " + pacchetto.getProdotti().size() + " prodotti.");
    }

    public void mostraProdottiCaricati() {
        if (prodottiCaricati.isEmpty()) {
            System.out.println("Nessun prodotto caricato disponibile.");
        } else {
            for (Prodotto prodotto : prodottiCaricati) {
                System.out.println(prodotto);
            }
        }
    }

    public void mostraPacchetti() {
        boolean hasPacchetti = false;
        for (Articolo articolo : getArticoli()) {
            if (articolo instanceof Pacchetto) {
                System.out.println(articolo);
                hasPacchetti = true;
            }
        }
        if (!hasPacchetti) {
            System.out.println("Nessun pacchetto disponibile.");
        }
    }

    @Override
    public void inviaArticoliAlCuratore(Curatore curatore) {
        super.inviaArticoliAlCuratore(curatore);
    }


    @Override
    public void rimuoviArticoloDaMarketplace(int ID) {
        super.rimuoviArticoloDaMarketplace(ID);
    }
}
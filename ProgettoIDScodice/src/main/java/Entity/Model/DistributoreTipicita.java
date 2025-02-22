package Entity.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DistributoreTipicita extends Venditore {
    private List<Prodotto> prodottiCaricati; //lista dei prodotti inviati dal produttore

    public DistributoreTipicita(int ID, String username, String nome, String cognome,
                                LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
        super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo, Ruolo.DISTRIBUTORE_TIPICITA);
        this.prodottiCaricati = new ArrayList<>();
    }

    public void riceviProdottoDaProduttore(Prodotto prodotto) {
        prodottiCaricati.add(prodotto);
        System.out.println("Prodotto ricevuto dal produttore: " + prodotto.getNome());
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
            System.out.println("Errore: Il prodotto " + prodotto.getNome() + " non è stato caricato nel distributore.");
            return;
        }

        pacchetto.getProdotti().add(prodotto);
        prodottiCaricati.remove(prodotto);
        System.out.println("Prodotto " + prodotto.getNome() + " aggiunto al pacchetto " + pacchetto.getNome());
    }

    public void completaPacchetto(Pacchetto pacchetto, double prezzo) {
        if (getArticoli().contains(pacchetto)) {
            pacchetto.setCompletato(true);
            pacchetto.setPrezzo(prezzo);
            System.out.println("Pacchetto completato: " + pacchetto.getNome() + " con prezzo: " + prezzo);
        } else {
            System.out.println("Errore");
        }
    }

    @Override
    public void inviaArticoloAlCuratore(Curatore curatore) {
        for (Articolo a : getArticoli()) {
            if (a instanceof Pacchetto) {
                Pacchetto p = (Pacchetto) a;
                if (p.isCompletato() && !p.isStato()) {
                    curatore.valutaArticolo(p);
                }
            }
        }
    }

    public void mostraProdottiCaricati() {
        if (prodottiCaricati.isEmpty()) {
            System.out.println("Nessun prodotto caricato disponibile.");
        } else {
            prodottiCaricati.forEach(System.out::println);
        }
    }

    public void mostraPacchetti() {
        boolean hasPacchetti = false;
        for (Articolo a : getArticoli()) {
            if (a instanceof Pacchetto) {
                System.out.println(a);
                hasPacchetti = true;
            }
        }
        if (!hasPacchetti) {
            System.out.println("Nessun pacchetto disponibile.");
        }
    }
}


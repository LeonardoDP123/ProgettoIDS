package Entity.Model;

import Entity.Controller.Categoria;
import Entity.Controller.Certificazione;
import Entity.Controller.MetodoColtivazione;
import Entity.Controller.Ruolo;
import java.time.LocalDate;

public class Produttore extends Venditore {

	public Produttore(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
					  String numeroDiTelefono, String indirizzo) {
		super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo, Ruolo.PRODUTTORE);
	}

	public Prodotto creaProdotto(int ID, String nome, String descrizione, double prezzo, Categoria categoria,
								 int quantitaDisponibile, MetodoColtivazione metodoColtivazione, Certificazione certificazione) {
		Prodotto nuovoProdotto = new Prodotto(ID, nome, descrizione, prezzo, categoria, quantitaDisponibile, metodoColtivazione, certificazione);
		aggiungiArticolo(nuovoProdotto);
		System.out.println("Prodotto creato: " + nuovoProdotto.getNome() +
				" | Metodo Coltivazione: " + metodoColtivazione +
				" | Certificazione: " + certificazione);
		return nuovoProdotto;
	}

public void inviaProdottoAlTrasformatore(Trasformatore trasformatore, Prodotto prodotto) {
		if (!getArticoli().contains(prodotto)) {
			System.out.println("Errore: Il prodotto non appartiene al produttore.");
			return;
		}
		if (prodotto instanceof Prodotto) {
			rimuoviArticolo(prodotto);
			trasformatore.riceviProdotto(prodotto);
			System.out.println("Prodotto inviato al trasformatore: " + prodotto.getNome());
		} else {
			System.out.println("Errore: Solo i prodotti possono essere inviati al trasformatore.");
		}
	}
}
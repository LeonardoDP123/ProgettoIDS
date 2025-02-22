package Entity.Model;

import java.time.LocalDate;

public class Produttore extends Venditore {

	public Produttore(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
					  String numeroDiTelefono, String indirizzo) {
		super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo, Ruolo.PRODUTTORE);
	}

	public Prodotto creaProdotto(int ID, String nome, String descrizione, double prezzo, Categoria categoria,
								 int quantitaDisponibile, MetodoColtivazione metodoColtivazione, Certificazione certificazione) {

		if (!Categoria.isPrimaryCategory(categoria)) {
			System.out.println("Errore: Il produttore può creare solo prodotti di categorie primarie. Categoria non valida: " + categoria);
			return null;
		}

		Prodotto nuovoProdotto = new Prodotto(ID, nome, descrizione, prezzo, categoria, quantitaDisponibile, metodoColtivazione, certificazione);
		aggiungiArticolo(nuovoProdotto);
		System.out.println("Prodotto creato: " + nuovoProdotto.getNome() +
				" | Metodo Coltivazione: " + metodoColtivazione +
				" | Certificazione: " + certificazione);
		return nuovoProdotto;
	}

	public void inviaProdottoAlTrasformatore(Trasformatore trasformatore, int prodottoID) {
		Prodotto prodotto = trovaProdotto(prodottoID);
		if (prodotto == null) {
			System.out.println("Errore: Il prodotto con ID " + prodottoID + " non appartiene al produttore.");
			return;
		}
		rimuoviArticolo(prodotto);
		trasformatore.riceviProdotto(prodotto);
		System.out.println("Prodotto inviato al trasformatore: " + prodotto.getNome());
	}

	public void inviaProdottoAlDistribuore(DistributoreTipicita distributoretipicita, int prodottoID) {
		Prodotto prodotto = trovaProdotto(prodottoID);
		if (prodotto == null) {
			System.out.println("Errore: Il prodotto con ID " + prodottoID + " non appartiene al produttore.");
			return;
		}
		rimuoviArticolo(prodotto);
		distributoretipicita.riceviProdottoDaProduttore(prodotto);
		System.out.println("Prodotto inviato al distributore: " + prodotto.getNome());
	}

	private Prodotto trovaProdotto(int ID) {
		for (Articolo articolo : getArticoli()) {
			if (articolo instanceof Prodotto && articolo.getID() == ID) {
				return (Prodotto) articolo;
			}
		}
		return null;
	}

	// Utilizza direttamente il metodo di Venditore
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
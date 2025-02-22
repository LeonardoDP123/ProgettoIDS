package Entity.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Venditore extends UtenteGenerico {
	private List<Articolo> articoli;

	public Venditore(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
					 String numeroDiTelefono, String indirizzo, Ruolo ruolo) {
		super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo, ruolo);
		this.articoli = new ArrayList<>();
	}

	public void modificaArticolo(Articolo articolo, String nuovoNome, String nuovaDescrizione, double nuovoPrezzo, int nuovaQuantita) {
		articolo.modificaArticolo(nuovoNome, nuovaDescrizione, nuovoPrezzo, nuovaQuantita);
	}

	public void inviaArticoloAlCuratore(Curatore curatore) {
		Iterator<Articolo> iterator = articoli.iterator();
		while (iterator.hasNext()) {
			Articolo articolo = iterator.next();
			if (!articolo.isStato()) {
				curatore.aggiungiArticoloDaValutare(articolo);
				System.out.println("Articolo inviato al curatore: " + articolo.getNome());
				iterator.remove();  // rimuove articolo dalla lista del venditore dopo l'invio
			}
		}
	}

	public void aggiungiArticolo(Articolo articolo) {
		articoli.add(articolo);
	}

	public void rimuoviArticolo(Articolo articolo) {
		articoli.remove(articolo);
	}

	// Metodo per rimuovere articolo da Marketplace
	public void rimuoviArticoloDaMarketplace(int ID) {
		Marketplace marketplace = Marketplace.getInstance();
		Articolo articolo = marketplace.getArticoloByID(ID);

		if (articolo == null) {
			System.out.println("Errore: Articolo non trovato nel marketplace.");
			return;
		}

		// Verifica se l'articolo appartiene a questo venditore
		if (getArticoli().contains(articolo)) {
			marketplace.rimuoviArticolo(articolo);
			System.out.println("Articolo " + articolo.getNome() + " rimosso dal marketplace.");
		} else {
			System.out.println("Errore: Non hai il permesso di rimuovere questo articolo.");
		}
	}

	public List<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(List<Articolo> articoli) {
		this.articoli = articoli;
	}

	@Override
	public void mostraDettagli() {
		System.out.println("Venditore: " + getNome() + " " + getCognome() +
				" | Username: " + getUsername() +
				" | Ruolo: " + getRuolo());
	}
}
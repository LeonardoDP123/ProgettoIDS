package Entity;

import Util.Enum.ruolo;

import java.util.Date;

public class Acquirente extends UtenteGenerico {

	private int ID;

	public Acquirente(String username, String nome, String cognome, Date dataNascita, String numeroTelefono, ruolo role, String indirizzo) {
		super(username, nome, cognome, dataNascita, numeroTelefono, role, indirizzo);
	}

	public void visualizzaProdotti() {
		// TODO - implement Acquirente.visualizzaProdotti
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param categoria
	 */
	public void visualizzaCategoriaProdotti(String categoria) {
		// TODO - implement Acquirente.visualizzaCategoriaProdotti
		throw new UnsupportedOperationException();
	}

	public void visualizzaInfoAcquirente() {
		// TODO - implement Acquirente.visualizzaInfoAcquirente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attributo
	 * @param nuovoValore
	 */
	public void aggiornaInfoAcquirente(String attributo, Object nuovoValore) {
		// TODO - implement Acquirente.aggiornaInfoAcquirente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param prodotto
	 * @param quantita
	 */
	public void aggiungiProdottoCarrello(Prodotto prodotto, int quantita) {
		// TODO - implement Acquirente.aggiungiProdottoCarrello
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param prodotto
	 */
	public void rimuoviProdottoCarrello(Prodotto prodotto) {
		// TODO - implement Acquirente.rimuoviProdottoCarrello
		throw new UnsupportedOperationException();
	}

	public void effettuaAcquisto() {
		// TODO - implement Acquirente.effettuaAcquisto
		throw new UnsupportedOperationException();
	}

	public void svuotaCarrello() {
		// TODO - implement Acquirente.svuotaCarrello
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param evento
	 */
	public void partecipaEvento(Evento evento) {
		// TODO - implement Acquirente.partecipaEvento
		throw new UnsupportedOperationException();
	}

}
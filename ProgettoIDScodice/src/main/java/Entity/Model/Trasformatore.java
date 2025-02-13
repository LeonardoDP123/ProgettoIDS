package Entity;
import Util.Enum.ruolo;

import java.util.Date;
import java.util.List;

public class Trasformatore extends Venditore {

	private int ID;
	private String tipologia;
	private String processo;
	private List<Prodotto> prodottiCaricati;
	private boolean listaCreata;

	public Trasformatore(String username, String nome, String cognome, Date dataNascita, String numeroTelefono, ruolo role, String indirizzo) {
		super(username, nome, cognome, dataNascita, numeroTelefono, role, indirizzo);
	}

	public void visualizzaInfoVenditore() {
		// TODO - implement Trasformatore.visualizzaInfoVenditore
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attributo
	 * @param nuovoValore
	 */
	public void aggiornaInfoVenditore(String attributo, Object nuovoValore) {
		// TODO - implement Trasformatore.aggiornaInfoVenditore
		throw new UnsupportedOperationException();
	}

	public void mostraProdottiCaricati() {
		// TODO - implement Trasformatore.mostraProdottiCaricati
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param prodotto
	 * @param processoTrasformazione
	 */
	public void effettuaTrasformazione(Prodotto prodotto, ProcessoTrasformazione processoTrasformazione) {
		// TODO - implement Trasformatore.effettuaTrasformazione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param prodotto
	 */
	public void caricaProdottoTrasformato(Prodotto prodotto) {
		// TODO - implement Trasformatore.caricaProdottoTrasformato
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param prodotto
	 */
	public void rimuoviProdottoTrasformato(Prodotto prodotto) {
		// TODO - implement Trasformatore.rimuoviProdottoTrasformato
		throw new UnsupportedOperationException();
	}

}
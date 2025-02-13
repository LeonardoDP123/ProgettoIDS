package Entity;

import java.util.Date;
import java.util.List;
import Util.Enum.*;

public class Produttore extends Venditore {

	private int ID;
	private List<Prodotto> prodottiCaricati;
	private boolean listaCreata;
	private metodoColtivazione metodoC;
	private certificazione cert;

	public Produttore(String username, String nome, String cognome, Date dataNascita, String numeroTelefono, ruolo role, String indirizzo) {
		super(username, nome, cognome, dataNascita, numeroTelefono, role, indirizzo);
	}

	public void visualizzaInfoVenditore() {
		// TODO - implement Produttore.visualizzaInfoVenditore
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attributo
	 * @param nuovoValore
	 */
	public void aggiornaInfoVenditore(String attributo, Object nuovoValore) {
		// TODO - implement Produttore.aggiornaInfoVenditore
		throw new UnsupportedOperationException();
	}

	public void mostraProdottiCaricati() {
		// TODO - implement Produttore.mostraProdottiCaricati
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param prodotto
	 */
	public void caricaProdotto(Prodotto prodotto) {
		// TODO - implement Produttore.caricaProdotto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param prodotto
	 */
	public void rimuoviProdotto(Prodotto prodotto) {
		// TODO - implement Produttore.rimuoviProdotto
		throw new UnsupportedOperationException();
	}

}
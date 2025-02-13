package Entity;

import Util.Enum.ruolo;

import java.util.Date;

public abstract class Venditore extends User {

	private int ID;
	private String ragioneSociale;

	public Venditore(String username, String nome, String cognome, Date dataNascita, String numeroTelefono, ruolo role, String indirizzo) {
		super(username, nome, cognome, dataNascita, numeroTelefono, role, indirizzo);
	}

	public void visualizzaInfoVenditore() {
		// TODO - implement Venditore.visualizzaInfoVenditore
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attributo
	 * @param nuovoValore
	 */

	public void aggiornaInfoVenditore(String attributo, Object nuovoValore) {
		// TODO - implement Venditore.aggiornaInfoVenditore
		throw new UnsupportedOperationException();
	}

	public void mostraProdottiCaricati() {
		// TODO - implement Venditore.mostraProdottiCaricati
		throw new UnsupportedOperationException();
	}

}
package Entity.Model;

import Entity.Controller.Ruolo;

import java.time.LocalDate;

/**
 * Classe astratta per un venditore (Produttore, Trasformatore, DistributoreTipicità).
 */
public abstract class Venditore extends User {
	public Venditore(int id, String username, String nome, String cognome, LocalDate dataDiNascita,
					 String numeroDiTelefono, String indirizzo) {
		super(id, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo, Ruolo.VENDITORE);
	}

	public abstract void aggiungiProdotto();
	public abstract void rimuoviProdotto();
}
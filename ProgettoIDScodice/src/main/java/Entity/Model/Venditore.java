package Entity.Model;

import Entity.Controller.Ruolo;

import java.time.LocalDate;


import java.time.LocalDate;

/**
 * Classe astratta per i venditori (Produttore, Trasformatore, DistributoreTipicità).
 */
public abstract class Venditore extends User {
	public Venditore(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
					 String numeroDiTelefono, String indirizzo) {
		super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo, Ruolo.VENDITORE);
	}


	public abstract void aggiungiProdotto(Prodotto prodotto);
	public abstract void rimuoviProdotto(Prodotto prodotto);


	public void modificaProdotto(Prodotto prodotto, String nuovoNome, String nuovaDescrizione, int nuovaQuantita) {
		prodotto.setNome(nuovoNome);
		prodotto.setDescrizione(nuovaDescrizione);
		prodotto.setQuantitaDisponibile(nuovaQuantita);
		System.out.println("Prodotto modificato: " + prodotto.getNome());
	}

	@Override
	public void mostraDettagli() {
		System.out.println("Venditore: " + getNome() + " " + getCognome() +
				" | Username: " + getUsername() + " | Telefono: " + getNumeroDiTelefono());
	}
}
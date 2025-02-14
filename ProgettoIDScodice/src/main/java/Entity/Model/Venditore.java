package Entity.Model;

import Entity.Controller.Ruolo;

import java.time.LocalDate;

public abstract class Venditore extends User {
	public Venditore(int id, String username, String nome, String cognome, LocalDate dataDiNascita,
					 String numeroDiTelefono, String indirizzo) {
		super(id, username, nome, cognome, dataDiNascita, numeroDiTelefono, Ruolo.VENDITORE, indirizzo);
	}

	// Metodi astratti da implementare nelle sottoclassi
	public abstract void aggiungiProdotto(Prodotto prodotto);
	public abstract void rimuoviProdotto(Prodotto prodotto);
	public abstract void modificaProdotto(Prodotto prodotto, String nuovoNome, String nuovaDescrizione, int nuovaQuantita);

	@Override
	public void mostraDettagli() {
		System.out.println("Venditore: " + getNome() + " " + getCognome() + " | Username: " + getUsername() + " | Telefono: " + getNumeroDiTelefono());
	}
}
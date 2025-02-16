package Entity.Model;


import Entity.Controller.Ruolo;

import java.time.LocalDate;

public abstract class Venditore extends User {
	public Venditore(int id, String username, String nome, String cognome, LocalDate dataDiNascita,
					 String numeroDiTelefono, String indirizzo) {
		super(id, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo, Ruolo.VENDITORE);
	}

	// Metodo concreto: Tutti i venditori possono modificare prodotti se lo desiderano
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


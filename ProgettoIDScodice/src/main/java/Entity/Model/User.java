package Entity.Model;


import Entity.Controller.*;

import java.time.LocalDate;

/**
 * Classe astratta per un utente generico.
 */
public abstract class User {
	private int ID;
	private String username;
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	private String numeroDiTelefono;
	private String indirizzo;
	private Ruolo ruolo; //

	public User(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
				String numeroDiTelefono, String indirizzo, Ruolo ruolo) {
		this.ID = ID;
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.numeroDiTelefono = numeroDiTelefono;
		this.indirizzo = indirizzo;
		this.ruolo = ruolo;
	}

	public abstract void mostraDettagli();

	public void visualizzaArticoli(Marketplace marketplace) {
		ArticoloIterator iterator = marketplace.getIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	// Getter
	public int getID() { return ID; }
	public String getUsername() { return username; }
	public String getNome() { return nome; }
	public String getCognome() { return cognome; }
	public LocalDate getDataDiNascita() { return dataDiNascita; }
	public String getNumeroDiTelefono() { return numeroDiTelefono; }
	public String getIndirizzo() { return indirizzo; }
	public Ruolo getRuolo() { return ruolo; }

	// Setter
	public void setRuolo(Ruolo ruolo) { this.ruolo = ruolo; }
}
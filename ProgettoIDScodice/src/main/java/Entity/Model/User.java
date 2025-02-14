package Entity.Model;

import java.time.LocalDate;

import Entity.Controller.Ruolo;

public abstract class User {
	private int ID;
	private String username;
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	private String numeroDiTelefono;
	private Ruolo ruolo;
	private String indirizzo;

	public User(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
				String numeroDiTelefono, Ruolo ruolo, String indirizzo) {
		this.ID = ID;
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.numeroDiTelefono = numeroDiTelefono;
		this.ruolo = ruolo;
		this.indirizzo = indirizzo;
	}

	// Getter e Setter
	public int getID() { return ID; }

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getCognome() { return cognome; }
	public void setCognome(String cognome) { this.cognome = cognome; }

	public LocalDate getDataDiNascita() { return dataDiNascita; }
	public void setDataDiNascita(LocalDate dataDiNascita) { this.dataDiNascita = dataDiNascita; }

	public String getNumeroDiTelefono() { return numeroDiTelefono; }
	public void setNumeroDiTelefono(String numeroDiTelefono) { this.numeroDiTelefono = numeroDiTelefono; }

	public Ruolo getRuolo() { return ruolo; }
	public void setRuolo(Ruolo ruolo) { this.ruolo = ruolo; }

	public String getIndirizzo() { return indirizzo; }
	public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }

	// Metodo astratto che ogni sottoclasse dovrà implementare
	public abstract void mostraDettagli();
}
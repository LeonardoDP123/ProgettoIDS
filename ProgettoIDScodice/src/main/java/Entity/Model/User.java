package Entity;

import Util.Enum.ruolo;
import java.time.LocalDate;


public class User {

	private static int idCounter = 1;
	private final int ID;

	private String username;
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String numeroTelefono;
	private ruolo role;
	private String indirizzo;

	public User(String username,String nome, String cognome, LocalDate dataNascita, String numeroTelefono, ruolo role, String indirizzo) {
		this.ID = idCounter++;
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.numeroTelefono = numeroTelefono;
		if(role==ruolo.Venditore || role == ruolo.Acquirente || role==ruolo.Curatore){
			this.role = role;
		} else throw new IllegalArgumentException("Ruolo non valido");

		this.indirizzo = indirizzo;

	}

	public int getID() {
		return this.ID;
	}


	public String getUsername() {return this.username;}
	public void setUsername(String username) {
		this.username = username;
	}


	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return this.cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return this.dataNascita;
	}
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getNumeroTelefono() {
		return this.numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public ruolo getRole() {
		return this.role;
	}
	public void setRole(ruolo role) {
		if(role==ruolo.Venditore || role==ruolo.Acquirente || role==ruolo.Curatore){
			this.role = role;
		} else throw new IllegalArgumentException("Ruolo non valido");}

	public String getIndirizzo() {
		return this.indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

/*
	public void visualizzaProdotti() {
		// TODO - implement Acquirente.visualizzaProdotti
	throw new UnsupportedOperationException();
	}

*/

}
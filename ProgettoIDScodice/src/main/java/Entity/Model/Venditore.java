
package Entity.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Entity.Controller.Ruolo;
import Entity.Model.Articolo;

public abstract class Venditore {
	private int ID;
	private String username;
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	private String numeroDiTelefono;
	private String indirizzo;
	private Ruolo ruolo;
	private List<Articolo> articoli;

	public Venditore(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
					 String numeroDiTelefono, String indirizzo, Ruolo ruolo) {
		this.ID = ID;
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.numeroDiTelefono = numeroDiTelefono;
		this.indirizzo = indirizzo;
		this.ruolo = ruolo;
		this.articoli = new ArrayList<>();
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void modificaArticolo(Articolo articolo, String nuovoNome, String nuovaDescrizione, double nuovoPrezzo, int nuovaQuantita) {
		articolo.modificaArticolo(nuovoNome, nuovaDescrizione, nuovoPrezzo, nuovaQuantita);
	}

	public void inviaArticoloAlCuratore(Curatore curatore) {
		for (Articolo a : articoli) {
			if (!a.isStato()) {
				curatore.valutaArticolo(a);
			}
		}
	}

	public void aggiungiArticolo(Articolo articolo) {
		articoli.add(articolo);
	}

	public void rimuoviArticolo(Articolo articolo) {
		articoli.remove(articolo);
	}

	public int getID() {
		return ID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getNumeroDiTelefono() {
		return numeroDiTelefono;
	}

	public void setNumeroDiTelefono(String numeroDiTelefono) {
		this.numeroDiTelefono = numeroDiTelefono;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public List<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(List<Articolo> articoli) {
		this.articoli = articoli;
	}
}

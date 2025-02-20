package Entity.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Venditore {
	protected int ID;
	protected String username;
	protected String nome;
	protected String cognome;
	protected LocalDate dataDiNascita;
	protected String numeroDiTelefono;
	protected String indirizzo;
	protected List<Articolo> articoli;

	public Venditore(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
					 String numeroDiTelefono, String indirizzo) {
		this.ID = ID;
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.numeroDiTelefono = numeroDiTelefono;
		this.indirizzo = indirizzo;
		this.articoli = new ArrayList<>();
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
}

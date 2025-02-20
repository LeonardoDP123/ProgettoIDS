package Entity.Model;


import Entity.Controller.Categoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Produttore extends Venditore {
	private List<Prodotto> prodotti;

	public Produttore(int id, String username, String nome, String cognome,
					  LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
		super(id, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo);
		this.prodotti = new ArrayList<>();
	}

	public void aggiungiProdotto(Prodotto prodotto) {
		if (Categoria.isPrimaryCategory(prodotto.getCategoria())) {
			prodotti.add(prodotto);
			System.out.println("Prodotto aggiunto con successo.");
		} else {
			System.out.println("Errore: La categoria " + prodotto.getCategoria() + " non è valida per un produttore.");
		}
	}

	public void rimuoviProdotto(Prodotto prodotto) {
		prodotti.remove(prodotto);
	}

	public void inviaProdottoAlCuratore(Curatore curatore){
		for (Prodotto p : prodotti){
			if (!p.isStato()){curatore.valutaProdotto(p);}
		}
		System.out.println("Prodotto inviato al curatore");
	}

	public void inviaProdottoAlTrasformatore(Trasformatore trasformatore) {
		for (Prodotto p : prodotti) {
			prodotti.add(p);
			trasformatore.riceviProdotto(p);
		}
		System.out.println("Il Produttore sta inviando prodotti al Trasformatore...");
		prodotti.clear();
	}

	public void mostraProdotti() {
		if (prodotti.isEmpty()) {
			System.out.println("Nessun prodotto registrato.");
		} else {
			for (Prodotto p : prodotti) {
				System.out.println(p);
			}
		}
	}

	@Override
	public void modificaProdotto(Prodotto prodotto, String nuovoNome, String nuovaDescrizione, int nuovaQuantita) {
		prodotto.setNome(nuovoNome);
		prodotto.setDescrizione(nuovaDescrizione);
		prodotto.setQuantitaDisponibile(nuovaQuantita);
		System.out.println("Prodotto modificato: " + prodotto.getNome());
	}

	@Override
	public void mostraDettagli() {
		System.out.println("Produttore: " + getNome() + " " + getCognome());
		System.out.println("Prodotti in vendita: " + prodotti.size());
	}
}

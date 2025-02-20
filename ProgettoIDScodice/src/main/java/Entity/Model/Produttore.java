package Entity.Model;



import Entity.Controller.Categoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Produttore extends Venditore {
	private List<Prodotto> prodotti;

	public Produttore(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
					  String numeroDiTelefono, String indirizzo) {
		super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo);
		this.prodotti = new ArrayList<>();
	}

	public Prodotto creaProdotto(int ID, String nome, String descrizione, double prezzo, Categoria categoria, int quantitaDisponibile) {
		Prodotto nuovoProdotto = new Prodotto(ID, nome, descrizione, prezzo, categoria, quantitaDisponibile);
		prodotti.add(nuovoProdotto);
		return nuovoProdotto;
	}
	public void inviaProdottoAlTrasformatore(Trasformatore trasformatore, Prodotto prodotto) {
		if (!prodotti.contains(prodotto)) {
			System.out.println("Errore: Il prodotto non appartiene al produttore.");
			return;
		}
		this.rimuoviArticolo(prodotto);
		trasformatore.riceviProdotto(prodotto);
		System.out.println("Prodotto inviato al trasformatore: " + prodotto.getNome());
	}
}
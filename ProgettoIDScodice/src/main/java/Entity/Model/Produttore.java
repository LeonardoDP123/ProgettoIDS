package Entity.Model;


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
		prodotti.add(prodotto);
	}

	public void rimuoviProdotto(Prodotto prodotto) {
		prodotti.remove(prodotto);
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
	public void mostraDettagli() {
		System.out.println("Produttore: " + getNome() + " " + getCognome());
		System.out.println("Prodotti in vendita: " + prodotti.size());
	}
}

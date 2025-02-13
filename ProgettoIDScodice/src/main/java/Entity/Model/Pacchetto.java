package Entity.Model;
import java.util.List;
import java.util.ArrayList;

public class Pacchetto {
	private int ID;
	private String nome;
	private String descrizione;
	private double prezzoTotale;
	private int quantitaDisponibile;
	private boolean stato; // false di default
	private List<Prodotto> prodotti;

	public Pacchetto(int ID, String nome, String descrizione, double prezzoTotale, int quantitaDisponibile) {
		this.ID = ID;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzoTotale = Math.max(prezzoTotale, 0.0);
		this.quantitaDisponibile = quantitaDisponibile;
		this.prodotti = new ArrayList<>();
		this.stato = false; // Il pacchetto inizia non approvato
	}

	// Metodo per approvare il pacchetto
	public void approvaPacchetto() {
		this.stato = true;
	}

	// Metodo per aggiungere un prodotto al pacchetto
	public void aggiungiProdotto(Prodotto prodotto) {
		if (prodotto.isStato()) { // Permette solo prodotti approvati
			prodotti.add(prodotto);
		} else {
			System.out.println("ERRORE: Il prodotto " + prodotto.getNome() + " NON è approvato e non può essere aggiunto al pacchetto.");
		}
	}

	// Metodo per rimuovere un prodotto dal pacchetto
	public void rimuoviProdotto(Prodotto prodotto) {
		if (prodotti.contains(prodotto)) {
			prodotti.remove(prodotto);
			System.out.println("Il prodotto " + prodotto.getNome() + " è stato RIMOSSO dal pacchetto.");
		} else {
			System.out.println("ERRORE: Il prodotto " + prodotto.getNome() + " NON è presente nel pacchetto.");
		}
	}

	// Metodo toString() per una rappresentazione leggibile
	@Override
	public String toString() {
		return "Pacchetto{" +
				"id=" + ID +
				", nome='" + nome + '\'' +
				", descrizione='" + descrizione + '\'' +
				", prezzoTotale=" + prezzoTotale + "€" +
				", quantitaDisponibile=" + quantitaDisponibile +
				", stato=" + (stato ? "APPROVATO" : "NON APPROVATO") +
				", prodotti=" + prodotti.size() +
				'}';
	}

	// Getter e Setter
	public int getId() { return ID; }
	public String getNome() { return nome; }
	public String getDescrizione() { return descrizione; }
	public List<Prodotto> getProdotti() { return prodotti; }
	public boolean isStato() { return stato; }
	public double getPrezzoTotale() { return prezzoTotale; }
	public int getQuantitaDisponibile() { return quantitaDisponibile; }

	public void setPrezzoTotale(double prezzoTotale) { this.prezzoTotale = Math.max(prezzoTotale, 0.0); } // Evita prezzi negativi
	public void setQuantitaDisponibile(int quantitaDisponibile) { this.quantitaDisponibile = Math.max(quantitaDisponibile, 0); }
}
package Entity.Model;
import java.util.List;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Pacchetto {
	private int ID;
	private String nome;
	private String descrizione;
	private List<Prodotto> prodotti;
	private double prezzoTotale;
	private int quantitaDisponibile;
	private boolean completato; // Indica se il pacchetto è completato e non può più essere modificato dal Distrbutore
	private boolean stato; // // Indica se il prodotto è stato approvato dal curatore

	public Pacchetto(int ID, String nome, String descrizione) {
		this.ID = ID;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzoTotale = 0.0;
		this.quantitaDisponibile = 0;
		this.prodotti = new ArrayList<>();
		this.completato = false;
		this.stato = false;
	}

	public void aggiungiProdotto(Prodotto prodotto) {
		if (!completato) {
			prodotti.add(prodotto);
			quantitaDisponibile++;
		} else {
			System.out.println("Il pacchetto è già stato completato o approvato e non può essere modificato.");
		}
	}

	public void rimuoviProdotto(Prodotto prodotto) {
		if (!completato) {
			prodotti.remove(prodotto);
			quantitaDisponibile--;
		} else {
			System.out.println("Il pacchetto è già stato completato o approvato e non può essere modificato.");
		}
	}

	public void completaPacchetto(double prezzoTotale) {
		if (!completato) {
			this.prezzoTotale = prezzoTotale;
			this.completato = true;
		} else {
			System.out.println("Il pacchetto è già stato completato o approvato.");
		}
	}

	@Override
	public String toString() {
		return "Pacchetto{" +
				"ID=" + ID +
				", nome='" + nome + '\'' +
				", descrizione='" + descrizione + '\'' +
				", prezzoTotale=" + prezzoTotale +
				", quantitaDisponibile=" + quantitaDisponibile +
				", prodotti=" + prodotti.size() + " articoli" +
				", completato=" + (completato ? "Sì" : "No") +
				", stato=" + (stato ? "Approvato" : "Non Approvato") +
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

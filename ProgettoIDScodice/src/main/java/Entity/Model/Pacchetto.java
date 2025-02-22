package Entity.Model;

import java.util.ArrayList;
import java.util.List;

public class Pacchetto extends Articolo {
	private List<Prodotto> prodotti;
	private boolean completato;

	public Pacchetto(int ID, String nome, String descrizione, int quantitaDisponibile) {
		super(ID, nome, descrizione, 0.0, quantitaDisponibile);
		this.prodotti = new ArrayList<>();
		this.completato = false;
	}

	public boolean isCompletato() {
		return completato;
	}

	public void setCompletato(boolean completato) {
		this.completato = completato;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	@Override
	public String toString() {
		return "Pacchetto{" +
				"ID=" + getID() +
				", nome='" + getNome() + '\'' +
				", descrizione='" + getDescrizione() + '\'' +
				", prezzo=" + getPrezzo() +
				", stato=" + (isStato() ? "Approvato" : "Non approvato") +
				", quantitaDisponibile=" + getQuantitaDisponibile() +
				", completato=" + (completato ? "Si" : "No") +
				", prodotti=" + prodotti.size() +
				'}';
	}
}

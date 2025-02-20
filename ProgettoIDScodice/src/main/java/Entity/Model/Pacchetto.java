package Entity.Model;

import java.util.ArrayList;
import java.util.List;

public class Pacchetto extends Articolo {
	private List<Pacchetto> pacchetti;

	public Pacchetto(int ID, String nome, String descrizione, int quantitaDisponibile) {
		super(ID, nome, descrizione, 0.0, quantitaDisponibile);
		this.pacchetti = new ArrayList<>();
	}

	public void aggiungiPacchetto(Pacchetto pacchetto) {
		pacchetti.add(pacchetto);
		this.prezzo += pacchetto.getPrezzo();
	}

	public List<Pacchetto> getPacchetti() {
		return pacchetti;
	}
}

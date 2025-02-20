package Entity.Model;

import Entity.Controller.Certificazione;
import Entity.Controller.MetodoColtivazione;
import Entity.Controller.Categoria;

public class Prodotto extends Articolo {
	private int ID;
	private String nome;
	private String descrizione;
	private double prezzo;
	private Categoria categoria;
	private MetodoColtivazione metodoColtivazione;
	private Certificazione certificazione;
	private int quantitaDisponibile;
	private boolean stato;

	public Prodotto(int ID, String nome, String descrizione, double prezzo, Categoria categoria, int quantitaDisponibile) {
		this.ID = ID;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.categoria = categoria;
		this.quantitaDisponibile = quantitaDisponibile;
		this.stato = false;
	}

	public Prodotto(int ID, String nome, String descrizione, double prezzo, Categoria categoria, int quantitaDisponibile, MetodoColtivazione metodoColtivazione, Certificazione certificazione) {
		this(ID, nome, descrizione, prezzo, categoria, quantitaDisponibile);
		this.metodoColtivazione = metodoColtivazione;
		this.certificazione = certificazione;
	}

	public boolean isDisponibile() { return this.quantitaDisponibile > 0; }
	public void approvaProdotto() { this.stato = true; }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getID() { return ID; }

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public MetodoColtivazione getMetodoColtivazione() {
		return metodoColtivazione;
	}

	public void setMetodoColtivazione(MetodoColtivazione metodoColtivazione) {
		this.metodoColtivazione = metodoColtivazione;
	}

	public Certificazione getCertificazione() {
		return certificazione;
	}

	public void setCertificazione(Certificazione certificazione) {
		this.certificazione = certificazione;
	}

	public int getQuantitaDisponibile() {
		return quantitaDisponibile;
	}

	public void setQuantitaDisponibile(int quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	}

	public boolean isStato() {
		return stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Prodotto{" +
				"ID=" + ID +
				", nome='" + nome + '\'' +
				", descrizione='" + descrizione + '\'' +
				", prezzo=" + prezzo +
				", categoria=" + categoria +
				", quantitaDisponibile=" + quantitaDisponibile +
				", metodoColtivazione=" + (metodoColtivazione != null ? metodoColtivazione : "Nessuno") +
				", certificazione=" + (certificazione != null ? certificazione : "Nessuna") +
				", stato=" + (stato ? "Approvato" : "Non Approvato") +
				'}';
	}
}

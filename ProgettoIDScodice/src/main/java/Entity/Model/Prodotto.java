package Entity.Model;


import Entity.Controller.Certificazione;
import Entity.Controller.MetodoColtivazione;

public class Prodotto {
	private int id;
	private String nome;
	private String descrizione;
	private double prezzo;
	private String categoria;
	private MetodoColtivazione metodoColtivazione;
	private Certificazione certificazione;
	private int quantitaDisponibile;
	private boolean stato; // Indica se il prodotto è stato approvato dal curatore


	public Prodotto(int id, String nome, String descrizione, double prezzo, String categoria, int quantitaDisponibile) {
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.categoria = categoria;
		this.quantitaDisponibile = quantitaDisponibile;
		this.stato = false;
	}

	// 🔹 Costruttore per Produttore con certificazione e metodo di coltivazione
	public Prodotto(int id, String nome, String descrizione, double prezzo, String categoria,
					int quantitaDisponibile, MetodoColtivazione metodoColtivazione, Certificazione certificazione) {
		this(id, nome, descrizione, prezzo, categoria, quantitaDisponibile);
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
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
				"id=" + id +
				", nome='" + nome + '\'' +
				", descrizione='" + descrizione + '\'' +
				", prezzo=" + prezzo +
				", categoria='" + categoria + '\'' +
				", quantitaDisponibile=" + quantitaDisponibile +
				", metodoColtivazione=" + (metodoColtivazione != null ? metodoColtivazione : "Nessuno") +
				", certificazione=" + (certificazione != null ? certificazione : "Nessuna") +
				", stato=" + (stato ? "Approvato" : "Non Approvato") +
				'}';
	}
}

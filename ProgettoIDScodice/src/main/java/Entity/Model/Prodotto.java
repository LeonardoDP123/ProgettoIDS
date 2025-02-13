package Entity.Model;


public class Prodotto {
	private int id;
	private String nome;
	private String descrizione;
	private int quantitaDisponibile;
	private String categoria;
	private boolean stato;

	public Prodotto(int id, String nome, String descrizione, int quantitaDisponibile, String categoria) {
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.quantitaDisponibile = Math.max(quantitaDisponibile, 0); // Evita quantità negative
		this.categoria = categoria;
		this.stato = false;
	}

	// Metodo per verificare se il prodotto è disponibile
	public boolean isDisponibile() {
		return this.quantitaDisponibile > 0;
	}

	public void approvaProdotto() {
		this.stato = true;
	}

	public int getId() {
		return id;
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

	public void setQuantitaDisponibile(int quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isStato() {
		return stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}

	public int getQuantitaDisponibile() { return quantitaDisponibile; }
	public String getNome() { return nome; }
	@Override
	public String toString() {
		return "Prodotto{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", descrizione='" + descrizione + '\'' +
				", quantitaDisponibile=" + quantitaDisponibile +
				", categoria='" + categoria + '\'' +
				", stato=" + (stato ? "APPROVATO" : "NON APPROVATO") +
				'}';
	}
}
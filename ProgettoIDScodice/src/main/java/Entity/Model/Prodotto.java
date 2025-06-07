package Entity.Model;
public class Prodotto extends Articolo {
	private String descrizione;
	private Produttore produttore;
	private MetodoColtivazione metodoColtivazione;
	private Categoria categoria;
	private Certificazione certificazione;

	public Prodotto(String nome, double prezzo, int quantita, String descrizione,
					MetodoColtivazione metodoColtivazione, Categoria categoria,
					Produttore produttore, Certificazione certificazione) {
		super(nome, prezzo, quantita, produttore);
		this.descrizione = descrizione;
		this.produttore = produttore;
		this.metodoColtivazione = metodoColtivazione;
		this.categoria = categoria;
		this.certificazione = certificazione;
	}

	public String getDescrizione() { return descrizione; }
	public Produttore getProduttore() { return produttore; }
	public MetodoColtivazione getMetodoColtivazione() { return metodoColtivazione; }
	public Categoria getCategoria() { return categoria; }
	public Certificazione getCertificazione() { return certificazione; }

	public boolean isCategoriaPrimaria() {
		return Categoria.isPrimaryCategory(categoria);
	}

	@Override
	public String toString() {
		return "ID: " + (ID != null ? ID : "N/A") +
				" | Prodotto: " + nome +
				" | Prezzo: " + prezzo + "€" +
				" | Quantità: " + quantitaDisponibile +
				" | Categoria: " + categoria +
				" | Metodo: " + metodoColtivazione +
				" | Certificazione: " + certificazione +
				" | Descrizione: " + descrizione +
				" | Produttore: " + produttore.getNome();
	}
}
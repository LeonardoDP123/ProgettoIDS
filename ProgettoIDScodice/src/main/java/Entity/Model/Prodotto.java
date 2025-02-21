package Entity.Model;

public class Prodotto extends Articolo {
	private Categoria categoria;
	private MetodoColtivazione metodoColtivazione;
	private Certificazione certificazione;

	public Prodotto(int ID, String nome, String descrizione, double prezzo, Categoria categoria,
					int quantitaDisponibile, MetodoColtivazione metodoColtivazione, Certificazione certificazione) {
		super(ID, nome, descrizione, prezzo, quantitaDisponibile);
		this.categoria = categoria;
		this.metodoColtivazione = metodoColtivazione;
		this.certificazione = certificazione;
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
}

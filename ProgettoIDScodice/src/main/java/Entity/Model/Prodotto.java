package Entity.Model;

import Entity.Controller.Categoria;

public class Prodotto extends Articolo {
	private Categoria categoria;

	public Prodotto(int ID, String nome, String descrizione, double prezzo, Categoria categoria, int quantitaDisponibile) {
		super(ID, nome, descrizione, prezzo, quantitaDisponibile);
		this.categoria = categoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}

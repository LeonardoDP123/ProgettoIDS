package Entity;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class Carrello {

	private int ID;
	private Date dataOrdine;
	private List<Date> storicoOrdini;
	private boolean stato;
	private double totale;
	private Map<Prodotto, Integer> prodottiQuantita;

	public void visualizzaContenutoCarrello() {
		// TODO - implement Carrello.visualizzaContenutoCarrello
		throw new UnsupportedOperationException();
	}

	public void visualizzaTotaleCarello() {
		// TODO - implement Carrello.visualizzaTotaleCarello
		throw new UnsupportedOperationException();
	}

	public void visualizzaStoricoOrdini() {
		// TODO - implement Carrello.visualizzaStoricoOrdini
		throw new UnsupportedOperationException();
	}

}
package Entity;

public class Prodotto {

	private int ID;
	private String nome;
	private String descrizione;
	private double prezzo;
	private int quantitaDisponibile;
	private String categoria;
	private boolean stato;		//inizializzato a false (non approvato), diventa true dal curatore

	public Prodotto(String nome, String descrizione, double prezzo, int quantitaDisponibile,
					String categoria) {
		this.ID = ID;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.quantitaDisponibile = quantitaDisponibile;
		this.categoria = categoria;
		this.stato = false;

	}


	public int getID(){ return this.ID;}
	public String getNome(){ return this.nome;}
	public String getDescrizione(){ return this.descrizione;}
	public double getPrezzo(){ return this.prezzo;}
	public int getQuantitaDisponibile (){ return this.quantitaDisponibile;}
	public String getCategoria(){ return this.categoria;}
	public boolean getStato(){ return this.stato;}


	public void setNome(String nome){ this.nome = nome;}
	public void setDescrizione(String descrizione){ this.descrizione = descrizione;}
	public void setPrezzo(double prezzo){ this.prezzo = prezzo;}
	public void setQuantitaDisponibile(int quantitaDisponibile){
		this.quantitaDisponibile = quantitaDisponibile;
	}
	public void setCategoria(String categoria){
		this.categoria = categoria;
	}

	//set stato non presente, se ne occupa il curatore



	public void isDisponibile() {
		if(this.quantitaDisponibile > 0){
			System.out.println("Disponibile");
		}
	}


	public void visualizzaInfoProdotto() {
		System.out.println("ID: " + this.ID);
		System.out.println("Nome: " + this.nome);
		System.out.println("Descrizione: " + this.descrizione);
		System.out.println("Prezzo: € " + this.prezzo);
		System.out.println("Quantità disponibile: " + this.quantitaDisponibile);
		System.out.println("Categoria: " + this.categoria);
		if(this.stato==true){
			System.out.println("Stato: Approvato");
		} else System.out.println("Stato: Non approvato");
	}

}
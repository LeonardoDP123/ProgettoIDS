package Entity.Model;

public abstract class Articolo {
    protected Integer ID;
    protected String nome;
    protected double prezzo;
    protected int quantitaDisponibile;
    protected Venditore proprietario;

    public Articolo(String nome, double prezzo, int quantitaDisponibile, Venditore proprietario) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantitaDisponibile = quantitaDisponibile;
        this.proprietario = proprietario;
    }

    public Integer getId() { return ID; }
    public void setId(Integer ID) { this.ID = ID; }
    public String getNome() { return nome; }
    public double getPrezzo() { return prezzo; }
    public int getQuantitaDisponibile() { return quantitaDisponibile; }
    public void setQuantitaDisponibile(int q) { this.quantitaDisponibile = q; }
    public Venditore getProprietario() { return proprietario; }
    public void setProprietario(Venditore proprietario) { this.proprietario = proprietario; }

    @Override
    public String toString() {
        return "ID: " + (ID != null ? ID : "N/A") + " | " + nome + " | " + prezzo + "€ | Quantità: " + quantitaDisponibile;
    }
}

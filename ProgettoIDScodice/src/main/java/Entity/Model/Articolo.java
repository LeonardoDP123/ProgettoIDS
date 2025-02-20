package Entity.Model;

public abstract class Articolo {
    protected int ID;
    protected String nome;
    protected String descrizione;
    protected double prezzo;
    protected boolean stato;
    protected int quantitaDisponibile;

    public Articolo(int ID, String nome, String descrizione, double prezzo, int quantitaDisponibile) {
        this.ID = ID;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.stato = false;
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public int getID() { return ID; }
    public String getNome() { return nome; }
    public String getDescrizione() { return descrizione; }
    public double getPrezzo() { return prezzo; }
    public boolean isStato() { return stato; }
    public int getQuantitaDisponibile() { return quantitaDisponibile; }

    public void setNome(String nome) { this.nome = nome; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }
    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }
    public void setStato(boolean stato) { this.stato = stato; }
    public void setQuantitaDisponibile(int quantitaDisponibile) { this.quantitaDisponibile = quantitaDisponibile; }

    public void approvaArticolo() { this.stato = true; }

    public void modificaArticolo(String nome, String descrizione, double prezzo, int quantitaDisponibile) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantitaDisponibile = quantitaDisponibile;
    }

    @Override
    public String toString() {
        return "Articolo{" +
                "ID=" + ID +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo=" + prezzo +
                ", stato=" + (stato ? "Approvato" : "Non Approvato") +
                ", quantitaDisponibile=" + quantitaDisponibile +
                '}';
    }
}


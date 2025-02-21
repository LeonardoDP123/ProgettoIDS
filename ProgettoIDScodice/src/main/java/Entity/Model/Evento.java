package Entity.Model;

import java.time.LocalDate;

public abstract class Evento {
    protected int ID;
    protected String nome;
    protected LocalDate data;
    protected String luogo;
    protected String descrizione;

    public Evento(int ID, String nome, LocalDate data, String luogo, String descrizione) {
        this.ID = ID;
        this.nome = nome;
        this.data = data;
        this.luogo = luogo;
        this.descrizione = descrizione;
    }

    public int getID() { return ID; }
    public String getNome() { return nome; }
    public LocalDate getData() { return data; }
    public String getLuogo() { return luogo; }
    public String getDescrizione() { return descrizione; }

    @Override
    public abstract String toString();
}
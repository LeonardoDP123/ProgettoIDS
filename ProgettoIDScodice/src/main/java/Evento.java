public class Evento {
    private static int contatoreId = 1;

    private int id;
    private String nome;
    private String descrizione;
    private String data;
    private AnimatoreFiliera animatoreFiliera;

    public Evento(String nome, String descrizione, String data, AnimatoreFiliera animatoreFiliera) {
        this.id = contatoreId++;
        this.nome = nome;
        this.descrizione = descrizione;
        this.data = data;
        this.animatoreFiliera = animatoreFiliera;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getData() {
        return data;
    }

    public AnimatoreFiliera getAnimatoreFiliera() {
        return animatoreFiliera;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "ID=" + id +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", data='" + data + '\'' +
                ", animatoreFiliera=" + animatoreFiliera.getNome() +
                '}';
    }
}

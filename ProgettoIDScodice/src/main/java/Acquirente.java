public class Acquirente {
    private String nome;
    private Carrello carrello;

    public Acquirente(String nome) {
        this.nome = nome;
        this.carrello = new Carrello();
    }

    public String getNome() {
        return nome;
    }

    public Carrello getCarrello() {
        return carrello;
    }
}

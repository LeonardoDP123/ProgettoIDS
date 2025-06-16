public class Acquirente implements EventoObserver {
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


    @Override
    public void notifica(Evento evento) {
        System.out.println(nome + ", nuovo evento disponibile! " + evento.getNome() + " in data " + evento.getData());
    }


}

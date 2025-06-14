public class Produttore extends Venditore {

    public Produttore(String nome) {
        super(nome);
    }

    public Prodotto creaProdotto(int id, String nome, double prezzo, int quantita,
                                 String descrizione, Categoria categoria,
                                 MetodoColtivazione metodo, Certificazione cert) {
        if (!Categoria.isPrimaryCategory(categoria)) {
            throw new IllegalArgumentException("Categoria non valida per un produttore");
        }
        Prodotto p = new Prodotto(id, nome, prezzo, quantita, descrizione, categoria, metodo, cert);
        inventario.add(p);
        return p;
    }
}
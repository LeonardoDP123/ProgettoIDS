public class ProduttoreController {
    private CreazioneService creazioneService;
    private InvioProduttoreService invioProduttoreService;

    public ProduttoreController() {
        this.creazioneService = new CreazioneService();
        this.invioProduttoreService = new InvioProduttoreService();
    }

    public Prodotto creaProdotto(Produttore produttore, int id, String nome, double prezzo, int quantita,
                                 String descrizione, Categoria categoria, MetodoColtivazione metodo, Certificazione certificazione) {

        if (produttore == null) {
            throw new IllegalArgumentException("Produttore non valido.");
        }

        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome del prodotto non valido.");
        }

        if (prezzo <= 0) {
            throw new IllegalArgumentException("Prezzo non valido.");
        }

        if (quantita <= 0) {
            throw new IllegalArgumentException("Quantità non valida.");
        }

        if (!Categoria.isPrimaryCategory(categoria)) {
            throw new IllegalArgumentException("Categoria non consentita per un produttore.");
        }

        return creazioneService.creaProdotto(produttore, id, nome, prezzo, quantita, descrizione, categoria, metodo, certificazione);
    }

    public void inviaAlCuratore(Produttore produttore, int idProdotto, Curatore curatore) {
        if (produttore == null || curatore == null) {
            throw new IllegalArgumentException("Produttore non valido.");
        }
        produttore.getProdottoById(idProdotto);
        invioProduttoreService.inviaAlCuratore(produttore, idProdotto, curatore);

    }

    public void inviaAlDistributore(Produttore produttore, int idProdotto, DistributoreTipicita distributore) {
        if (produttore == null || distributore == null) {
            throw new IllegalArgumentException("Produttore o distributore non validi.");
        }
        produttore.getProdottoById(idProdotto); // controllo esistenza
        invioProduttoreService.inviaAlDistributore(produttore, idProdotto, distributore);
    }

    public void inviaAlTrasformatore(Produttore produttore, int idProdotto, Trasformatore trasformatore) {
        if (produttore == null || trasformatore == null) {
            throw new IllegalArgumentException("Produttore o distributore non validi.");
        }
        produttore.getProdottoById(idProdotto); // controllo esistenza
        invioProduttoreService.inviaAlTrasformatore(produttore, idProdotto, trasformatore);
    }
}
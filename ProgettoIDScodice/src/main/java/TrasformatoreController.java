public class TrasformatoreController {
    private TrasformazioneService trasformazioneService;
    private InvioTrasformatoreService inviotrasformatoreservice;

    public TrasformatoreController() {
        this.trasformazioneService = new TrasformazioneService();
        this.inviotrasformatoreservice = new InvioTrasformatoreService();
    }

    public void trasformaProdotto(Trasformatore trasformatore, Prodotto prodottoDaTrasformare) {
        if (trasformatore == null) {
            throw new IllegalArgumentException("Trasformatore non valido.");
        }

        if (prodottoDaTrasformare == null) {
            throw new IllegalArgumentException("Prodotto da trasformare nullo.");
        }

        boolean trovato = false;
        for (Prodotto p : trasformatore.getInventario()) {
            if (p.getId() == prodottoDaTrasformare.getId()) {
                trovato = true;
                break;
            }
        }

        if (!trovato) {
            throw new IllegalArgumentException("Il prodotto non è presente nell'inventario del trasformatore.");
        }

        if (!Categoria.isPrimaryCategory(prodottoDaTrasformare.getCategoria())) {
            throw new IllegalArgumentException("Il prodotto non appartiene a una categoria primaria.");
        }

        trasformazioneService.trasformaProdotto(trasformatore, prodottoDaTrasformare);
    }

    public void inviaAlCuratore(Trasformatore trasformatore, int idProdotto, Curatore curatore) {
        if (trasformatore == null || curatore == null) {
            throw new IllegalArgumentException("Trasformatore o curatore non validi.");
        }

        trasformatore.getProdottoTrasformatoById(idProdotto);
        inviotrasformatoreservice.inviaAlCuratore(trasformatore, idProdotto, curatore);
    }

    public void inviaAlDistributore(Trasformatore trasformatore, int idProdotto, DistributoreTipicita distributore) {
        if (trasformatore == null || distributore == null) {
            throw new IllegalArgumentException("Trasformatore o distributore non validi.");
        }

        trasformatore.getProdottoTrasformatoById(idProdotto);
        inviotrasformatoreservice.inviaAlDistributore(trasformatore, idProdotto, distributore);
    }
}
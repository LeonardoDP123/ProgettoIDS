public class InvioTrasformatoreService {

    public void inviaAlCuratore(Trasformatore trasformatore, int idProdotto, Curatore curatore) {
        Prodotto prodotto = trasformatore.getProdottoTrasformatoById(idProdotto);
        curatore.aggiungiArticoloDaApprovare(prodotto);
        trasformatore.getInventarioTrasformati().remove(prodotto);
    }

    public void inviaAlDistributore(Trasformatore trasformatore, int idProdotto, DistributoreTipicita distributore) {
        Prodotto p = trasformatore.getProdottoTrasformatoById(idProdotto);
        distributore.aggiungiArticoloPerPacchetto(p);
        trasformatore.getInventarioTrasformati().remove(p);
    }
}
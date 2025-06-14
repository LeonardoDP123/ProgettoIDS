public class InvioProduttoreService {

    public void inviaAlCuratore(Produttore produttore, int idProdotto, Curatore curatore) {
        Prodotto prodotto = produttore.getProdottoById(idProdotto);
        curatore.aggiungiArticoloDaApprovare(prodotto);
        produttore.rimuoviProdottoById(idProdotto);
    }

    public void inviaAlTrasformatore(Produttore produttore, int idProdotto, Trasformatore trasformatore) {
        Prodotto p = produttore.getProdottoById(idProdotto);
        trasformatore.aggiungiArticoloDaTrasformare(p);
        produttore.rimuoviProdottoById(idProdotto);
    }

    public void inviaAlDistributore(Produttore produttore, int idProdotto, DistributoreTipicita distributore) {
        Prodotto p = produttore.getProdottoById(idProdotto);
        distributore.aggiungiArticoloPerPacchetto(p);
        produttore.rimuoviProdottoById(idProdotto);
    }
}

public class InvioDistributoreService {

    public void inviaAlCuratore(DistributoreTipicita distributore, int idPacchetto, Curatore curatore) {
        Pacchetto pacchetto = distributore.getPacchettoById(idPacchetto);
        curatore.aggiungiArticoloDaApprovare(pacchetto);
        distributore.rimuoviPacchetto(pacchetto);
    }
}
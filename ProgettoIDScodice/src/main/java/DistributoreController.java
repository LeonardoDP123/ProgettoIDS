import java.util.List;

public class DistributoreController {

    private ImpacchettamentoService impacchettamentoService;
    private InvioDistributoreService inviodistributoreservice;

    public DistributoreController() {
        this.impacchettamentoService = new ImpacchettamentoService();
        this.inviodistributoreservice = new InvioDistributoreService();
    }

    public Pacchetto creaPacchetto(DistributoreTipicita distributore,
                                   int id,
                                   String nome,
                                   String descrizione,
                                   List<Integer> idProdotti) {
        if (idProdotti == null || idProdotti.size() < 2) {
            throw new IllegalArgumentException("Un pacchetto deve contenere almeno 2 prodotti.");
        }
        return impacchettamentoService.creaPacchetto(distributore, id, nome, descrizione, idProdotti);
    }

    public void inviaAlCuratore(DistributoreTipicita distributore, int idPacchetto, Curatore curatore) {
        distributore.getPacchettoById(idPacchetto); // controllo esistenza
        inviodistributoreservice.inviaAlCuratore(distributore, idPacchetto, curatore);
    }
}
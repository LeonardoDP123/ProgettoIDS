import java.util.*;

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
                                   int... idsProdotti) {

        if (idsProdotti.length < 2) {
            throw new IllegalArgumentException("Un pacchetto deve contenere almeno 2 prodotti diversi");
        }

        List<Integer> idList = new ArrayList<>();
        for (int idProdotto : idsProdotti) {
            idList.add(idProdotto);
        }

        return impacchettamentoService.creaPacchetto(distributore, id, nome, descrizione, idList);
    }


    public void inviaAlCuratore(DistributoreTipicita distributore, int idPacchetto, Curatore curatore) {
        distributore.getPacchettoById(idPacchetto);
        inviodistributoreservice.inviaAlCuratore(distributore, idPacchetto, curatore);
    }
}

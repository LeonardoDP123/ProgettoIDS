import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Setup
        Produttore produttore = new Produttore("Mario");
        Trasformatore trasformatore = new Trasformatore("Luigi");
        DistributoreTipicita distributore = new DistributoreTipicita("Peach");
        Curatore curatore = new Curatore();
        Marketplace marketplace = Marketplace.getInstance();

        // Services e controller
        CreazioneService creazioneService = new CreazioneService();
        ProduttoreController produttoreController = new ProduttoreController();
        TrasformatoreController trasformatoreController = new TrasformatoreController();
        DistributoreController distributoreController = new DistributoreController();

        // Creazione prodotti
        Prodotto p1 = creazioneService.creaProdotto(produttore, 1, "Mela", 1.0, 10, "Mela rossa", Categoria.FRUTTA, MetodoColtivazione.BIO, Certificazione.IGP);
        Prodotto p2 = creazioneService.creaProdotto(produttore, 2, "Latte", 1.5, 5, "Latte fresco", Categoria.LATTE, MetodoColtivazione.BIO, Certificazione.DOP);
        Prodotto p3 = creazioneService.creaProdotto(produttore, 3, "Carne", 3.0, 2, "Carne bovina", Categoria.CARNE, MetodoColtivazione.INTEGRALE, Certificazione.STG);

        // Invia p1 a curatore
        produttoreController.inviaAlCuratore(produttore, 1, curatore);

        // Invia p2 al trasformatore
        produttoreController.inviaAlTrasformatore(produttore, 2, trasformatore);

        // Invia p3 al distributore
        produttoreController.inviaAlDistributore(produttore, 3, distributore);

        // Trasforma p2 (latte in formaggio)
        Prodotto daTrasformare = trasformatore.getInventario().get(0);
        trasformatoreController.trasformaProdotto(trasformatore, daTrasformare);

        // Invia il prodotto trasformato al distributore
        trasformatoreController.inviaAlDistributore(trasformatore, daTrasformare.getId(), distributore);

        // Crea pacchetto con i 2 prodotti ricevuti
        List<Integer> ids = new ArrayList<>();
        for (Prodotto p : distributore.getInventario()) {
            ids.add(p.getId());
        }

        Pacchetto pacchetto = distributoreController.creaPacchetto(distributore, 10, "Delizie Tipiche", "Mix tipico", ids);

        // Invia pacchetto al curatore
        distributoreController.inviaAlCuratore(distributore, 10, curatore);

        // Approvazione articoli
        curatore.approvaArticolo(1);   // mela
        curatore.approvaArticolo(10);  // pacchetto

        // Mostra articoli pubblicati nel marketplace
        System.out.println("Articoli approvati nel marketplace:");
        for (Articolo a : marketplace.getArticoliInVendita()) {
            System.out.println(a);
        }
    }
}
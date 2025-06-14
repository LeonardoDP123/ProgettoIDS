public class Main {
    public static void main(String[] args) {
        // Attori
        Produttore produttore = new Produttore("Mario");
        Trasformatore trasformatore = new Trasformatore("Luigi");
        DistributoreTipicita distributore = new DistributoreTipicita("TipicoBox");
        Curatore curatore = new Curatore();
        Acquirente acquirente1 = new Acquirente("Giulia");
        Acquirente acquirente2 = new Acquirente("Leonardo");

        // Controller
        ProduttoreController produttoreController = new ProduttoreController();
        TrasformatoreController trasformatoreController = new TrasformatoreController();
        DistributoreController distributoreController = new DistributoreController();
        AcquirenteController acquirenteController = new AcquirenteController();

        // Service
        AcquistoService acquistoService = new AcquistoService();

        // 1. Il produttore crea miele, latte e pane
        Prodotto miele = produttoreController.creaProdotto(produttore, 1, "Miele", 6.0, 1,
                "Miele artigianale", Categoria.FRUTTA, MetodoColtivazione.BIO, Certificazione.IGP);

        Prodotto latte = produttoreController.creaProdotto(produttore, 2, "Latte", 2.5, 1,
                "Latte fresco", Categoria.LATTE, MetodoColtivazione.BIO, Certificazione.DOP);

        Prodotto pane = produttoreController.creaProdotto(produttore, 3, "Pane", 2.5, 2,
                "Pane fresco", Categoria.LATTE, MetodoColtivazione.BIO, Certificazione.DOP);

        // 2. Latte → al trasformatore → trasformato in formaggio
        produttoreController.inviaAlTrasformatore(produttore, 2, trasformatore);
        trasformatoreController.trasformaProdotto(trasformatore, trasformatore.getInventario().get(0));
        Prodotto formaggio = trasformatore.getInventarioTrasformati().get(0);

        // 3. Invia miele e formaggio al distributore
        produttoreController.inviaAlDistributore(produttore, 1, distributore);
        trasformatoreController.inviaAlDistributore(trasformatore, formaggio.getId(), distributore);

        // 4. Crea pacchetto con miele + formaggio (quantità 1)
        Pacchetto pacchetto = distributoreController.creaPacchetto(
                distributore,
                100,
                "Box Tipico",
                "Contiene miele e formaggio freschi",
                1, 2
        );

        // 5. Invia pacchetto e pane al curatore e li approva
        distributoreController.inviaAlCuratore(distributore, pacchetto.getId(), curatore);
        curatore.approvaArticolo(pacchetto.getId());

        produttoreController.inviaAlCuratore(produttore, pane.getId(), curatore);
        curatore.approvaArticolo(pane.getId());

        // 6. Acquirenti aggiungono il pacchetto al carrello
        acquistoService.aggiungiAlCarrello(acquirente1, pacchetto.getId(), 1);
        acquistoService.aggiungiAlCarrello(acquirente2, pacchetto.getId(), 1);

        // ✅ Acquirente1 aggiunge anche 1 pane al carrello
        acquistoService.aggiungiAlCarrello(acquirente1, pane.getId(), 1);

        // 7. Stampa carrelli prima degli acquisti
        System.out.println("\n📦 Carrello di " + acquirente1.getNome() + ":");
        System.out.println(acquirente1.getCarrello());

        System.out.println("\n📦 Carrello di " + acquirente2.getNome() + ":");
        System.out.println(acquirente2.getCarrello());

        // 8. Acquirente 1 acquista pacchetto + pane
        System.out.println("\n🛒 Acquirente 1 acquista:");
        acquistoService.acquista(acquirente1);

        // 9. Acquirente 2 prova ad acquistare il pacchetto (non più disponibile)
        System.out.println("\n🛒 Acquirente 2 prova ad acquistare:");
        acquistoService.acquista(acquirente2);

        // 10. Stampa articoli rimasti nel marketplace
        Utils.stampaArticoliInMarketplace();

        // 11. Stampa carrelli finali
        System.out.println("\n📦 Carrello di " + acquirente1.getNome() + ":");
        System.out.println(acquirente1.getCarrello());

        System.out.println("\n📦 Carrello di " + acquirente2.getNome() + ":");
        System.out.println(acquirente2.getCarrello());
    }
}

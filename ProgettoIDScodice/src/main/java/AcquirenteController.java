public class AcquirenteController {
    private AcquistoService acquistoService;

    public AcquirenteController() {
        this.acquistoService = new AcquistoService();
    }

    public void aggiungiAlCarrello(Acquirente acquirente, int idArticolo, int quantita) {
        if (quantita <= 0) {
            System.out.println("Quantità non valida.");
            return;
        }

        try {
            acquistoService.aggiungiAlCarrello(acquirente, idArticolo, quantita);
        } catch (IllegalArgumentException e) {
            System.out.println(" Errore durante aggiunta al carrello: " + e.getMessage());
        }
    }

    public void acquistaCarrello(Acquirente acquirente) {
        try {
            acquistoService.acquista(acquirente);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore durante l'acquisto: " + e.getMessage());
        }
    }
}

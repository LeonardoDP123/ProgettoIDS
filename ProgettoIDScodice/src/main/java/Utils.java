import java.util.List;

public class Utils {

    public static void stampaInventarioProduttore(Produttore produttore) {
        System.out.println("Inventario Produttore " + produttore.getNome() + ":");
        if (produttore.getInventario().isEmpty()) {
            System.out.println("  (Vuoto)");
            return;
        }
        for (Prodotto p : produttore.getInventario()) {
            System.out.println("- ID: " + p.getId() + ", Nome: " + p.getNome() + ", Quantità: " + p.getQuantita());
        }
    }

    public static void stampaInventarioTrasformatorePrimari(Trasformatore t) {
        System.out.println("Prodotti primari nel Trasformatore " + t.getNome() + ":");
        if (t.getInventario().isEmpty()) {
            System.out.println("  (Vuoto)");
            return;
        }
        for (Prodotto p : t.getInventario()) {
            System.out.println("- ID: " + p.getId() + ", Nome: " + p.getNome() + ", Categoria: " + p.getCategoria());
        }
    }

    public static void stampaInventarioTrasformatoreTrasformati(Trasformatore t) {
        System.out.println("Prodotti trasformati nel Trasformatore " + t.getNome() + ":");
        if (t.getInventarioTrasformati().isEmpty()) {
            System.out.println("  (Vuoto)");
            return;
        }
        for (Prodotto p : t.getInventarioTrasformati()) {
            System.out.println("- ID: " + p.getId() + ", Nome: " + p.getNome() + ", Categoria: " + p.getCategoria());
        }
    }

    public static void stampaArticoliDaApprovare(Curatore c) {
        System.out.println("Articoli in attesa dal Curatore:");
        if (c.getArticoliDaApprovare().isEmpty()) {
            System.out.println("  (Vuoto)");
            return;
        }
        for (Articolo a : c.getArticoliDaApprovare()) {
            System.out.println("- ID: " + a.getId() + ", Nome: " + a.getNome());
        }
    }

    public static void stampaArticoliInMarketplace() {
        System.out.println(" Articoli pubblicati nel Marketplace:");
        List<Articolo> articoli = Marketplace.getInstance().getArticoliInVendita();

        if (articoli.isEmpty()) {
            System.out.println("  (Vuoto)");
            return;
        }

        for (Articolo a : articoli) {
            if (a instanceof Prodotto p) {
                System.out.println("- [Prodotto] ID: " + p.getId()
                        + ", Nome: " + p.getNome()
                        + ", Quantità: " + p.getQuantita()
                        + ", Prezzo: €" + p.getPrezzo()
                        + ", Categoria: " + p.getCategoria());
            } else if (a instanceof Pacchetto pacchetto) {
                System.out.println("- [Pacchetto] ID: " + pacchetto.getId()
                        + ", Nome: " + pacchetto.getNome()
                        + ", Quantità: " + pacchetto.getQuantita()
                        + ", Prezzo: €" + pacchetto.getPrezzo()
                        + ", Descrizione: " + pacchetto.getDescrizione()
                        + ", Prodotti inclusi: " + pacchetto.getProdottiInclusi().size());
            } else {
                System.out.println("- [Altro] ID: " + a.getId()
                        + ", Nome: " + a.getNome()
                        + ", Quantità: " + a.getQuantita()
                        + ", Prezzo: €" + a.getPrezzo());
            }
        }
    }

    public static void stampaEventiDaApprovare(Curatore curatore) {
        System.out.println("Eventi in attesa dal Curatore:");
        List<Evento> eventi = curatore.getEventiDaApprovare();
        if (eventi == null || eventi.isEmpty()) {
            System.out.println("  (Vuoto)");
            return;
        }

        for (Evento e : eventi) {
            System.out.println("- ID: " + e.getId()
                    + ", Nome: " + e.getNome()
                    + ", Data: " + e.getData());
        }
    }


    public static void stampaEventiInVetrina() {
        System.out.println("\n--- VETRINA EVENTI LOCALI ---");
        List<Evento> eventi = VetrinaEventiLocali.getInstance().getEventi();

        if (eventi.isEmpty()) {
            System.out.println("Nessun evento disponibile.");
            return;
        }

        for (Evento e : eventi) {
            System.out.println("🧾 " + e.getNome() + " (" + e.getData() + ")");
        }
    }









}

package Entity.Model;

import java.util.List;

public class UtenteGenerico {

    public UtenteGenerico() {
    }

    public void visualizzaArticoli(Marketplace marketplace) {
        List<Articolo> articoli = marketplace.getArticoli();

        if (articoli.isEmpty()) {
            System.out.println("Nessun articolo disponibile nel marketplace.");
            return;
        }

        System.out.println("Articoli disponibili nel marketplace:");
        for (Articolo articolo : articoli) {
            System.out.println(articolo);
        }
    }
}
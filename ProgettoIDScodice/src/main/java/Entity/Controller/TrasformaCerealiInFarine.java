package Entity.Controller;

import Entity.Model.*;

public class TrasformaCerealiInFarine implements StrategiaTrasformazione {
    public Prodotto trasforma(Prodotto prodottoBase, double nuovoPrezzo) {
        if (prodottoBase.getCategoria() != Categoria.CEREALI) {
            System.out.println("Errore: Il prodotto non è un cereale.");
            return null;
        }

        return new Prodotto(
                prodottoBase.getID(),
                "Farina di " + prodottoBase.getNome(),
                "Farina di ottenuta da " + prodottoBase.getNome(),
                nuovoPrezzo,
                Categoria.FARINE,
                prodottoBase.getQuantitaDisponibile(),
                prodottoBase.getMetodoColtivazione(),
                prodottoBase.getCertificazione()
        );
    }
}

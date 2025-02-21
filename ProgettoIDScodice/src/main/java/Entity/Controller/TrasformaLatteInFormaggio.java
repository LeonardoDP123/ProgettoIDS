package Entity.Controller;

import Entity.Model.*;

public class TrasformaLatteInFormaggio implements StrategiaTrasformazione {

    @Override
    public Prodotto trasforma(Prodotto prodottoBase, double nuovoPrezzo) {
        if (prodottoBase.getCategoria() != Categoria.LATTE) {
            System.out.println("Errore: Il prodotto non è latte.");
            return null;
        }

        return new Prodotto(
                prodottoBase.getID(),
                "Formaggio da " + prodottoBase.getNome(),
                "Formaggio stagionato derivato dal " + prodottoBase.getNome(),
                nuovoPrezzo,
                Categoria.FORMAGGI,
                prodottoBase.getQuantitaDisponibile(),
                prodottoBase.getMetodoColtivazione(),
                prodottoBase.getCertificazione()
        );
    }
}

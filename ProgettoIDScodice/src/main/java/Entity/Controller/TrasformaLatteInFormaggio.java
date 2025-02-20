package Entity.Controller;

import Entity.Model.*;

public class TrasformaLatteInFormaggio implements StrategiaTrasformazione {
    @Override
    public boolean puoTrasformare(Prodotto prodotto) {
        return prodotto.getCategoria() == Categoria.LATTICINI;
    }

    @Override
    public Prodotto trasforma(Prodotto prodottoBase, double nuovoPrezzo) {
        return new Prodotto(
                prodottoBase.getID(),
                "Formaggio da " + prodottoBase.getNome(),
                "Formaggio stagionato derivato da " + prodottoBase.getNome(),
                nuovoPrezzo,
                Categoria.FORMAGGI,
                prodottoBase.getQuantitaDisponibile()
        );
    }
}

package Entity.Controller;

import Entity.Model.*;

public class TrasformaFruttaInSucco implements StrategiaTrasformazione {
    @Override
    public boolean puoTrasformare(Prodotto prodotto) {
        return prodotto.getCategoria() == Categoria.FRUTTA;
    }

    @Override
    public Prodotto trasforma(Prodotto prodottoBase, double nuovoPrezzo) {
        return new Prodotto(
                prodottoBase.getID(),
                "Succo di " + prodottoBase.getNome(),
                "Succo ottenuto da " + prodottoBase.getNome(),
                nuovoPrezzo,
                Categoria.BEVANDE,
                prodottoBase.getQuantitaDisponibile()
        );
    }
}

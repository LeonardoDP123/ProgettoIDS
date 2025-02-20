package Entity.Controller;

import Entity.Model.*;

public interface StrategiaTrasformazione {
    boolean puoTrasformare(Prodotto prodotto);
    Prodotto trasforma(Prodotto prodottoBase, double nuovoPrezzo);
}

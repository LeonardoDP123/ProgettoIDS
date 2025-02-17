package Entity.Controller;

import Entity.Model.*;

public interface StrategiaTrasformazione {
    Prodotto trasforma(Prodotto prodottoBase, double nuovoPrezzo);
}
package Entity.Controller;

import Entity.Model.*;

public class TrasformaPesceInAffumicati implements StrategiaTrasformazione {
    @Override
    public Prodotto trasforma(Prodotto prodottoBase, double nuovoPrezzo) {
        if (prodottoBase.getCategoria() != Categoria.PESCE) {
            System.out.println("Errore: Il prodotto non è pesce.");
            return null;
        }

        return new Prodotto(
                prodottoBase.getID(),
                "Trancio di " + prodottoBase.getNome() + " affumicato",
                "Trancio affumicato ottenuto da " + prodottoBase.getNome(),
                nuovoPrezzo,
                Categoria.AFFUMICATI,
                prodottoBase.getQuantitaDisponibile(),
                prodottoBase.getMetodoColtivazione(),
                prodottoBase.getCertificazione()
        );
    }
}

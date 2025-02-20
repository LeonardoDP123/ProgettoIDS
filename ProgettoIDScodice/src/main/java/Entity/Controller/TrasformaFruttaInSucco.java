package Entity.Controller;

import Entity.Model.*;

public class TrasformaFruttaInSucco implements StrategiaTrasformazione {

    @Override
    public Prodotto trasforma(Prodotto prodottoBase, double nuovoPrezzo) {
        if (prodottoBase.getCategoria() != Categoria.FRUTTA) {
            System.out.println("Errore: Il prodotto non è della categoria FRUTTA.");
            return null;
        }

        return new Prodotto(
                prodottoBase.getID(),
                "Succo di " + prodottoBase.getNome(),
                "Succo ottenuto da " + prodottoBase.getNome(),
                nuovoPrezzo,
                Categoria.BEVANDE,
                prodottoBase.getQuantitaDisponibile(),
                prodottoBase.getMetodoColtivazione(),
                prodottoBase.getCertificazione()
        );
    }
}

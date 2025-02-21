package Entity.Controller;

import Entity.Model.*;

public class TrasformaCarneInEssiccati implements StrategiaTrasformazione {
    @Override
    public Prodotto trasforma(Prodotto prodottoBase, double nuovoPrezzo) {
        if (prodottoBase.getCategoria() != Categoria.CARNE) {
            System.out.println("Errore: Il prodotto non è carne.");
            return null;
        }

        return new Prodotto(
                prodottoBase.getID(),
                "Carne di " + prodottoBase.getNome() + " essiccata",
                "Carne essiccata ottenuta da " + prodottoBase.getNome(),
                nuovoPrezzo,
                Categoria.ESSICCATI,
                prodottoBase.getQuantitaDisponibile(),
                prodottoBase.getMetodoColtivazione(),
                prodottoBase.getCertificazione()
        );
    }
}

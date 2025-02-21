package Entity.Controller;

import Entity.Model.*;

public class TrasformaVerduraInSottoOlio implements StrategiaTrasformazione {

    @Override
    public Prodotto trasforma(Prodotto prodottoBase, double nuovoPrezzo) {
        if (prodottoBase.getCategoria() != Categoria.VERDURA) {
            System.out.println("Errore: Il prodotto non è verdura.");
            return null;
        }

        return new Prodotto(
                prodottoBase.getID(),
                prodottoBase.getNome() + " sott'olio",
                "Verdura sott'olio derivata da " + prodottoBase.getNome(),
                nuovoPrezzo,
                Categoria.SOTTO_OLIO,
                prodottoBase.getQuantitaDisponibile(),
                prodottoBase.getMetodoColtivazione(),
                prodottoBase.getCertificazione()
        );
    }
}

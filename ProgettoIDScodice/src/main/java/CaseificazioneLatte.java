public class CaseificazioneLatte implements StrategiaTrasformazione {
    @Override
    public Prodotto trasforma(Prodotto originale) {
        return new Prodotto(
                originale.getId(), "Formaggio di " + originale.getNome(),
                originale.getPrezzo() * 2.7,
                Math.max(1, originale.getQuantita() / 3),
                "Formaggio ottenuto per caseificazione da: " + originale.getDescrizione(),
                Categoria.FORMAGGI,
                originale.getMetodoColtivazione(),
                originale.getCertificazione());
    }
}
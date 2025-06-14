public class MolituraCereali implements StrategiaTrasformazione {
    @Override
    public Prodotto trasforma(Prodotto originale) {
        return new Prodotto(
                originale.getId(),
                "Farina di " + originale.getNome(),
                originale.getPrezzo() * 1.8,
                originale.getQuantita(), //
                "Farina ottenuta per molitura da: " + originale.getDescrizione(),
                Categoria.FARINA,
                originale.getMetodoColtivazione(),
                originale.getCertificazione());
    }
}
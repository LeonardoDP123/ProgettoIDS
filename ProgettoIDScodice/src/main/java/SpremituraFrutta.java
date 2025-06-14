public class SpremituraFrutta implements StrategiaTrasformazione {
    @Override
    public Prodotto trasforma(Prodotto originale) {
        return new Prodotto(
                originale.getId(),
                "Succo di " + originale.getNome(),
                originale.getPrezzo() * 2.2,
                Math.max(1, originale.getQuantita() / 4),
                "Succo ottenuto per spremitura da: " + originale.getDescrizione(),
                Categoria.SUCCO,
                originale.getMetodoColtivazione(),
                originale.getCertificazione());
    }
}
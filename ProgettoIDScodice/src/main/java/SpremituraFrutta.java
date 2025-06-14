public class SpremituraFrutta implements StrategiaTrasformazione {
    @Override
    public Prodotto trasforma(Prodotto originale) {
        return new Prodotto(
                originale.getId(),
                "Succo di " + originale.getNome(),
                originale.getPrezzo() * 2.2, // prezzo moderatamente aumentato
                Math.max(1, originale.getQuantita() / 4), // quantità dimezzata per perdita di polpa
                "Succo ottenuto per spremitura da: " + originale.getDescrizione(),
                Categoria.SUCCO,
                originale.getMetodoColtivazione(),
                originale.getCertificazione());
    }
}
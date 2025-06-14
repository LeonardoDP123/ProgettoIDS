public class EssicazioneCarne implements StrategiaTrasformazione {
    @Override
    public Prodotto trasforma(Prodotto originale) {
        return new Prodotto(
                originale.getId(),
                "Essiccato di " + originale.getNome(),
                originale.getPrezzo() * 2.5,
                originale.getQuantita(),
                "Carne essiccata ottenuta da: " + originale.getDescrizione(),
                Categoria.ESSICATI,
                originale.getMetodoColtivazione(),
                originale.getCertificazione());
    }
}

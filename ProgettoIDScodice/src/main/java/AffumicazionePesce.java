public class AffumicazionePesce implements StrategiaTrasformazione {
    @Override
    public Prodotto trasforma(Prodotto originale) {
        return new Prodotto(
                originale.getId(),
                "Affumicato di " + originale.getNome(),
                originale.getPrezzo() * 2,
                originale.getQuantita(),
                "Pesce affumicato da: " + originale.getDescrizione(),
                Categoria.AFFUMICATI,
                originale.getMetodoColtivazione(),
                originale.getCertificazione());
    }
}
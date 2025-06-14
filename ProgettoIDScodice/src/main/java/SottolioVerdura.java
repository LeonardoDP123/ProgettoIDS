public class SottolioVerdura implements StrategiaTrasformazione {
    @Override
    public Prodotto trasforma(Prodotto originale) {
        return new Prodotto(
                originale.getId(),
                "Verdura sott'olio di " + originale.getNome(),
                originale.getPrezzo() * 2.2,
                originale.getQuantita(),
                "Conserva sott'olio realizzata con: " + originale.getDescrizione(),
                Categoria.SOTTOLIO,
                originale.getMetodoColtivazione(),
                originale.getCertificazione());
    }
}
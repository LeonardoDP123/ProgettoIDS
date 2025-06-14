public class SottolioVerdura implements StrategiaTrasformazione {
    @Override
    public Prodotto trasforma(Prodotto originale) {
        return new Prodotto(
                originale.getId(),
                "Verdura sott'olio di " + originale.getNome(),
                originale.getPrezzo() * 2.2, // incremento per lavorazione e conservazione
                originale.getQuantita(), // quantità invariata
                "Conserva sott'olio realizzata con: " + originale.getDescrizione(),
                Categoria.SOTTOLIO,
                originale.getMetodoColtivazione(),
                originale.getCertificazione());
    }
}
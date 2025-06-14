public class TrasformazioneService {

    public void trasformaProdotto(Trasformatore trasformatore, Prodotto prodotto) {
        StrategiaTrasformazione strategia = switch (prodotto.getCategoria()) {
            case CARNE -> new EssicazioneCarne();
            case LATTE -> new CaseificazioneLatte();
            case PESCE -> new AffumicazionePesce();
            case CEREALI -> new MolituraCereali();
            case FRUTTA -> new SpremituraFrutta();
            case VERDURA -> new SottolioVerdura();
            default -> throw new IllegalArgumentException("Nessuna strategia disponibile per la categoria: " + prodotto.getCategoria());
        };

        trasformatore.trasformaProdotto(prodotto, strategia);
    }
}
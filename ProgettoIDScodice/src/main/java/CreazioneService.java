public class CreazioneService {

    public Prodotto creaProdotto(Produttore produttore,
                                 int id,
                                 String nome,
                                 double prezzo,
                                 int quantita,
                                 String descrizione,
                                 Categoria categoria,
                                 MetodoColtivazione metodo,
                                 Certificazione certificazione) {

        return produttore.creaProdotto(id, nome, prezzo, quantita, descrizione, categoria, metodo, certificazione);
    }
}

package Entity;

import Entity.Model.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Creazione del Marketplace
        Marketplace marketplace = Marketplace.getInstance();

        // Creazione del Curatore
        Curatore curatore = new Curatore(1, "curatore123", "Luca", "Rossi", LocalDate.of(1980, 5, 10), "3331234567", "Via Roma 10");

        // Utilizzo dei Factory per creare i Venditori
        ProduttoreFactory produttoreFactory = new ProduttoreFactory();
        TrasformatoreFactory trasformatoreFactory = new TrasformatoreFactory();
        DistributoreFactory distributoreFactory = new DistributoreFactory();

        // Creazione dei venditori
        Produttore produttore = produttoreFactory.createVenditore(
                2, "produttore1", "Giovanni", "Bianchi",
                LocalDate.of(1985, 3, 20), "3339876543", "Via Milano 5"
        );

        Trasformatore trasformatore = trasformatoreFactory.createVenditore(
                3, "trasformatore1", "Marco", "Verdi",
                LocalDate.of(1980, 6, 15), "3331239999", "Via Napoli 20"
        );

        DistributoreTipicita distributore = distributoreFactory.createVenditore(
                4, "distributore1", "Sara", "Neri",
                LocalDate.of(1990, 7, 25), "3338887777", "Via Torino 30"
        );
        Prodotto latte = produttore.creaProdotto(101, "Latte Fresco", "Latte di alta qualità", 2.50,
                Categoria.LATTE, 50, MetodoColtivazione.BIO, Certificazione.DOP);

        Prodotto mele = produttore.creaProdotto(102, "Mele Rosse", "Mele fresche e succose", 1.50,
                Categoria.FRUTTA, 100, MetodoColtivazione.INTEGRATO, Certificazione.IGP);

        Prodotto carne = produttore.creaProdotto(103, "Bistecca", "Carne bovina di alta qualità", 12.00,
                Categoria.CARNE, 20, MetodoColtivazione.CONVENZIONALE, Certificazione.STG);

        Prodotto prodottoNonValido = produttore.creaProdotto(104, "", "Prodotto senza nome", 5.00,
                Categoria.CEREALI, 0, MetodoColtivazione.CONVENZIONALE, Certificazione.IGP);







    }
}

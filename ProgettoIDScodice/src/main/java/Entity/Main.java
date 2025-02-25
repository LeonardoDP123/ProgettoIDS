package Entity;

import Entity.Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Creazione del Marketplace
        Marketplace marketplace = Marketplace.getInstance();

        // Creazione del Curatore
        Curatore curatore = new Curatore(1, "curatore123", "Luca", "Rossi", LocalDate.of(1980, 5, 10), "3331234567", "Via Roma 10");

        // Creazione dei venditori tramite il Factory Method
        Produttore produttore = (Produttore) Venditore.creaVenditore(
                Ruolo.PRODUTTORE, 2, "produttore1", "Giovanni", "Bianchi",
                LocalDate.of(1985, 3, 20), "3339876543", "Via Milano 5"
        );

        Trasformatore trasformatore = (Trasformatore) Venditore.creaVenditore(
                Ruolo.TRASFORMATORE, 3, "trasformatore1", "Marco", "Verdi",
                LocalDate.of(1980, 6, 15), "3331239999", "Via Napoli 20"
        );

        DistributoreTipicita distributore = (DistributoreTipicita) Venditore.creaVenditore(
                Ruolo.DISTRIBUTORE_TIPICITA, 4, "distributore1", "Sara", "Neri",
                LocalDate.of(1990, 7, 25), "3338887777", "Via Torino 30"
        );

        Prodotto carne = produttore.creaProdotto(103, "Bistecca", "Carne bovina di alta qualità", 12.00,
                Categoria.CARNE, 20, MetodoColtivazione.CONVENZIONALE, Certificazione.STG);

        Prodotto prodottoNonValido = produttore.creaProdotto(104, "", "Prodotto senza nome", 5.00,
                Categoria.CEREALI, 0, MetodoColtivazione.CONVENZIONALE, Certificazione.IGP);

        produttore.inviaArticoliAlCuratore(curatore);
        curatore.approvaArticoli();

        Prodotto latte = produttore.creaProdotto(101, "Latte", "Latte di alta qualità", 2.50,
                Categoria.LATTE, 50, MetodoColtivazione.BIO, Certificazione.DOP);

        Prodotto mele = produttore.creaProdotto(102, "Mele", "Mele fresche e succose", 1.50,
                Categoria.FRUTTA, 100, MetodoColtivazione.INTEGRATO, Certificazione.IGP);

        // Visualizza Marketplace
        System.out.println("\n--- Marketplace (dopo approvazione prodotti del produttore.)");
        produttore.visualizzaArticoli();

        // Invio al Trasformatore e trasformazione
        produttore.inviaProdottoAlTrasformatore(trasformatore, 101); // Latte
        produttore.inviaProdottoAlTrasformatore(trasformatore, 102); // Mele
        trasformatore.trasformaProdotto(101, 4.50); // Latte -> Formaggio
        trasformatore.trasformaProdotto(102, 3.00); // Mele -> Succo
        trasformatore.inviaArticoliAlCuratore(curatore);
        curatore.approvaArticoli();

        System.out.println("\n--- Marketplace (dopo trasformazione prodotti da trasformatore)");
        produttore.visualizzaArticoli();

        Prodotto pomodori = produttore.creaProdotto(106, "Pomodori", "Pomodori freschi biologici", 2.20,
                Categoria.VERDURA, 80, MetodoColtivazione.BIO, Certificazione.DOP);

        Prodotto pesce = produttore.creaProdotto(107, "Orata", "Orata pescata nel Mediterraneo", 15.00,
                Categoria.PESCE, 25, MetodoColtivazione.CONVENZIONALE, Certificazione.DOC);

        Prodotto uva = produttore.creaProdotto(108, "Uva", "Uva fresca", 15.00,
                Categoria.FRUTTA, 25, MetodoColtivazione.BIO, Certificazione.IGP);

        // Il produttore invia i prodotti al distributore
        produttore.inviaProdottoAlDistribuore(distributore, 106);
        produttore.inviaProdottoAlDistribuore(distributore, 107);
        produttore.inviaProdottoAlDistribuore(distributore, 108);

        // Creazione del primo pacchetto e aggiunta dei prodotti
        Pacchetto pacchetto1 = distributore.creaPacchetto(201, "Pacchetto Mare e Terra", "Contiene pesce e verdure fresche", 10);
        distributore.aggiungiProdottoAlPacchetto(pacchetto1, pomodori);
        distributore.aggiungiProdottoAlPacchetto(pacchetto1, pesce);
        distributore.completaPacchetto(pacchetto1, 30.00);

        // Creazione del secondo pacchetto e aggiunta di un solo prodotto
        Pacchetto pacchetto2 = distributore.creaPacchetto(202, "Pacchetto Frutta", "Contiene frutta fresca", 5);
        distributore.aggiungiProdottoAlPacchetto(pacchetto2, uva);

        // Invio dei pacchetti al curatore
        distributore.inviaArticoliAlCuratore(curatore);
        curatore.approvaArticoli();

        System.out.println("\n--- Marketplace (dopo aggiunta del pacchetto)");
        produttore.visualizzaArticoli();

        Acquirente acquirente = new Acquirente(1, "acquirente1", "Mario", "Rossi", LocalDate.of(1990, 1, 1), "3334567890", "Via Milano 15");

        // Aggiungi articoli al carrello
        acquirente.getCarrello().aggiungiArticolo(103, 20);
        acquirente.getCarrello().aggiungiArticolo(201, 9);

        // Effettuare l'acquisto
        acquirente.acquistaCarrello(marketplace);

        // Visualizzare Marketplace dopo l'acquisto
        System.out.println("\n--- Marketplace (dopo l'acquisto):");
        for (Articolo articolo : marketplace.getArticoli()) {
            System.out.println(articolo);
        }

        // Mostrare lo stato finale del carrello
        System.out.println("\n--- Carrello dell'acquirente dopo l'acquisto:");
        acquirente.getCarrello().isEmpty();

        // Connessione DB
        String url = "jdbc:mysql://localhost:3306/progetto_marketplace";
        String user = "root";
        String password = "RootPassword";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione al database riuscita!");

            for (Articolo articolo : marketplace.getArticoli()) {
                String sql = "INSERT INTO prodotto (ID, nome, descrizione, prezzo, quantita_disponibile, stato) VALUES (?, ?, ?, ?, ?, ?) " +
                        "ON DUPLICATE KEY UPDATE nome = VALUES(nome), descrizione = VALUES(descrizione), " +
                        "prezzo = VALUES(prezzo), quantita_disponibile = VALUES(quantita_disponibile), stato = VALUES(stato)";

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, articolo.getID());
                stmt.setString(2, articolo.getNome());
                stmt.setString(3, articolo.getDescrizione());
                stmt.setDouble(4, articolo.getPrezzo());
                stmt.setInt(5, articolo.getQuantitaDisponibile());
                stmt.setBoolean(6, articolo.isStato());

                stmt.executeUpdate();
                stmt.close();

                System.out.println("Inserito/Aggiornato nel DB: " + articolo.getNome());
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
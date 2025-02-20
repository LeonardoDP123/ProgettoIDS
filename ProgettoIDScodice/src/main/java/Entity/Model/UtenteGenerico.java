package Entity.Model;

import Entity.Controller.Ruolo;
import java.time.LocalDate;
import java.util.List;


public class UtenteGenerico extends User {
    public UtenteGenerico(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
                          String numeroDiTelefono, String indirizzo) {
        super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo, Ruolo.UTENTE_GENERICO);
    }


    public void visualizzaArticoli(List<Prodotto> prodotti) {
        for (Prodotto prodotto : prodotti) {
            System.out.println(prodotto);
        }
    }

    @Override
    public void mostraDettagli() {

    }
}
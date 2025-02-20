package Entity.Controller;

import Entity.Model.Produttore;
import Entity.Model.Venditore;
import java.time.LocalDate;

public class ProduttoreFactory implements VenditoreFactory {
    @Override
    public Venditore createVenditore(int ID, String username, String nome, String cognome,
                                     LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
        return createProduttore(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo);
    }

    public Produttore createProduttore(int ID, String username, String nome, String cognome,
                                       LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
        return new Produttore(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo);
    }
}


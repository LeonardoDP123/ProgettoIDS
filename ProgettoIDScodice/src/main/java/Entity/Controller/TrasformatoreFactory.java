package Entity.Controller;

import Entity.Model.Trasformatore;
import Entity.Model.Venditore;
import java.time.LocalDate;

public class TrasformatoreFactory implements VenditoreFactory {
    @Override
    public Venditore createVenditore(int ID, String username, String nome, String cognome,
                                     LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
        return new Trasformatore(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo);
    }
}

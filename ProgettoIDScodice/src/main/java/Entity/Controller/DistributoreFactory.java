package Entity.Controller;

import Entity.Model.DistributoreTipicita;
import Entity.Model.Venditore;
import java.time.LocalDate;

public class DistributoreFactory implements VenditoreFactory {
    @Override
    public Venditore createVenditore(int ID, String username, String nome, String cognome,
                                     LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
        return createDistributore(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo);
    }

    public DistributoreTipicita createDistributore(int ID, String username, String nome, String cognome,
                                                   LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
        return new DistributoreTipicita(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo);
    }
}

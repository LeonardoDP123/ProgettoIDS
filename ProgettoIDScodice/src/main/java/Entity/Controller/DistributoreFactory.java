package Entity.Controller;

import Entity.Model.DistributoreTipicita;

import java.time.LocalDate;

public class DistributoreFactory implements VenditoreFactory {
    @Override
    public DistributoreTipicita createVenditore(int ID, String username, String nome, String cognome,
                                                LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
        return new DistributoreTipicita(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo);
    }
}
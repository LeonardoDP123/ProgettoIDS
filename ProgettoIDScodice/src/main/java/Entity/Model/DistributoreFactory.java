package Entity.Model;

import java.time.LocalDate;

public class DistributoreFactory implements VenditoreFactory {

    @Override
    public Venditore createVenditore(int ID, String username, String nome, String cognome,
                                     LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
        return new DistributoreTipicita(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo);
    }
}

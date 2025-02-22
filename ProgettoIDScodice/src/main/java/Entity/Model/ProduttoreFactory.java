package Entity.Model;

import java.time.LocalDate;

public class ProduttoreFactory implements VenditoreFactory<Produttore> {
    @Override
    public Produttore createVenditore(int ID, String username, String nome, String cognome,
                                      LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
        return new Produttore(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo);
    }
}
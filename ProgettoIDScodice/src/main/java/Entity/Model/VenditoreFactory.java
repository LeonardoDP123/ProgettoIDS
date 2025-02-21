package Entity.Model;


import java.time.LocalDate;

public interface VenditoreFactory {
    Venditore createVenditore(int ID, String username, String nome, String cognome,
                              LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo);
}

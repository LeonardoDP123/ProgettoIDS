package Entity.Model;


import java.time.LocalDate;

public interface VenditoreFactory<T extends Venditore> {
    T createVenditore(int ID, String username, String nome, String cognome,
                      LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo);
}
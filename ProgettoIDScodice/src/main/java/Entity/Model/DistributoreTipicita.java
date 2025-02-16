package Entity.Model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DistributoreTipicita extends Venditore {
    private List<Pacchetto> pacchetti;

    public DistributoreTipicita(int ID, String username, String nome, String cognome,
                                LocalDate dataDiNascita, String numeroDiTelefono, String indirizzo) {
        super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo);
        this.pacchetti = new ArrayList<>();
    }

    public Pacchetto creaPacchetto(int ID, String nome, String descrizione) {
        Pacchetto pacchetto = new Pacchetto(ID, nome, descrizione);
        pacchetti.add(pacchetto);
        return pacchetto;
    }

    public void aggiungiPacchetto(Pacchetto pacchetto) {
        pacchetti.add(pacchetto);
    }

    public void rimuoviPacchetto(Pacchetto pacchetto) {
        pacchetti.remove(pacchetto);
    }

    public List<Pacchetto> getPacchetti() {
        return pacchetti;
    }

    public void mostraPacchetti() {
        if (pacchetti.isEmpty()) {
            System.out.println("Nessun pacchetto disponibile.");
        } else {
            for (Pacchetto p : pacchetti) {
                System.out.println(p);
            }
        }
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Distributore: " + getNome() + " " + getCognome());
        System.out.println("Pacchetti in vendita: " + pacchetti.size());
    }
}

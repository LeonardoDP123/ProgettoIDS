package Entity.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnimatoreFiliera extends UtenteGenerico {
    private List<Evento> eventi;

    public AnimatoreFiliera(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
                            String numeroDiTelefono, String indirizzo) {
        super(ID, username, nome, cognome, dataDiNascita, numeroDiTelefono, indirizzo, Ruolo.ANIMATOREFILIERA);
        this.eventi = new ArrayList<>();
    }

    public Fiera creaFiera(int ID, String nome, LocalDate data, String luogo, String descrizione, int numeroEspositori) {
        Fiera fiera = new Fiera(ID, nome, data, luogo, descrizione, numeroEspositori);
        eventi.add(fiera);
        System.out.println("Fiera organizzata: " + nome);
        return fiera;
    }

    public VisitaGuidata creaVisitaGuidata(int ID, String nome, LocalDate data, String luogo, String descrizione, String guida, int numeroPartecipanti) {
        VisitaGuidata visita = new VisitaGuidata(ID, nome, data, luogo, descrizione, guida, numeroPartecipanti);
        eventi.add(visita);
        System.out.println("Visita guidata organizzata: " + nome);
        return visita;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    public void mostraEventiOrganizzati() {
        if (eventi.isEmpty()) {
            System.out.println("Nessun evento organizzato.");
        } else {
            System.out.println("Eventi organizzati:");
            for (Evento evento : eventi) {
                System.out.println(evento);
            }
        }
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Animatore Filiera: " + getNome() + " " + getCognome() +
                " | Username: " + getUsername());
    }
}
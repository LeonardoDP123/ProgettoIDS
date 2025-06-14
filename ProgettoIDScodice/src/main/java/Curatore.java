import java.util.ArrayList;
import java.util.List;

public class Curatore {
    private List<Articolo> articoliDaApprovare;
    private List<Evento> eventiDaApprovare;
    private List<EventoObserver> osservatoriEventi;

    public Curatore() {
        this.articoliDaApprovare = new ArrayList<>();
        this.eventiDaApprovare = new ArrayList<>();
        this.osservatoriEventi = new ArrayList<>();
    }

    // --- ARTICOLI ---

    public void aggiungiArticoloDaApprovare(Articolo articolo) {
        articoliDaApprovare.add(articolo);
    }

    public List<Articolo> getArticoliDaApprovare() {
        return articoliDaApprovare;
    }

    public void approvaArticolo(int id) {
        for (int i = 0; i < articoliDaApprovare.size(); i++) {
            if (articoliDaApprovare.get(i).getId() == id) {
                Articolo approvato = articoliDaApprovare.remove(i);
                Marketplace.getInstance().pubblicaArticolo(approvato);
                return;
            }
        }
        throw new IllegalArgumentException("Articolo inesistente");
    }

    public void rifiutaArticolo(int id) {
        for (int i = 0; i < articoliDaApprovare.size(); i++) {
            if (articoliDaApprovare.get(i).getId() == id) {
                articoliDaApprovare.remove(i);
                System.out.println("Articolo con ID " + id + " rifiutato e rimosso dalla lista.");
                return;
            }
        }
        throw new IllegalArgumentException("Articolo inesistente");
    }

    // --- EVENTI ---

    public void aggiungiEventoDaApprovare(Evento evento) {
        eventiDaApprovare.add(evento);
    }

    public List<Evento> getEventiDaApprovare() {
        return eventiDaApprovare;
    }

    public void approvaEvento(int id) {
        for (int i = 0; i < eventiDaApprovare.size(); i++) {
            if (eventiDaApprovare.get(i).getId() == id) {
                Evento approvato = eventiDaApprovare.remove(i);
                VetrinaEventiLocali.getInstance().aggiungiEvento(approvato);
                System.out.println("✅ Evento approvato: " + approvato.getNome());
                notificaEventoApprovato(approvato);  // 🔔 NOTIFICA agli osservatori
                return;
            }
        }
        throw new IllegalArgumentException("Evento con ID " + id + " non trovato tra quelli da approvare.");
    }

    public void rifiutaEvento(int id) {
        for (int i = 0; i < eventiDaApprovare.size(); i++) {
            if (eventiDaApprovare.get(i).getId() == id) {
                Evento rifiutato = eventiDaApprovare.remove(i);
                System.out.println("❌ Evento rifiutato: " + rifiutato.getNome());
                return;
            }
        }
        throw new IllegalArgumentException("Evento con ID " + id + " non trovato tra quelli da rifiutare.");
    }

    // --- TO STRING ---

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (articoliDaApprovare.isEmpty()) {
            sb.append("Nessun articolo da approvare.\n");
        } else {
            sb.append("Articoli in attesa di approvazione:\n");
            for (Articolo a : articoliDaApprovare) {
                sb.append("- ID: ").append(a.getId())
                        .append(", Nome: ").append(a.getNome())
                        .append(", Quantità: ").append(a.getQuantita())
                        .append("\n");
            }
        }

        if (eventiDaApprovare.isEmpty()) {
            sb.append("Nessun evento da approvare.\n");
        } else {
            sb.append("Eventi in attesa di approvazione:\n");
            for (Evento e : eventiDaApprovare) {
                sb.append("- ID: ").append(e.getId())
                        .append(", Nome: ").append(e.getNome())
                        .append(" (").append(e.getData()).append("): ")
                        .append(e.getDescrizione()).append("\n");
            }
        }

        return sb.toString();
    }

    // --- OBSERVER ---

    public void aggiungiOsservatoreEvento(EventoObserver o) {
        osservatoriEventi.add(o);
    }

    public void rimuoviOsservatoreEvento(EventoObserver o) {
        osservatoriEventi.remove(o);
    }

    private void notificaEventoApprovato(Evento evento) {
        for (EventoObserver o : osservatoriEventi) {
            o.notifica(evento);
        }
    }
}

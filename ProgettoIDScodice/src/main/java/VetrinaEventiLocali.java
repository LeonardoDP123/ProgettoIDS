import java.util.ArrayList;
import java.util.List;

public class VetrinaEventiLocali {
    private static VetrinaEventiLocali instance;
    private List<Evento> eventi;

    private VetrinaEventiLocali() {
        eventi = new ArrayList<>();
    }

    public static VetrinaEventiLocali getInstance() {
        if (instance == null) {
            instance = new VetrinaEventiLocali();
        }
        return instance;
    }

    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }

    public void rimuoviEvento(Evento evento) {
        eventi.remove(evento);
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    @Override
    public String toString() {
        return "VetrinaEventiLocali{" +
                "eventi=" + eventi +
                '}';
    }
}

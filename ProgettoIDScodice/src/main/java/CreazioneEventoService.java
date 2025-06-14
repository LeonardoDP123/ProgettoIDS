public class CreazioneEventoService {

    public Evento creaEvento(String nome, String descrizione, String data, AnimatoreFiliera animatore, Curatore curatore) {
        Evento evento = new Evento(nome, descrizione, data, animatore);
        curatore.aggiungiEventoDaApprovare(evento);
        return evento;
    }

}

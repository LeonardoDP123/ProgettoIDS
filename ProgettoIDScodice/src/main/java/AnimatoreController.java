public class AnimatoreController {

    private CreazioneEventoService creazioneEventoService;

    public AnimatoreController() {
        this.creazioneEventoService = new CreazioneEventoService();
    }

    public Evento creaEvento(String nome, String descrizione, String data,
                             AnimatoreFiliera animatore, Curatore curatore) {

        if (nome == null || nome.isBlank()) {
            System.out.println(" Il nome dell'evento non può essere vuoto.");
            return null;
        }

        if (descrizione == null || descrizione.isBlank()) {
            System.out.println(" La descrizione dell'evento non può essere vuota.");
            return null;
        }

        if (data == null || data.isBlank()) {
            System.out.println(" La data dell'evento non può essere vuota.");
            return null;
        }

        if (animatore == null || curatore == null) {
            System.out.println(" Animatore o curatore nulli.");
            return null;
        }

        return creazioneEventoService.creaEvento(nome, descrizione, data, animatore, curatore);
    }
}

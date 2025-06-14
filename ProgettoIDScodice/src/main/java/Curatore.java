import java.util.ArrayList;
import java.util.List;

public class Curatore {
    private List<Articolo> articoliDaApprovare;

    public Curatore() {this.articoliDaApprovare = new ArrayList<>();}

    public void aggiungiArticoloDaApprovare(Articolo articolo) {articoliDaApprovare.add(articolo);}

    public List<Articolo> getArticoliDaApprovare() { return articoliDaApprovare;}

    /*Cerca con iterazione tramite ID, l'articolo nel suo inventario per l'approvazione
    Se presente lo rimuove dal suo inventario e lo inserisce come "approvato" nel marketplace
    Altrimenti lancia eccezione
    */
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


    @Override
    public String toString() {
        if (articoliDaApprovare.isEmpty()) {
            return "Nessun articolo da approvare.";
        }

        StringBuilder sb = new StringBuilder("Articoli in attesa di approvazione:\n");
        for (Articolo a : articoliDaApprovare) {
            sb.append("- ID: ").append(a.getId())
                    .append(", Nome: ").append(a.getNome())
                    .append(", Quantità: ").append(a.getQuantita())
                    .append("\n");
        }
        return sb.toString();
    }

}
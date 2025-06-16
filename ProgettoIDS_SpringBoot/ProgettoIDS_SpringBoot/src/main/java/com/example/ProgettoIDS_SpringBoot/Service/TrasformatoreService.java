package com.example.ProgettoIDS_SpringBoot.Service;



import com.example.ProgettoIDS_SpringBoot.Model.*;
import com.example.ProgettoIDS_SpringBoot.Strategy.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrasformatoreService {

    private final List<Prodotto> inventarioPrimari = new ArrayList<>();
    private final List<Prodotto> inventarioTrasformati = new ArrayList<>();

    public void riceviProdotto(Prodotto prodotto) {
        boolean giaRicevuto = inventarioPrimari.stream()
                .anyMatch(p -> p.getId() == prodotto.getId());

        if (giaRicevuto) {
            throw new IllegalArgumentException("Prodotto già ricevuto dal trasformatore");
        }

        inventarioPrimari.add(prodotto);
    }


    public void trasformaProdotto(int idProdotto) {
        Optional<Prodotto> originaleOpt = inventarioPrimari.stream()
                .filter(p -> p.getId() == idProdotto)
                .findFirst();

        if (originaleOpt.isEmpty())
            throw new IllegalArgumentException("Prodotto non presente tra i ricevuti.");

        Prodotto originale = originaleOpt.get();

        StrategiaTrasformazione strategia = switch (originale.getCategoria()) {
            case LATTE -> new CaseificazioneLatte();
            case PESCE -> new AffumicazionePesce();
            case CEREALI -> new MolituraCereali();
            case VERDURA -> new SottolioVerdura();
            case CARNE -> new EssicazioneCarne();
            case FRUTTA -> new SpremituraFrutta();
            default -> throw new IllegalArgumentException("Categoria non trasformabile.");
        };

        Prodotto trasformato = strategia.trasforma(originale);
        inventarioPrimari.remove(originale);
        inventarioTrasformati.add(trasformato);
    }

    public List<Prodotto> getInventarioTrasformati() {
        return inventarioTrasformati;
    }

    public void inviaAlCuratore(int id, CuratoreService curatore) {
        Prodotto p = getTrasformatoById(id);
        curatore.aggiungiArticolo(p);
        inventarioTrasformati.remove(p);
    }

    public void inviaAlDistributore(int id, DistributoreService distributore) {
        Prodotto p = getTrasformatoById(id);
        distributore.riceviProdotto(p);
        inventarioTrasformati.remove(p);
    }

    private Prodotto getTrasformatoById(int id) {
        return inventarioTrasformati.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Prodotto trasformato non trovato."));
    }

    public List<Prodotto> getInventarioPrimari() {
        return inventarioPrimari;
    }
}

package com.example.ProgettoIDS_SpringBoot.Controller;

import com.example.ProgettoIDS_SpringBoot.Model.Pacchetto;
import com.example.ProgettoIDS_SpringBoot.Model.Prodotto;
import com.example.ProgettoIDS_SpringBoot.Service.CuratoreService;
import com.example.ProgettoIDS_SpringBoot.Service.DistributoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/distributore")
public class DistributoreController {

    @Autowired
    private DistributoreService distributoreService;

    @Autowired
    private CuratoreService curatoreService;

    @PostMapping("/ricevi")
    public String ricevi(@RequestBody Prodotto prodotto) {
        distributoreService.riceviProdotto(prodotto);
        return "Prodotto ricevuto dal distributore";
    }

    @PostMapping("/crea-pacchetto")
    public String creaPacchetto(@RequestBody Map<String, Object> body) {
        try {
            int id = (int) body.get("id");
            String nome = (String) body.get("nome");
            String descrizione = (String) body.get("descrizione");

            List<Integer> idsProdotti = (List<Integer>) body.get("prodotti");

            distributoreService.creaPacchetto(id, nome, descrizione, idsProdotti);
            return "Pacchetto creato con successo";

        } catch (Exception e) {
            e.printStackTrace();
            return "Errore durante la creazione del pacchetto: " + e.getMessage();
        }
    }




    @PostMapping("/invia-curatore/{id}")
    public String inviaAlCuratore(@PathVariable int id) {
        distributoreService.inviaPacchettoAlCuratore(id, curatoreService);
        return "Pacchetto inviato al curatore";
    }

    @GetMapping("/magazzino")
    public List<Prodotto> getMagazzino() {
        return distributoreService.getMagazzino();
    }

    @GetMapping("/pacchetti")
    public List<Pacchetto> getPacchettiCreati() {
        return distributoreService.getPacchettiCreati();
    }
}

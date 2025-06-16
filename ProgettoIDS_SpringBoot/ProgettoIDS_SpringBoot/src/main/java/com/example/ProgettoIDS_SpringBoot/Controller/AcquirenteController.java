package com.example.ProgettoIDS_SpringBoot.Controller;

import com.example.ProgettoIDS_SpringBoot.Model.*;
import com.example.ProgettoIDS_SpringBoot.Observer.*;
import com.example.ProgettoIDS_SpringBoot.Service.AcquistoService;
import com.example.ProgettoIDS_SpringBoot.Service.AcquirenteService;
import com.example.ProgettoIDS_SpringBoot.Service.OsservatoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acquirente")
public class AcquirenteController {

    @Autowired
    private AcquistoService acquistoService;

    @Autowired
    private AcquirenteService acquirenteService;

    @Autowired
    private OsservatoriService osservatoriService;

    @PostMapping("/crea")
    public Acquirente creaAcquirente(@RequestBody Acquirente a) {
        return acquirenteService.creaAcquirente(a.getNome());
    }

    @PostMapping("/{nome}/aggiungi-al-carrello")
    public String aggiungiAlCarrello(@PathVariable String nome,
                                     @RequestParam int idArticolo,
                                     @RequestParam int quantita) {
        Acquirente acquirente = acquirenteService.getAcquirente(nome);
        acquistoService.aggiungiAlCarrello(acquirente, idArticolo, quantita);
        return "Articolo aggiunto al carrello";
    }

    @GetMapping("/{nome}/carrello")
    public List<Articolo> visualizzaCarrello(@PathVariable String nome) {
        Acquirente acquirente = acquirenteService.getAcquirente(nome);
        return acquirente.getCarrello().getArticoli();
    }

    @GetMapping("/{nome}/carrello/totale")
    public double totaleCarrello(@PathVariable String nome) {
        Acquirente acquirente = acquirenteService.getAcquirente(nome);
        return acquirente.getCarrello().calcolaTotale();
    }

    @PostMapping("/{nome}/acquista")
    public String acquista(@PathVariable String nome) {
        Acquirente acquirente = acquirenteService.getAcquirente(nome);
        acquistoService.acquistaTutto(acquirente);
        return "Acquisto completato con successo!";
    }

    @PostMapping("/{nome}/svuota-carrello")
    public String svuotaCarrello(@PathVariable String nome) {
        Acquirente acquirente = acquirenteService.getAcquirente(nome);
        acquirente.getCarrello().getArticoli().clear();
        return "Carrello svuotato con successo!";
    }

    @PostMapping("/{nome}/registrati-agli-eventi")
    public String registrati(@PathVariable String nome) {
        Acquirente acquirente = acquirenteService.getAcquirente(nome);
        if (acquirente == null) {
            return "Acquirente con nome " + nome + " non trovato.";
        }

        EventoObserver observer = new AcquirenteObserver(acquirente);
        osservatoriService.registraAcquirente(nome, observer);

        return nome + " registrato per ricevere notifiche sugli eventi.";
    }

}


package com.example.ProgettoIDS_SpringBoot.Controller;

import com.example.ProgettoIDS_SpringBoot.Model.Evento;
import com.example.ProgettoIDS_SpringBoot.Service.CuratoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animatore")
public class AnimatoreController {

    @Autowired
    private CuratoreService curatoreService;

    @PostMapping("/crea-evento")
    public String creaEvento(@RequestBody Evento evento) {
        if (evento.getNome() == null || evento.getNome().isBlank()) return " Nome evento mancante";
        if (evento.getData() == null || evento.getData().isBlank()) return " Data evento mancante";
        if (evento.getAnimatore() == null || evento.getAnimatore().isBlank()) return " Animatore mancante";

        curatoreService.aggiungiEvento(evento);
        return " Evento creato e inviato al curatore per approvazione.";
    }
}

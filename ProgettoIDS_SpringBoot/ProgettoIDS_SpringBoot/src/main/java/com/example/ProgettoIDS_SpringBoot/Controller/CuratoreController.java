package com.example.ProgettoIDS_SpringBoot.Controller;

import com.example.ProgettoIDS_SpringBoot.Model.Articolo;
import com.example.ProgettoIDS_SpringBoot.Model.Evento;
import com.example.ProgettoIDS_SpringBoot.Service.CuratoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curatore")
public class CuratoreController {

    @Autowired
    private CuratoreService curatoreService;

    @PostMapping("/approva/{id}")
    public String approvaArticolo(@PathVariable int id) {
        curatoreService.approvaArticolo(id);
        return "Articolo approvato";
    }

    @GetMapping("/da-approvare")
    public java.util.List<Articolo> daApprovare() {
        return curatoreService.getArticoliDaApprovare();
    }

    @PostMapping("/rifiuta/{id}")
    public String rifiutaArticolo(@PathVariable int id) {
        curatoreService.rifiutaArticolo(id);
        return "Articolo rifiutato";
    }

    @PostMapping("/rifiuta-evento/{id}")
    public String rifiutaEvento(@PathVariable int id) {
        curatoreService.rifiutaEvento(id);
        return "Evento rifiutato con successo.";
    }

    @PostMapping("/approva-evento/{id}")
    public String approvaEvento(@PathVariable int id) {
        curatoreService.approvaEvento(id);
        return "Evento approvato con successo.";
    }

    @GetMapping("/eventi-da-approvare")
    public List<Evento> getEventiDaApprovare() {
        return curatoreService.getEventiDaApprovare();
    }







}

package com.example.ProgettoIDS_SpringBoot.Controller;

import com.example.ProgettoIDS_SpringBoot.Model.Prodotto;
import com.example.ProgettoIDS_SpringBoot.Service.CreazioneService;
import com.example.ProgettoIDS_SpringBoot.Service.CuratoreService;
import com.example.ProgettoIDS_SpringBoot.Service.DistributoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prodotti")
public class ProdottoController {

    @Autowired private CreazioneService creazioneService;
    @Autowired private CuratoreService curatoreService;
    @Autowired
    private DistributoreService distributoreService;


    @PostMapping("/crea")
    public Prodotto creaProdotto(@RequestBody Prodotto prodotto) {
        return creazioneService.creaProdotto(prodotto);
    }

    @PostMapping("/invia-al-curatore/{id}")
    public String inviaAlCuratore(@PathVariable int id) {
        Prodotto prodotto = creazioneService.getById(id);
        curatoreService.aggiungiArticolo(prodotto);
        return "Prodotto inviato al curatore";
    }

    @PostMapping("/invia-distributore/{id}")
    public String inviaAlDistributore(@PathVariable int id) {
        Prodotto p = creazioneService.getById(id);
        distributoreService.riceviProdotto(p);
        return "Prodotto inviato al distributore";
    }




}

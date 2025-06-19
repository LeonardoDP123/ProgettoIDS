package com.example.ProgettoIDS_SpringBoot.Controller;

import com.example.ProgettoIDS_SpringBoot.Model.*;
import com.example.ProgettoIDS_SpringBoot.Service.Marketplace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


import java.util.List;

@RestController
@RequestMapping("/marketplace")
public class MarketplaceController {

    @Autowired
    private Marketplace marketplace;

    @GetMapping("/articoli")
    public List<Articolo> getArticoliInVendita() {
        return marketplace.getArticoliInVendita();
    }

    @GetMapping("/articolo/{id}")
    public Articolo getArticoloById(@PathVariable int id) {
        return marketplace.getArticoloById(id);
    }

    @GetMapping("/articoli-per-categoria")
    public List<Prodotto> getArticoliPerCategoria(@RequestParam Categoria categoria) {
        List<Prodotto> prodottiFiltrati = new ArrayList<>();

        for (Articolo a : marketplace.getArticoliInVendita()) {
            if (a instanceof Prodotto) {
                Prodotto p = (Prodotto) a;
                if (p.getCategoria() == categoria) {
                    prodottiFiltrati.add(p);
                }
            }
        }

        return prodottiFiltrati;
    }

}

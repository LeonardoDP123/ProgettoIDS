package com.example.ProgettoIDS_SpringBoot.Controller;

import com.example.ProgettoIDS_SpringBoot.Model.Articolo;
import com.example.ProgettoIDS_SpringBoot.Service.Marketplace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}

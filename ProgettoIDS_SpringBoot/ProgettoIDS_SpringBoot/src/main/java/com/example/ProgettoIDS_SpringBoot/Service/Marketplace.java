package com.example.ProgettoIDS_SpringBoot.Service;

import com.example.ProgettoIDS_SpringBoot.Model.*;
import com.example.ProgettoIDS_SpringBoot.Repository.PacchettoRepository;
import com.example.ProgettoIDS_SpringBoot.Repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class Marketplace {

    @Autowired
    private ProdottoRepository prodottoRepository;

    private final List<Articolo> articoliInVendita = new ArrayList<>();


    public List<Articolo> getArticoliInVendita() {
        return articoliInVendita.stream()
                .filter(a -> a.getQuantita() > 0)
                .toList();
    }

    public Articolo getArticoloById(int id) {
        return articoliInVendita.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Articolo non trovato"));
    }

    public void rimuoviArticolo(Articolo articolo) {
        articoliInVendita.remove(articolo);
    }

    @Autowired
    private PacchettoRepository pacchettoRepository;

    public void pubblicaArticolo(Articolo articolo) {
        articoliInVendita.add(articolo);

        if (articolo instanceof Prodotto prodotto) {
            prodottoRepository.save(prodotto);
        } else if (articolo instanceof Pacchetto pacchetto) {
            pacchettoRepository.save(pacchetto);
        }
    }




}

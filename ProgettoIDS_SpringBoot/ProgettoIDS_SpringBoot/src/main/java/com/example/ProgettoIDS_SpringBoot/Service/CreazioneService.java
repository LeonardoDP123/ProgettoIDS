package com.example.ProgettoIDS_SpringBoot.Service;

import com.example.ProgettoIDS_SpringBoot.Model.*;
import com.example.ProgettoIDS_SpringBoot.Repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreazioneService {

    @Autowired
    private ProdottoRepository prodottoRepository;

    public Prodotto creaProdotto(Prodotto prodotto) {
        if (prodottoRepository.existsById(prodotto.getId())) {
            throw new IllegalArgumentException("Prodotto con ID già esistente");
        }
        return prodottoRepository.save(prodotto);
    }

    public Prodotto getById(int id) {
        return prodottoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Prodotto non trovato con ID " + id));
    }

}

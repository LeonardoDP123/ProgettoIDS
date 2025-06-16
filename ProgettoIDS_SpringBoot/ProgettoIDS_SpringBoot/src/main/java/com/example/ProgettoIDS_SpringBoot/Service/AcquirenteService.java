package com.example.ProgettoIDS_SpringBoot.Service;

import com.example.ProgettoIDS_SpringBoot.Model.Acquirente;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AcquirenteService {

    private Map<String, Acquirente> acquirenti = new HashMap<>();

    public Acquirente creaAcquirente(String nome) {
        if (acquirenti.containsKey(nome)) {
            throw new IllegalArgumentException("Acquirente già esistente");
        }
        Acquirente nuovo = new Acquirente(nome);
        acquirenti.put(nome, nuovo);
        return nuovo;
    }

    public Acquirente getAcquirente(String nome) {
        return acquirenti.get(nome);
    }
}


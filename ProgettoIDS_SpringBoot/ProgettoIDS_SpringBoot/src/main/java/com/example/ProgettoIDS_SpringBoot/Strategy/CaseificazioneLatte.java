package com.example.ProgettoIDS_SpringBoot.Strategy;

import com.example.ProgettoIDS_SpringBoot.Model.*;

public class CaseificazioneLatte implements StrategiaTrasformazione {
    @Override
    public Prodotto trasforma(Prodotto originale) {
        return new Prodotto(
                originale.getId(),
                "Formaggio di " + originale.getNome(),
                originale.getPrezzo() * 2.7,
                Math.max(1, originale.getQuantita() / 3),
                "Formaggio ottenuto da: " + originale.getDescrizione(),
                Categoria.FORMAGGI,
                originale.getMetodoColtivazione(),
                originale.getCertificazione());
    }
}

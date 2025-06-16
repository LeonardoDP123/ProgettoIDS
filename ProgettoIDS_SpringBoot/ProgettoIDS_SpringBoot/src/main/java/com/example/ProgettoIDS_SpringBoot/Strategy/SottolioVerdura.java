package com.example.ProgettoIDS_SpringBoot.Strategy;

import com.example.ProgettoIDS_SpringBoot.Model.*;

public class SottolioVerdura implements StrategiaTrasformazione {
    @Override
    public Prodotto trasforma(Prodotto originale) {
        return new Prodotto(
                originale.getId(),
                "Verdura sott'olio di " + originale.getNome(),
                originale.getPrezzo() * 2.2,
                originale.getQuantita(),
                "Conserva sott'olio da: " + originale.getDescrizione(),
                Categoria.SOTTOLIO,
                originale.getMetodoColtivazione(),
                originale.getCertificazione());
    }
}

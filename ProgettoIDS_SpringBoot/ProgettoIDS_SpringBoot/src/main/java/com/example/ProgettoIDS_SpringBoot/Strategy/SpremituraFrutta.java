package com.example.ProgettoIDS_SpringBoot.Strategy;

import com.example.ProgettoIDS_SpringBoot.Model.*;

public class SpremituraFrutta implements StrategiaTrasformazione {
    @Override
    public Prodotto trasforma(Prodotto originale) {
        return new Prodotto(
                originale.getId(),
                "Succo di " + originale.getNome(),
                originale.getPrezzo() * 2.2,
                Math.max(1, originale.getQuantita() / 4),
                "Succo ottenuto da: " + originale.getDescrizione(),
                Categoria.SUCCO,
                originale.getMetodoColtivazione(),
                originale.getCertificazione());
    }
}

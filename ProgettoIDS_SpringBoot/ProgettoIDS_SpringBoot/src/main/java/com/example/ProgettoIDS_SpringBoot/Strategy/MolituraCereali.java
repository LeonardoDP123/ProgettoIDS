package com.example.ProgettoIDS_SpringBoot.Strategy;


import com.example.ProgettoIDS_SpringBoot.Model.*;

public class MolituraCereali implements StrategiaTrasformazione {
    @Override
    public Prodotto trasforma(Prodotto originale) {
        return new Prodotto(
                originale.getId(),
                "Farina di " + originale.getNome(),
                originale.getPrezzo() * 1.8,
                originale.getQuantita(),
                "Ottenuto da molitura: " + originale.getDescrizione(),
                Categoria.FARINA,
                originale.getMetodoColtivazione(),
                originale.getCertificazione());
    }
}

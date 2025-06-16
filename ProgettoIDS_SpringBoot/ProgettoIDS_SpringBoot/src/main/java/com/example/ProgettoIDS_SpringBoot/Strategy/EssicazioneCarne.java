package com.example.ProgettoIDS_SpringBoot.Strategy;

import com.example.ProgettoIDS_SpringBoot.Model.*;

public class EssicazioneCarne implements StrategiaTrasformazione {
    @Override
    public Prodotto trasforma(Prodotto originale) {
        return new Prodotto(
                originale.getId(),
                "Essiccato di " + originale.getNome(),
                originale.getPrezzo() * 2.5,
                originale.getQuantita(),
                "Carne essiccata da: " + originale.getDescrizione(),
                Categoria.ESSICATI,
                originale.getMetodoColtivazione(),
                originale.getCertificazione());
    }
}

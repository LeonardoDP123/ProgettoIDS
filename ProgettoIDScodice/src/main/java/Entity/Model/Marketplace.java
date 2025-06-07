package Entity.Model;

import java.util.*;

public class Marketplace {
    private static Marketplace instance;
    private Map<Integer, Articolo> articoliPubblicati = new HashMap<>();
    private Marketplace() {}
    public static Marketplace getInstance() {
        if (instance == null) {
            instance = new Marketplace();
        }
        return instance;
    }

    public String visualizzaArticoli() {
        StringBuilder sb = new StringBuilder();
        for (Articolo a : articoliPubblicati.values()) {
            sb.append(a.toString()).append("\n");
        }
        return sb.toString();
    }

    public String visualizzaArticoliProduttori() {
        StringBuilder sb = new StringBuilder();
        for (Articolo a : articoliPubblicati.values()) {
            if (a instanceof Prodotto) {
                Prodotto p = (Prodotto) a;
                if (p.isCategoriaPrimaria()) {
                    sb.append(p.toString()).append("\n");
                }
            }
        }
        return sb.toString();
    }


    public String visualizzaArticoliTrasformatori() {
        StringBuilder sb = new StringBuilder();
        for (Articolo a : articoliPubblicati.values()) {
            if (a instanceof Prodotto) {
                Prodotto p = (Prodotto) a;
                if (!p.isCategoriaPrimaria()) {
                    sb.append(p.toString()).append("\n");
                }
            }
        }
        return sb.toString();
    }

}
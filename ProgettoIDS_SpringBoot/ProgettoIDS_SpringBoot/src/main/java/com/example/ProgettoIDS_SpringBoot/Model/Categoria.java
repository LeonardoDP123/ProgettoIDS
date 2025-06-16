package com.example.ProgettoIDS_SpringBoot.Model;

public enum Categoria {
    // Categorie primarie
    PESCE,
    VERDURA,
    FRUTTA,
    CEREALI,
    LATTE,
    CARNE,

    // Categorie trasformate
    FORMAGGI,
    FARINA,
    ESSICATI,
    SUCCO,
    SOTTOLIO,
    AFFUMICATI;

    public static boolean isPrimaryCategory(Categoria categoria) {
        return categoria == PESCE ||
                categoria == VERDURA ||
                categoria == FRUTTA ||
                categoria == CEREALI ||
                categoria == LATTE ||
                categoria == CARNE;
    }

}
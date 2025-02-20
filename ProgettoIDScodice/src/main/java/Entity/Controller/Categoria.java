package Entity.Controller;
public enum Categoria {
    // categorie primarie utilizzate sia dal produttore che dal trasformatore
    LATTICINI,
    FRUTTA,
    VERDURA,
    CARNE,
    PESCE,
    CEREALI,

    // categorie utilizzate dal trasformatore
    FORMAGGI,
    BEVANDE,
    SOTTO_OLIO,
    ESSICCATI,
    AFFUMICATI,
    FARINE;

    public static boolean isPrimaryCategory(Categoria categoria) {
        return categoria == LATTICINI || categoria == FRUTTA || categoria == VERDURA
                || categoria == CARNE || categoria == PESCE
                || categoria == CEREALI;
    }

}

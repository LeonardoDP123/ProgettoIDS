package com.example.ProgettoIDS_SpringBoot.Model;

import jakarta.persistence.*;

@Entity
public class Prodotto extends Articolo {

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private MetodoColtivazione metodoColtivazione;

    @Enumerated(EnumType.STRING)
    private Certificazione certificazione;

    public Prodotto() {}

    public Prodotto(int id, String nome, double prezzo, int quantita, String descrizione,
                    Categoria categoria, MetodoColtivazione metodoColtivazione, Certificazione certificazione) {
        super(id, nome, prezzo, quantita);
        this.descrizione = descrizione;
        this.categoria = categoria;
        this.metodoColtivazione = metodoColtivazione;
        this.certificazione = certificazione;
    }

    public String getDescrizione() { return descrizione; }
    public Categoria getCategoria() { return categoria; }
    public MetodoColtivazione getMetodoColtivazione() { return metodoColtivazione; }
    public Certificazione getCertificazione() { return certificazione; }

    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public void setMetodoColtivazione(MetodoColtivazione metodoColtivazione) { this.metodoColtivazione = metodoColtivazione; }
    public void setCertificazione(Certificazione certificazione) { this.certificazione = certificazione; }

    @Override
    public Articolo cloneArticoloConQuantita(int quantita) {
        return new Prodotto(id, nome, prezzo, quantita, descrizione, categoria, metodoColtivazione, certificazione);
    }
}

package com.example.ProgettoIDS_SpringBoot.Service;

import com.example.ProgettoIDS_SpringBoot.Model.*;
import com.example.ProgettoIDS_SpringBoot.Repository.PacchettoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistributoreService {

    private final DistributoreTipicita distributore;

    @Autowired
    private PacchettoRepository pacchettoRepository;

    public DistributoreService() {
        this.distributore = new DistributoreTipicita("Distributore Tipicità");
    }

    public void riceviProdotto(Prodotto p) {
        distributore.riceviProdotto(p);
    }

    public void creaPacchetto(int id, String nome, String descrizione, List<Integer> idsProdotti) {
        List<Prodotto> selezionati = new ArrayList<>();
        for (int idProdotto : idsProdotti) {
            Prodotto trovato = distributore.getMagazzino().stream()
                    .filter(p -> p.getId() == idProdotto)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Prodotto con ID " + idProdotto + " non trovato nel magazzino"));
            selezionati.add(trovato);
        }

        distributore.creaPacchetto(id, nome, descrizione, selezionati);

        Pacchetto pacchettoCreato = distributore.getPacchettoById(id);
        pacchettoRepository.save(pacchettoCreato);
    }

    public List<Prodotto> getMagazzino() {
        return distributore.getMagazzino();
    }

    public List<Pacchetto> getPacchettiCreati() {
        return distributore.getPacchettiCreati();
    }

    public void inviaPacchettoAlCuratore(int idPacchetto, CuratoreService curatoreService) {
        Pacchetto pacchetto = distributore.getPacchettoById(idPacchetto);
        curatoreService.aggiungiArticolo(pacchetto);
        distributore.rimuoviPacchetto(pacchetto);
    }
}

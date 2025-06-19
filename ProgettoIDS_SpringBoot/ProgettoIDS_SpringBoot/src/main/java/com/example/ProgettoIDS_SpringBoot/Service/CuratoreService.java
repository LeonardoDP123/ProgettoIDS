package com.example.ProgettoIDS_SpringBoot.Service;

import com.example.ProgettoIDS_SpringBoot.Model.Articolo;
import com.example.ProgettoIDS_SpringBoot.Model.Evento;
import com.example.ProgettoIDS_SpringBoot.Model.EventoObserver;
import com.example.ProgettoIDS_SpringBoot.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CuratoreService {

    private final List<Articolo> articoliDaApprovare = new ArrayList<>();

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private VetrinaEventiLocali vetrina;

    @Autowired
    private OsservatoriService osservatoriService;

    @Autowired
    private Marketplace marketplace;


    public void aggiungiArticolo(Articolo articolo) {
        for (Articolo a : articoliDaApprovare) {
            if (a.getId() == articolo.getId()) {
                throw new IllegalArgumentException("Articolo già inviato al curatore.");
            }
        }
        articoliDaApprovare.add(articolo);
    }

    public void approvaArticolo(int id) {
        Articolo daApprovare = articoliDaApprovare.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Articolo non trovato."));

        marketplace.pubblicaArticolo(daApprovare);
        articoliDaApprovare.remove(daApprovare);
    }

    public void approvaTuttiGliArticoli() {
        List<Articolo> copiaArticoli = new ArrayList<>(articoliDaApprovare);
        for (Articolo articolo : copiaArticoli) {
            approvaArticolo(articolo.getId());
        }
    }


    public List<Articolo> getArticoliDaApprovare() {
        return articoliDaApprovare;
    }

    public void rifiutaArticolo(int id) {
        Articolo daRifiutare = articoliDaApprovare.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Articolo non trovato."));

        articoliDaApprovare.remove(daRifiutare);
    }


    public void aggiungiEvento(Evento evento) {
        evento.setApprovato(false); // Di default non approvato
        eventoRepository.save(evento);
    }

    public List<Evento> getEventiDaApprovare() {
        return eventoRepository.findAll()
                .stream()
                .filter(e -> !e.isApprovato())
                .toList();
    }

    public void approvaEvento(int id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Evento non trovato"));

        if (evento.isApprovato()) {
            throw new IllegalStateException("L'evento è già stato approvato.");
        }

        evento.setApprovato(true);
        eventoRepository.save(evento);

        System.out.println("Evento approvato: " + evento.getNome());

        notifica(evento);
    }


    public void rifiutaEvento(int id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Evento non trovato"));

        if (evento.isApprovato()) {
            throw new IllegalStateException("L'evento è già stato approvato e non può essere rifiutato.");
        }

        eventoRepository.delete(evento);

        System.out.println("Evento rifiutato: " + evento.getNome());
    }


    private void notifica(Evento evento) {
        for (EventoObserver o : osservatoriService.getOsservatori()) {
            System.out.println("Notificando osservatore: " + o.getClass().getSimpleName()); // Debug
            o.notifica(evento);
        }
    }
}

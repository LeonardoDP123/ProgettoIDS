package com.example.ProgettoIDS_SpringBoot.Service;

import com.example.ProgettoIDS_SpringBoot.Model.Evento;
import com.example.ProgettoIDS_SpringBoot.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetrinaEventiLocali {

    @Autowired
    private EventoRepository eventoRepository;

    public void aggiungiEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    public List<Evento> getEventi() {
        return eventoRepository.findAll();
    }

    public Evento getEventoById(int id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Evento non trovato"));
    }

    public void rimuoviEvento(Evento evento) {
        eventoRepository.delete(evento);
    }

    public void reset() {
        eventoRepository.deleteAll();
    }
}

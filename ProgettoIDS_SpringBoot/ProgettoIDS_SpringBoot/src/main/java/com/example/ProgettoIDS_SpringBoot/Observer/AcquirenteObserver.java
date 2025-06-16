package com.example.ProgettoIDS_SpringBoot.Observer;

import com.example.ProgettoIDS_SpringBoot.Model.Acquirente;
import com.example.ProgettoIDS_SpringBoot.Model.Evento;
import com.example.ProgettoIDS_SpringBoot.Model.EventoObserver;

public class AcquirenteObserver implements EventoObserver {

    private final Acquirente acquirente;

    public AcquirenteObserver(Acquirente acquirente) {
        this.acquirente = acquirente;
    }

    @Override
    public void notifica(Evento evento) {
        System.out.println("🔔 " + acquirente.getNome() + ": nuovo evento disponibile → "
                + evento.getNome() + " in data " + evento.getData());
    }
}

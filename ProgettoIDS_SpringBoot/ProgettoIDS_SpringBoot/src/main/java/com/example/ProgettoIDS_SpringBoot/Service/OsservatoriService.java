package com.example.ProgettoIDS_SpringBoot.Service;

import com.example.ProgettoIDS_SpringBoot.Model.EventoObserver;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OsservatoriService {

    private final List<EventoObserver> osservatori = new ArrayList<>();

    public void registraAcquirente(String nome, EventoObserver observer) {
        if (osservatori.contains(observer)) return;
        osservatori.add(observer);
    }

    public List<EventoObserver> getOsservatori() {
        return osservatori;
    }
}

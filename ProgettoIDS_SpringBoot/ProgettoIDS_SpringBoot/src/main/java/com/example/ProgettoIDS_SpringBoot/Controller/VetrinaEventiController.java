package com.example.ProgettoIDS_SpringBoot.Controller;

import com.example.ProgettoIDS_SpringBoot.Model.Evento;
import com.example.ProgettoIDS_SpringBoot.Service.VetrinaEventiLocali;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vetrina-eventi")
public class VetrinaEventiController {

    @Autowired
    private VetrinaEventiLocali vetrina;

    @GetMapping
    public List<Evento> getEventiInVetrina() {
        return vetrina.getEventi();
    }
}

package com.example.ProgettoIDS_SpringBoot.Controller;


import com.example.ProgettoIDS_SpringBoot.Model.Prodotto;
import com.example.ProgettoIDS_SpringBoot.Service.CuratoreService;
import com.example.ProgettoIDS_SpringBoot.Service.CreazioneService;
import com.example.ProgettoIDS_SpringBoot.Service.DistributoreService;
import com.example.ProgettoIDS_SpringBoot.Service.TrasformatoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/trasformatore")
public class TrasformatoreController {

    @Autowired
    private TrasformatoreService trasformatoreService;

    @Autowired
    private CuratoreService curatoreService;

    @Autowired
    private DistributoreService distributoreService;

    @Autowired
    private CreazioneService creazioneService;

    @PostMapping("/ricevi/{id}")
    public String ricevi(@PathVariable int id) {
        Prodotto prodotto = creazioneService.getById(id);
        trasformatoreService.riceviProdotto(prodotto);
        return "Prodotto ricevuto dal trasformatore";
    }


    @PostMapping("/trasforma")
    public String trasforma(@RequestParam int id) {
        trasformatoreService.trasformaProdotto(id);
        return "Prodotto trasformato";
    }

    @PostMapping("/invia/curatore")
    public String inviaAlCuratore(@RequestParam int id) {
        trasformatoreService.inviaAlCuratore(id, curatoreService);
        return "Prodotto trasformato inviato al curatore";
    }

    @PostMapping("/invia/distributore")
    public String inviaAlDistributore(@RequestParam int id) {
        trasformatoreService.inviaAlDistributore(id, distributoreService);
        return "Prodotto trasformato inviato al distributore";
    }

    @GetMapping("/inventario/primari")
    public List<Prodotto> getPrimari() {
        return trasformatoreService.getInventarioPrimari();
    }

    @GetMapping("/inventario/trasformati")
    public List<Prodotto> getTrasformati() {
        return trasformatoreService.getInventarioTrasformati();
    }




}

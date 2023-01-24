package com.example.demo.controllers;

import com.example.demo.dao.KomitentRepository;
import com.example.demo.dao.KreditRepository;
import com.example.demo.vao.Komitent;
import com.example.demo.vao.Kredit;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/komitenti")
public class KomitentController {

    @Autowired
    private KomitentRepository komitentDao;

    @Autowired
    private KreditRepository kreditDao;

    @GetMapping
    public Iterable<Komitent> vrniOsebe(){
        return komitentDao.findAll();
    }

    @Operation(summary = "Dodajanje novega komitenta.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vrne meritev, OK",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Komitent.class))})
    })
    @PostMapping("/dodajKomitenta")
    public Komitent dodajOsebo(@RequestBody Komitent komitent){
        return komitentDao.save(komitent);
    }

    @PutMapping("/dodajKredit/{id}")
    public Komitent dodajKredit(@PathVariable(name = "id")Long id, @RequestBody Kredit kredit){
        Komitent iskanKomitent = komitentDao.findById(id).orElseThrow();

        Kredit dodanKredit = kreditDao.findById(kredit.getId()).orElseThrow();
        dodanKredit.setKomitent(iskanKomitent);
        kreditDao.save(dodanKredit);

        return komitentDao.save(iskanKomitent);
    }

    @PutMapping("/update/{id}")
    public Komitent posodobiKomitenta(@PathVariable(name = "id")Long id, @RequestBody Komitent komitent){
        Komitent iskanKomitent = komitentDao.findById(id).orElseThrow();

        iskanKomitent.setFirstName(komitent.getFirstName());
        iskanKomitent.setLastName(komitent.getLastName());

        return komitentDao.save(iskanKomitent);
    }

    @DeleteMapping("/delete/{id}")
    public void izbrisiKomitenta(@PathVariable(name = "id")Long id){
        komitentDao.deleteById(id);
    }
}

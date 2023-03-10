package com.example.demo.controllers;

import com.example.demo.dao.KreditRepository;
import com.example.demo.vao.Kredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/krediti")
public class KreditController {

    @Autowired
    private KreditRepository kreditDao;

    @GetMapping
    public Iterable<Kredit> vrniKredite(){
        return kreditDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Kredit> vrniKreditPoId(@PathVariable(name = "id")Long id){
        return kreditDao.findById(id);
    }

    @PostMapping("/add")
    public Kredit dodajKredit(@RequestBody Kredit kredit){
        return kreditDao.save(kredit);
    }

    @DeleteMapping("/delete/{id}")
    public void izbrisiKredit(@PathVariable(name = "id")Long id){
        kreditDao.deleteById(id);
    }
}

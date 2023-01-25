package com.example.demo;

import com.example.demo.dao.KomitentRepository;
import com.example.demo.dao.KreditRepository;
import com.example.demo.vao.Komitent;
import com.example.demo.vao.Kredit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class KomitentRepositoryTest {

    @Autowired
    private KreditRepository kreditDao;

    @Autowired
    private KomitentRepository komitentDao;

    Kredit kredit;

    Komitent komitent;

    Collection<Kredit> krediti;

    @BeforeEach
    void beforeEach(){
        kreditDao.deleteAll();
        komitentDao.deleteAll();
        komitent = komitentDao.save(new Komitent("Janez", "Novak", krediti));
        kredit = kreditDao.save(new Kredit(30000, 70, 800, komitent));
    }

    @Test
    void spremembaKomitentaTest(){
        komitent.setFirstName("Lojze");
        komitentDao.save(komitent);
        assertEquals("Lojze", komitentDao.findById(komitent.getId()).get().getFirstName());
    }
}

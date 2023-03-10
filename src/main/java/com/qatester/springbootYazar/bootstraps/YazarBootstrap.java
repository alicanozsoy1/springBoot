package com.qatester.springbootYazar.bootstraps;

import com.qatester.springbootYazar.beans.Yazar;
import com.qatester.springbootYazar.repositories.YazarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class YazarBootstrap implements CommandLineRunner {

    @Autowired
    YazarRepository yazarRepository;

    @Override
    public void run(String... args) throws Exception {

        Yazar yazar1 = new Yazar();
        yazar1.setYazarAdi("George");
        yazar1.setYazarSoyadi("Orwell");
        yazar1.setDogumTarihi(LocalDate.parse("1903-06-25"));

        yazarRepository.save(yazar1);
        yazarRepository.save(Yazar.builder().yazarAdi("Frank").yazarSoyadi("Herbert").dogumTarihi(LocalDate.parse("1920-10-8")).build());
        yazarRepository.save(new Yazar(0l,"Sabahattin","Ali",LocalDate.parse("1907-02-25")));

    }
}

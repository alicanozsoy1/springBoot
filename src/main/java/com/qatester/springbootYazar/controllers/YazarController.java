package com.qatester.springbootYazar.controllers;

import com.qatester.springbootYazar.beans.Yazar;
import com.qatester.springbootYazar.repositories.YazarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class YazarController {

    @Autowired
    YazarRepository yazarRepository;

    @GetMapping
    public List<Yazar> getAllYazar(){
        return yazarRepository.findAll();
    }

    @GetMapping("/{id}")
    public Yazar getYazarById(@PathVariable Long id){
        return yazarRepository.findById(id).get();
    }

    @PostMapping(consumes = "application/json")
    public List<Yazar> addYazar(@RequestBody Yazar yazar){

       yazarRepository.save(yazar);
       return yazarRepository.findAll();

    }

    @PutMapping(consumes = "application/json")
    public List <Yazar> replaceYazarList(@RequestBody List<Yazar> yazarList){

        yazarRepository.deleteAll();
        yazarRepository.saveAll(yazarList);

        return yazarRepository.findAll();
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public List<Yazar> replaceYazar(@PathVariable Long id, @RequestBody Yazar yazar){
        yazarRepository.deleteById(id);
        yazarRepository.save(yazar);
        return yazarRepository.findAll();
    }

    @PatchMapping(value = "/{id}", consumes = "application/json")
    public List<Yazar> updateYazar(@PathVariable Long id,@RequestBody Yazar yeniYazar){
        Yazar aktifYazar = yazarRepository.findById(id).get();
        aktifYazar.setYazarAdi(yeniYazar.getYazarAdi());
        aktifYazar.setYazarSoyadi(yeniYazar.getYazarSoyadi());
        aktifYazar.setDogumTarihi(yeniYazar.getDogumTarihi());

        yazarRepository.deleteById(id);
        yazarRepository.save(yeniYazar);

        return yazarRepository.findAll();
    }

    @DeleteMapping(value="/{id}")
    public List<Yazar> deleteYazar(@PathVariable Long id){
        yazarRepository.deleteById(id);
        return yazarRepository.findAll();
    }
}

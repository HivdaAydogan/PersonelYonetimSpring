package com.hivda.controller;

import com.hivda.repository.entity.Departman;
import com.hivda.services.DepartmanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Controller katmanında iki kullanım şeklimiz var web için
 * 1- @Controller <nnotaion'ı ile MVC odaklı programlama
 * 2- @RestController annotaion'ı ile Restful web servisler
 */
@RestController
/**
 * https://localhost:9090/departman
 */
@RequestMapping("/departman")
public class DepartmanController {
    private final DepartmanService departmanService;
    public DepartmanController(DepartmanService departmanService){
        this.departmanService = departmanService;
    }
    /**
     * GetMapping --> isteği get türünde olduğunu belirtir. Sadece get isteklerini karşılar.
     * localhost:9090/departman/getAll
     * @return
     */
    @GetMapping("/getAll")  // PostMapping, PutMapping, DeleteMapping, PatchMapping...
    public List<Departman> getAll(){
        return departmanService.findAll();
    }

    /**
     * localhost:9090/departman/save?ad=IT&konum=Istanbul
     * @param ad
     * @param konum
     */
    @GetMapping("/save")
    public void save(String ad, String konum){
        Departman departman = Departman.builder().ad(ad).konum(konum).build();
        departmanService.save(departman);
    }

    /**
     * localhost:9090/departman/delete?id=7
     * @param id
     */
    @GetMapping("/delete")
    public void delete(Long id){
        departmanService.delete(id);
    }

    @GetMapping("/findkonum")
    public List<Departman> findByKonum(String ad){
        return departmanService.findAllKonumAdi(ad);
    }

}

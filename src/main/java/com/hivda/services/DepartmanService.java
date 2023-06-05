package com.hivda.services;

import com.hivda.repository.IDepartmanRepository;
import com.hivda.repository.entity.Departman;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmanService {
    /**
     * Spring'te bir sınıfa ya da interface'e referans atamanın yani new işlemi yaparak bir nesne oluşturmanın
     * iki yolu vardır.
     * 1- @Autowired annotaion'ı ile
     * 2- Constructor injection ile Spring boot context içinde yarattığı nesnelerin referanslarını
     * ihtiyacı olan sınıflara parametre olarak gönderir.
     */
    private IDepartmanRepository repository;

    public DepartmanService(IDepartmanRepository repository){
        this.repository = repository;
    }

    public void save(Departman departman){
        repository.save(departman);
    }

    /**
     * DİKKAT!
     * Güncelleme ve Kaydet işlemleri repository'de save(T entity) şeklinde tanımlıdır.
     * Peki güncellemeyi kayıt etmeden nasıl ayırt ediypruz?
     * Bir ORM aracı kayıtları varlıklarla eşleştirirken ID'yi kullanır. Yani varlık-tabo ilişkisini ID ile kurar.
     * Bu nedenle eğer kayıt ettiğiniz entity içinde id bilgisi null ise save metodu kayıt işlemi yapar.
     * Eğer id bilgisi dolu ise güncelleme işlemi yapar.
     */

    public List<Departman> findAll(){
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


    /**
     * Bir yöneticinin bakmakta olduğu departmanlar nelerdir?
     */

    public List<Departman> findByYoneticiId(Long id){
        return null;
    }

    public List<Departman> findAllKonumAdi(String ad){
        return repository.findAllByKonum(ad);
    }



}

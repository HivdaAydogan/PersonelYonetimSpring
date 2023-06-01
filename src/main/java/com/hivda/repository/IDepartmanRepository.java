package com.hivda.repository;

import com.hivda.repository.entity.Departman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartmanRepository extends JpaRepository<Departman,Long> {

    /**
     * Spring Data Jpa belli keywordler ile sorguları method isimlerine göre otomatik oluşturur.
     * -- Örneğin: yonetici id'sinden yöneticinin bağlı bulunduğu departman listesini bul.
     * ----- Spring Keyword'ler ile sorgu methodu oluşturmak:
     * 1- find ile başlıyoruz.
     * 2- By ile devam ediyoruz. Birkaç yerde değişikliğe uğrayarak arasına değer girebiliyor.
     * 3- Entity içinde var olan bir property adını ekliyoruz.
     * DİKKAT! Burada yazılacak değişken adı mutlaka büyük harf ile başlar ve değişken yazım şekline göre devam eder.
     * 4- Bu method için ek özellikler varsa eklenir.
     * 5- Methodun talep ettiği değer parametre olarak eklenir.
     * 6- Geri dönüş tipi yazılan methodun başına getirilir.
     */

    List<Departman> findByYoneticiid(Long yoneticiid);  // find By Yoneticiid --> yoneticiid => select * from tbldepartman where yoneticiid = ?
    List<Departman> findAllByKonum(String konumadi);

}

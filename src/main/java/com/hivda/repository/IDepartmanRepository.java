package com.hivda.repository;

import com.hivda.repository.entity.Departman;
import com.hivda.repository.view.VwDepartmanList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    /**
     * select * from tbldepartman where ad=?
     * Bu kısımda arama yaparken eğer aynı ad ile kayıt edilmiş birden fazla kayır var ise ilk bulduğu kaydı getirir.
     * @param ad
     * @return
     */

    Departman findByAd(String ad);  // select * from tbldepartman where ad=?
    /**
     * Eğer gerekli olduğunda aranılan bilginin varlığının kontrolü sağlanacak ise, burada gelen bilginin null olması
     * durumunda hata alınacağı için Optional kullanılır.
     * DİKKAT!
     * Burada dikkat etmeniz gereken husus aradığınız bilginin ya hiç olmaması ya da bir tane olması gereklidir. Eğer birden
     * fazla kayıt dönüyorsa hata alırsınız. Bu nedenle optional kullanırken dikkat etmelisiniz.
     */
    Optional<Departman> findOptionalByAd(String ad);

    /**
     * Aradığım kelime departman adı içinde var ise bunların listesini getirsin.
     * select * from tbldepartman where ad like %?%
     * Eğer like kullanıyor iseniz özel karakterleri sizin belirlemeniz gereklidir. %ad, %de%, d__% gibi...
     * NOT --> eğer belli bir kelime dışında kalan kayıtları listelemek istiyorsak unu kullanırız. NotLike
     */
    List<Departman> findByAdLike(String searchKey);
    List<Departman> findByAdNotLike(String searchKey);
    /**
     * Eğer istediğiniz şey tam olarak aradığınız kelimenin property datası içinde geçip geçmediği kontrolü ise
     */
    List<Departman> findByAdContaining(String searchKey);

    /**
     * Aradığınız kelime ile başlayan kayıtları listelemek için
     */
    List<Departman> findByAdStartingWith(String searchKey);  // muh% -> muh ile başlayan kayıtlar

    /**
     * Birden fazla property üzerinden arama yapmak istiyorsak
     * AND key kullanarak işlemlerimizi yürütebiliriz.
     * Birden fazla kriter içinde herhangi birisini sağlayan kayıtları getirmek için OR kullanılır.
     *
     * select * from tbldepartman where yoneticiid=? and konum=?
     * select * from tbldepartman where yoneticiid=? or konum=?
     */
    List<Departman> findAllByYoneticiidAndKonum(Long yoneticiid, String konum);
    List<Departman> findAllByYoneticiidOrKonum(Long yoneticiid, String konum);

    /**
     * select * from tbldepartman where yoneticiid=? or like konum %kk%
     */
    List<Departman> findAllByYoneticiidOrKonumStartingWith(Long yoneticiid,String konum);
    List<Departman> findAllByYoneticiidOrKonumLike(Long yoneticiid,String konum);
    List<Departman> findAllByYoneticiidOrKonumContaining(Long yoneticiid,String konum);

    /**
     * Kayıtları belli bir property'ye göre sıralamak için
     * OrderBy kullanılır.
     * ASC --> küçükten büyüğe (default)
     * DESC --> büyükten küçüğe
     */
    List<Departman> findAllByOrderByKonum();  // a..z
    List<Departman> findAllByOrderByKonumDesc();  // z..a

    /**
     * Belli bir kritere göre kısıtlayıp sonrasında sıralama yapmak
     */
    List<Departman> findAllByKonumOrderByKonum(String konum);

    /**
     * Satış platformu, en çok satan ürünleri listelemek istiyor ve bu ürünlerin
     * en çok satılan 5 ürününü listelemek istiyorsunuz.
     * TOP - LIMIT
     * select * from tblurun order by adet limit 5
     */
    List<Departman> findTop3AllByOrderByKonum();
    List<Departman> findTop50ByKonumContaining(String konum);

    /**
     * Bir kitapçıda en çok satılan kitabı bulmak istiyoruz.
     */
    Departman findTopByOrderByKonum();

    /**
     * Durumunun aktif olduğu kayıtları getirmek ya da true/false olan  alanlara göre listeleme
     * yapmak için kullanılacak metotlar
     */
    List<Departman> findAllByIsactive(Boolean isactive);
    List<Departman> findAllByIsactiveTrue();
    List<Departman> findAllByIsactiveFalse();

    /**
     * Belli bir string alanda arama yaparken kullanıcıların yazım şekillerine
     * çok riayet ettikleri söylenemez yani, bir kişi giriş yapmak için kullanıcı
     * adını girerken; muhammet, Muhammet, MUHAMMET, MuHammEt gibi yazımlar olabilir.
     * Böyle durumlarda arama yaparken sorun yaşarsınız.
     * Yani --> "muhammet".Equals("Muhammet") -> false
     * Doğry yaklaşım --> "muhammet".equalsIgnoreCase("Muhammet) -> true
     */
    List<Departman> findAllByKonumIgnoreCase(String konum);

    /**
     * DİKKAT! PERFORMANS İÇERİR.
     * Örneğin, elinizde uygulamanızda en çok ürün satın alan kişilerin satış işlemlerine
     * ulaşmak istiyorsunuz, fakat bu bilgilere ulaşmak için önce satışları çekmeniz
     * ardından bu kişilerin listesini ayıklamanız gereklidir. Veya join kullanarak
     * tüm tabloları birleştirip arama yapmanız gereklidir. İki durum da yüksek işlem
     * hacmi tüketeceği için sorunludur.
     * Doğru Yöntem;
     * Önce kişiler bulunur ve bu kişilerin id bilgisi bir List<Long> içine atılır,
     * bu liste satış tablosunda sorgulanarak sadece bu kişilere ait satışların listesinin
     * çekilmesi sağlanır ve performans iyileşir.
     * select * from tblssatis where musteriid in (1,2,3,4,5,6,7,8,9,10)
     */
    List<Departman> findAllByYoneticiidIn(List<Long> yoneticiisList);

    /**
     * Günlük challange yapılan bir sistemde aktif olan challengeları listelemek için
     * bulunduğumuz anda bitiş tarihinin büyük olması durumları irdelenir.
     * select * from tblchallenge where enddate > ?
     * Örn; 01.01.2023'den sonra açılan departmanların listesi
     */
    List<Departman> findAllByCreateatGreaterThan(Long time);
    List<Departman> findAllByCreateatLessThan(Long time);

    /**
     * Eğer kontrol ettiğiniz tarihi de kapsamak isterseniz yani > yerine >= kullanmak isterseniz
     * kullanılır
     */
    List<Departman> findAllByCreateatGreaterThanEqual(Long time);
    List<Departman> findAllByCreateatLessThanEqual(Long time);

    /**
     * Eğer belli bir tarih aralığında kayıtları getirmek isterseniz
     */
    List<Departman> findAllByUpdateatBetween(Long start, Long end);  // updateat >= start and updateat <=

    /**
     * İhtiyaç duyduğumuz datalar bazen anahtar kelimelerle elde edilemez. Bu durumlarda özel sorgular
     * yazmak ve bu sorguları çalıştırmak gerekebilir.
     */
    @Query("select d from Departman d where d.ad = ?1")  // select * from tbldepartman where ad = ?
    Departman senBulDepartmaniAdinaGore(String ad);

    @Query("select d from Departman d where d.yoneticiid = ?1 and d.konum = ?2")
    List<Departman> yoneticiVeKonumaGoreBul(Long yoneticiid, String konum);

    @Query(value = "select * from tbldepartman where konum like %?1%", nativeQuery = true)  // NativeQuery'de SQL sorgusunu birebir kullanıyoruz.
    List<Departman> konumaGoreGetir(String konum);                                          // value olarak girip nativeQuery olduğunu belirtmemiz gerek yalnızca

    @Query("select d from Departman d where d.ad = :departmanadi")
    Departman bulParametreIle(@Param("departmanadi") String ad);

    /**
     * DİKKAT! *****'lı kullanım
     */
    @Query("select count(d)>0 from Departman d where d.konum like %?1% and d.ad ilike %?2%")
    Boolean boyleBirKayitVarMiOla(String konum, String ad);

    @Query("select new com.hivda.repository.view.VwDepartmanList(d.id,d.ad) from Departman d")
    List<VwDepartmanList> findAllVwDepartman();















}

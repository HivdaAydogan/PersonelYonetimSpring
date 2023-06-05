package com.hivda.controller;

import com.hivda.constants.RestApiList;
import com.hivda.repository.entity.Personel;
import com.hivda.services.PersonelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.hivda.constants.RestApiList.*;  // Mapping'de çağırırken RestApiList.PERSONEL diye çağırmamız gerekmez böylece.

/**
 * 1- MVC yapısında Controller katmanı @Controller anotasyonu ile işaretlenir.
 * 2- RestAPI yapısında Controller katmanı @RestController anotasyonu ile işaretlenir.
 */

@RestController
/**
 * Path kısmında gelen isteklerin handle edildiği kısımdır. Burada bir URL adresinden gelen isteklerin uygulamamızda
 * nerede yakalanması gerektiği bilgisi iletilir.
 * Bir uygulamanın Root(Kök-Ana) dizini "/" ile ifade edilir. Yani uygulamanız 9090 portunda çalışıyor olsun;
 * Local'de çalıştırıyorsanız: http://localhost:9090/
 * Bir internet adresiniz varsa: http://www.hivda.com/
 * --------
 * http://localhost:9090/personel
 */
@RequestMapping(PERSONEL)
@RequiredArgsConstructor
public class PersonelController {

    private final PersonelService personelService;

    /**
     * Burası son kullanıcının programımız ile iletişime geçtiği kısımdır. Farklı şekillerde iletişim yapılabilir.
     * GET, POST, DELETE vs. gibi...
     * Kullanıcının Request göndermesi.
     * ---> İsteklerin Değerlendirilmesi
     * GET -> Genellikle get istekleri bir sayfanın açılması ya da belli bir datanın talep edilmesi durumlarında geçerlidir.
     * http://localhost:9090/personel/save
     * Eğer istek sizden parametre talep ediyorsa bunların eklenmesi gereklidir.
     * http://localhost:9090/personel/save?ad=Hivda&adres=Ankara&yas=25&telefon=123456789
     * ? parametre girileceğini belirtir.
     * key=value şeklinde parametreler girilir.
     * & ile bir sonraki parametreye geçilir.
     * DİKKAT! Girdiğiniz anahtar kelimeler methodun parametre isimleri ile aynı olmalıdır.
     */
    @GetMapping(SAVE)
    public void savePersonel(String ad, String adres, int yas, String telefon){
        Personel personel = Personel.builder()
                .ad(ad)
                .adres(adres)
                .yas(yas)
                .telefon(telefon)
                .build();
        personelService.save(personel);
    }

    /**
     * POST ---> get ve post ya da diğerleri bir birbirlerinin yerine kullanılabilirler.
     * Ancak önemli olan konu şudur;
     * GET isteklerinde parametreler URL üzerinden gönderilir. Şöyle düşünelim, bir uygulamaya
     * giriş yapmak istiyoruz. Kullanıcı adı ve şifre girmemiz gerekiyor. Bu bilgileri GET ile gönderirsek
     * tüm bilgilerimiz başlık içerisinde iletilir. Örneğin;
     * http://localhost:9090/login?kullaniciAdi=hivda&parola=1234
     * bu işlem oldukça tehlikelidir ve bilgileriniz çalınır.
     * POST işleminde ise işler daha karmaşıktır ve bilgileriniz korunur.
     * GET ile bilgiler header(başlık)'da gider.
     * POST ile bilgiler body(gövde) ile taşınır.
     *
     */

    @PostMapping(SAVE)
    public void savePersonel(String ad, String adres, int yas, String telefon, int type){
        Personel personel = Personel.builder()
                .ad(ad)
                .adres(adres)
                .yas(yas)
                .telefon(telefon)
                .type(type)
                .build();
        personelService.save(personel);
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Personel>> findAll(){
        return ResponseEntity.ok(personelService.findAll());
    }

}

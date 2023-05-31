package com.hivda.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Personel {

    Long id;
    String ad;
    String adres;
    String telefon;
    String photo;
    Integer yas;
    Long giristarihi;
    /**
     * 0: Onaysız Kişi
     * 1: Personel
     * 2:
     * 3:
     */
    Integer type;

}

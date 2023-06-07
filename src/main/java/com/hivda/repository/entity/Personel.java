package com.hivda.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tblpersonel")
public class Personel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String adres;
    String telefon;
    String photo;
    Integer yas;
    String acildurumtelefonu;
    String acildurumkisisi;
    Long giristarihi;
    /**
     * 0: Onaysız Kişi
     * 1: Personel
     * 2: Yönetici
     * 3: Admin
     */
    Integer type;

}

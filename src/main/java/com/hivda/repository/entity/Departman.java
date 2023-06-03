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
@Table(name = "tbldepartman")
public class Departman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    String ad;
    Long yoneticiid;
    String konum;
    Long createat;
    Long updateat;
    /**
     * Kaydın aktif olup olmadığını belirtir.
     * DİKKAT! Veritabanından kayıt silinmez, sadece bu alan true ya da false olur.
     */
    Boolean isactive;


}

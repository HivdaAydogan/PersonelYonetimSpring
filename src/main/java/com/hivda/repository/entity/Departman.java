package com.hivda.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departman {

    Long id;
    String ad;
    Long yoneticiid;
    String konum;

}

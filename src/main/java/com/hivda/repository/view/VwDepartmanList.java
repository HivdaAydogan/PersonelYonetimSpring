package com.hivda.repository.view;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class VwDepartmanList {
    Long id;
    String ad;

    public VwDepartmanList(Long id, String ad){
        this.id = id;
        this.ad = ad;
    }
}

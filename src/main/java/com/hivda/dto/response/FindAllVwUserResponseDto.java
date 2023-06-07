package com.hivda.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FindAllVwUserResponseDto {
    Long id;
    String ad;
    String photo;
    String acildurumkisisi;
}

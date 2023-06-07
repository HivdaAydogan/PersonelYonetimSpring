package com.hivda.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SavePersonelRequestDto {
    String token;
    @NotBlank(message = "Ad alanı boş olamaz")
    @Size(min = 3, max=50) // <script>alert("XSS")</script>
    String ad;
    @NotNull
    String adres;
    @NotNull
    @Email
    String email;
    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$") // a,A,1,*,8karater
    @Size(min = 8, max=64)
    String password;
    String telefon;
    String acildurumtelefonu;
    String acildurumkisisi;
    Long memberdate;
}

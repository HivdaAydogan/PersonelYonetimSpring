package com.hivda.controller;

import com.hivda.dto.request.GetNameUpperCaseRequestDto;
import com.hivda.exceptions.ErrorType;
import com.hivda.exceptions.Java8StartException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personeldepartman")
@RequiredArgsConstructor
public class PersonelDepartmanController {

    @PostMapping("/getname")
    public ResponseEntity<String> getNameUpperCase(@RequestBody GetNameUpperCaseRequestDto dto){
        if (dto.getName()==null)
            throw new Java8StartException(ErrorType.NAME_IS_NULL);
        String nameUpper = dto.getName().toUpperCase();
        return ResponseEntity.ok(nameUpper);
    }











}

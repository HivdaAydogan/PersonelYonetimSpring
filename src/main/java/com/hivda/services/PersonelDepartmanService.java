package com.hivda.services;

import com.hivda.repository.IPersonelDepartmanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonelDepartmanService {
    private final IPersonelDepartmanRepository repository;

}

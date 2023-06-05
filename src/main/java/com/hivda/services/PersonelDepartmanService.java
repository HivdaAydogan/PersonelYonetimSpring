package com.hivda.services;

import com.hivda.repository.IPersonelDepartmanRepository;
import com.hivda.repository.entity.PersonelDepartman;
import com.hivda.utility.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonelDepartmanService extends ServiceManager<PersonelDepartman, Long> {

    private final IPersonelDepartmanRepository repository;
    public PersonelDepartmanService(IPersonelDepartmanRepository repository) {
        super(repository);
        this.repository = repository;
    }
}

package com.hivda.services;

import com.hivda.repository.IPersonelDepartmanRepository;
import com.hivda.repository.IPersonelRepository;
import com.hivda.repository.entity.Personel;
import com.hivda.utility.ServiceManager;
import org.springframework.stereotype.Service;


@Service
public class PersonelService extends ServiceManager<Personel, Long> {

    private final IPersonelRepository repository;
    public PersonelService(IPersonelRepository repository) {
        super(repository);
        this.repository = repository;
    }
}

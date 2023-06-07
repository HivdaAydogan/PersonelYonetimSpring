package com.hivda.services;

import com.hivda.dto.request.SavePersonelRequestDto;
import com.hivda.mapper.IPersonelMapper;
import com.hivda.repository.IPersonelRepository;
import com.hivda.repository.entity.Personel;
import com.hivda.utility.ServiceManager;
import org.springframework.stereotype.Service;


@Service
public class PersonelService extends ServiceManager<Personel,Long> {
    private final IPersonelRepository repository;
    public PersonelService(IPersonelRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Boolean saveFromDto(SavePersonelRequestDto dto){
        Personel personel = IPersonelMapper.INSTANCE.personelFromDto(dto);
        repository.save(personel);
        return true;
    }
}

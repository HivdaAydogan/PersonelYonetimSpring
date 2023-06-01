package com.hivda.services;

import com.hivda.repository.IPersonelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
/**
 * @RequiredArgConstructor nesneyi çağıracak constructor'ı yazmamıza gerek bırakmaz.
 */
public class PersonelService {
    private final IPersonelRepository repository;

}

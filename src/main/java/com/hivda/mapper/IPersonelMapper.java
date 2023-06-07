package com.hivda.mapper;

import com.hivda.dto.request.SavePersonelRequestDto;
import com.hivda.dto.response.FindAllVwUserResponseDto;
import com.hivda.repository.entity.Personel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Bir interface'in mapper işlemi yapabilmesi için @Mapper annotaion'ı kullanılmalıdır.
 * Burada tanımlama yaparken kullanılan componentModel = "spring" ile spring tarafınfan yönetilen
 * bean yapısının entegre edileceğini belirtiyoruz.
 * İkinci önemli kısım ise mapping işleminde kaynak ile hedefin uyuşmayan alanlarının nasıl davranacağını
 * belirtiyoruz. En nihayetinde iki alan birebir birbirine karşılık gelmeyebilir. Bu nedenle uyuşmayan alanlar
 * hata fırlatacaktır. Bu nedenle uyuşmazlıkları ignore ediyoruz. Böylece hata fırlatmadan işlemi gerçekleştirebilir.
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPersonelMapper {

    /**
     * Burası bizim interface'imizden bir nesne yaratılarak referansının atanmasını sağlıyor.
     * Böylece biz de bu nesneyi kullanarak mapping işlemlerini gerçekleştirebiliriz.
     */
    IPersonelMapper INSTANCE = Mappers.getMapper(IPersonelMapper.class);

    /**
     * Artık buradan itibaren gerekli kurumlar bittiğinden dönüşüm için gerekli metot tanımlamaları yapılıyor.
     */
    /**
     * Geri dönüş tipi olarak sınıfı veriyoruz.
     * Metot adını istediğiniz gibi yazabilirsiniz. Amaca hizmet ettiğinin anlaşılması yeter
     * Parametre olarak dto'muzu veriyoruz.
     * [References Data Type] [method name] ([Parametre])
     *        target                           source
     */
    @Mapping(source = "memberdate", target = "giristarihi")
    Personel personelFromDto(final SavePersonelRequestDto dto);

    FindAllVwUserResponseDto personelToDto(final Personel personel);

}

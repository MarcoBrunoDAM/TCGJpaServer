package org.dam19.tcgjpaserver.mappers;

import org.dam19.tcgjpaserver.dto.CartaDto;
import org.dam19.tcgjpaserver.entities.Carta;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CartaMapper {
    Carta toEntity(CartaDto cartaDto);

    CartaDto toDto(Carta carta);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Carta partialUpdate(CartaDto cartaDto, @MappingTarget Carta carta);
}
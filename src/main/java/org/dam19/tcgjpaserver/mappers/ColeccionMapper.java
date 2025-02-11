package org.dam19.tcgjpaserver.mappers;

import org.dam19.tcgjpaserver.dto.ColeccionDto;
import org.dam19.tcgjpaserver.entities.Coleccion;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ColeccionMapper {
    Coleccion toEntity(ColeccionDto coleccionDto);

    ColeccionDto toDto(Coleccion coleccion);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Coleccion partialUpdate(ColeccionDto coleccionDto, @MappingTarget Coleccion coleccion);
}
package org.dam19.tcgjpaserver.mappers;

import org.dam19.tcgjpaserver.dto.DistribuidoreDto;
import org.dam19.tcgjpaserver.entities.Distribuidore;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)public interface DistribuidoreMapper {
    Distribuidore toEntity(DistribuidoreDto distribuidoreDto);

    DistribuidoreDto toDto(Distribuidore distribuidore);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)Distribuidore partialUpdate(DistribuidoreDto distribuidoreDto, @MappingTarget Distribuidore distribuidore);
}
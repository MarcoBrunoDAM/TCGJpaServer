package org.dam19.tcgjpaserver.mappers;

import org.dam19.tcgjpaserver.dto.TipoProductoDto;
import org.dam19.tcgjpaserver.entities.TipoProducto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TipoProductoMapper {
    TipoProducto toEntity(TipoProductoDto tipoProductoDto);

    TipoProductoDto toDto(TipoProducto tipoProducto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TipoProducto partialUpdate(TipoProductoDto tipoProductoDto, @MappingTarget TipoProducto tipoProducto);
}
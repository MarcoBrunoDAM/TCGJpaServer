package org.dam19.tcgjpaserver.mappers;

import org.dam19.tcgjpaserver.dto.ProductoDto;
import org.dam19.tcgjpaserver.entities.Producto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductoMapper {
    Producto toEntity(ProductoDto productoDto);

    ProductoDto toDto(Producto producto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Producto partialUpdate(ProductoDto productoDto, @MappingTarget Producto producto);
}
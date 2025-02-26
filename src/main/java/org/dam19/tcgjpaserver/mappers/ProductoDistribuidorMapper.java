package org.dam19.tcgjpaserver.mappers;

import org.dam19.tcgjpaserver.dto.ProductoDistribuidorDto;
import org.dam19.tcgjpaserver.entities.ProductoDistribuidor;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductoDistribuidorMapper {
    ProductoDistribuidor toEntity(ProductoDistribuidorDto productoDistribuidorDto);

    ProductoDistribuidorDto toDto(ProductoDistribuidor productoDistribuidor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProductoDistribuidor partialUpdate(ProductoDistribuidorDto productoDistribuidorDto, @MappingTarget ProductoDistribuidor productoDistribuidor);
}
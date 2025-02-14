package org.dam19.tcgjpaserver.services;

import org.dam19.tcgjpaserver.dto.ProductoDto;
import org.dam19.tcgjpaserver.entities.Producto;
import org.dam19.tcgjpaserver.mappers.ProductoMapper;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.projections.ProductoInfo;
import org.dam19.tcgjpaserver.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoMapper productoMapper;

    public ResponseModel crearProducto (ProductoDto productoDto) {
        Producto producto = productoMapper.toEntity(productoDto);
        if (productoRepository.save(producto) != null) {
            return new ResponseModel(0,"Producto creado",producto.getId());
        }
        return new ResponseModel(1,"No se pudo crear el producto",null);

    }

    public ResponseModel obtenerProductoPorId(int id) {
        Optional<List<ProductoInfo>> listaProductos =productoRepository.findProductoById(id);
        if(listaProductos.isPresent()) {
            return new ResponseModel(0,"Lista de productos",listaProductos.get());
        }
        return new ResponseModel(1,"No hay lista", null);

    }
    public ResponseModel obtenerListaProductos() {
        Optional<List<ProductoInfo>> listaProductos = productoRepository.findAllBy();
        return new ResponseModel(0,"Lista de productos",listaProductos.get());
    }
}

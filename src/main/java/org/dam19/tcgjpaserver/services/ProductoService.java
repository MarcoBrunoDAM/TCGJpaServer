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

    public ResponseModel crearProducto(ProductoDto productoDto) {
        //Convertimos ProductoDto a una entidad (Producto).
        Producto producto = productoMapper.toEntity(productoDto);
        if (productoRepository.save(producto) != null) {
            return new ResponseModel(0, "Producto creado", producto.getId());
        }
        return new ResponseModel(1, "No se pudo crear el producto", null);

    }

    public ResponseModel obtenerProductoPorId(int id) {
        Optional<List<ProductoInfo>> listaProductos = productoRepository.findProductoById(id);
        //Comprueba si la lista obtenida tiene productos.
        if (listaProductos.isPresent()) {
            return new ResponseModel(0, "Lista de productos", listaProductos.get());
        }
        // Si el programa llega hasta aqui, el programa no ha encontrado ningun producto con dicha id. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.

        return new ResponseModel(1, "No hay lista", null);

    }

    public ResponseModel obtenerListaProductos() {
        Optional<List<ProductoInfo>> listaProductos = productoRepository.findAllBy();
        return new ResponseModel(0, "Lista de productos", listaProductos.get());
    }

    public ResponseModel eliminarProductoPorId(int id) {
        long delete = productoRepository.deleteByIdIs(id);
        if (delete > 0) {
            return new ResponseModel(0, "Se ha eliminado el producto", null);
        }
        return new ResponseModel(1, "No hay lista", null);

    }
    public ResponseModel obtenerProductoByColeccionId(int id){
        Optional<List<ProductoInfo>> listaProductos = productoRepository.findProductoByColeccionId(id);
        //Comprueba si la lista obtenida tiene productos.
        if (listaProductos.isPresent()) {
            return new ResponseModel(0, "Lista de productos", listaProductos.get());
        }
        // Si el programa llega hasta aqui, el programa no ha encontrado ningun producto que tenga dicha coleccion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1, "No hay lista", null);
    }
    public ResponseModel obtenerProductoByTipoProductoId(int id){
        Optional<List<ProductoInfo>> listaProductos = productoRepository.findProductoByTipoProductoId(id);
        //Comprueba si la lista obtenida tiene productos.
        if (listaProductos.isPresent()) {
            return new ResponseModel(0, "Lista de productos", listaProductos.get());
        }
        // Si el programa llega hasta aqui, el programa no ha encontrado ningun producto que tenga dicho formato. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1, "No hay lista", null);
    }

    public ResponseModel obtenerProductoPorIdDistribuidor(int id) {
        Optional<List<ProductoInfo>> listaProductos = productoRepository.findByDistribuidores_Id(id);
        //Comprueba si la lista obtenida tiene productos.
        if (listaProductos.isPresent()) {
            return new ResponseModel(0, "Lista de productos", listaProductos.get());
        }
        // Si el programa llega hasta aqui, el programa no ha encontrado ningun producto de dicho distribuidor. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1, "No hay lista", null);
    }
}
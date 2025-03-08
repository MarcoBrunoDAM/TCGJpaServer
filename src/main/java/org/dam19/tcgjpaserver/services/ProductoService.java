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
    //Este metodo permite crear un producto.
    public ResponseModel crearProducto(ProductoDto productoDto) {
        //Convertimos ProductoDto a una entidad (Producto).
        Producto producto = productoMapper.toEntity(productoDto);
        //Se procede a crear/editar el producto y se comprueba si devuelve un objeto o no (debe devolver el producto creado/editado).
        if (productoRepository.save(producto) != null) {
            // Si el programa llega hasta aquí, el programa ha conseguido crear el producto. Devuelve una respuesta al usuario indicando esto y la id del producto.
            return new ResponseModel(0, "Producto creado", producto.getId());
        }
        // Si el programa llega hasta aquí, el programa no ha conseguido crear el producto. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1, "No se pudo crear el producto", null);

    }
    //Este metodo permite obtener un producto determinado a traves de su id
    public ResponseModel obtenerProductoPorId(int id) {
        Optional<List<ProductoInfo>> listaProductos = productoRepository.findProductoById(id);
        //Comprueba si la lista obtenida tiene productos.
        if (listaProductos.isPresent()) {
            // Si el programa llega hasta aquí, el programa ha encontrado un producto con dicha id. Devuelve una respuesta al usuario indicando esto, además de la lista <<listaProductos>>.
            return new ResponseModel(0, "Lista de productos", listaProductos.get());
        }
        // Si el programa llega hasta aquí, el programa no ha encontrado ningun producto con dicha id. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1, "No hay lista", null);

    }
    //Este metodo permite obtener todos los productos existentes en la BBDD.
    public ResponseModel obtenerListaProductos() {
        //Se guardan todos los productos existentes en la BBDD en la lista <<listaProductos>>, la cual puede estar vacia sin lanzar NullPointerException gracias a la clase <<Optional>>.
        Optional<List<ProductoInfo>> listaProductos = productoRepository.findAllBy();
        // El programa devuelve una respuesta al usuario que incluye la lista de productos.
        return new ResponseModel(0, "Lista de productos", listaProductos.get());
    }
    //Este metodo pemite borrar un producto determinado a traves de su id.
    public ResponseModel eliminarProductoPorId(int id) {
        //Se procede a eliminar el producto y se guarda el numero de registro eliminados en la variable <<delete>>
        long delete = productoRepository.deleteByIdIs(id);
        //Comprueba si la variable <<delete>> es superior a 0, es decir, si se ha eliminado un producto o mas.
        if (delete > 0) {
            // Si el programa llega hasta aquí, el programa ha conseguido eliminar el producto. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return new ResponseModel(0, "Se ha eliminado el producto", null);
        }
        // Si el programa llega hasta aquí, el programa no ha conseguido eliminar el producto. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1, "No hay lista", null);

    }
    //Este metodo permite obtener los productos de una coleccion a traves de su id.
    public ResponseModel obtenerProductoByColeccionId(int id){
        //Se procede a buscar los productos de dicha coleccion con la id de esta y se guarda en la lista <<listaProductos>>, la cual puede estar vacia sin lanzar NullPointerException gracias a la clase <<Optional>>.
        Optional<List<ProductoInfo>> listaProductos = productoRepository.findProductoByColeccionId(id);
        //Comprueba si la lista obtenida tiene productos.
        if (listaProductos.isPresent()) {
            // Si el programa llega hasta aquí, el programa ha encontrado uno o más productos pertenecientes a dicha coleccion. Devuelve una respuesta al usuario indicando esto, además de la lista <<listaProductos>>.
            return new ResponseModel(0, "Lista de productos", listaProductos.get());
        }
        // Si el programa llega hasta aquí, el programa no ha encontrado ningun producto que tenga dicha coleccion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1, "No hay lista", null);
    }
    //Este metodo permite obtener los productos con un formato de producto determinado a traves de su id.
    public ResponseModel obtenerProductoByTipoProductoId(int id){
        //Se procede a buscar los productos con dicho formato de producto con la id de este y se guarda en la lista <<listaProductos>>, la cual puede estar vacia sin lanzar NullPointerException gracias a la clase <<Optional>>.
        Optional<List<ProductoInfo>> listaProductos = productoRepository.findProductoByTipoProductoId(id);
        //Comprueba si la lista obtenida tiene productos.
        if (listaProductos.isPresent()) {
            // Si el programa llega hasta aquí, el programa ha encontrado uno o más productos con dicho formato de producto. Devuelve una respuesta al usuario indicando esto, además de la lista <<listaProductos>>.
            return new ResponseModel(0, "Lista de productos", listaProductos.get());
        }
        // Si el programa llega hasta aquí, el programa no ha encontrado ningun producto que tenga dicho formato. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1, "No hay lista", null);
    }
    //Este metodo obtener todos los productos que tiene un distribuidor a traves de la id de este.
    public ResponseModel obtenerProductoPorIdDistribuidor(int id) {
        //Se procede a buscar los productos de dicho distribuidor con la id de este y se guarda en la lista <<listaProductos>>, la cual puede estar vacia sin lanzar NullPointerException gracias a la clase <<Optional>>.
        Optional<List<ProductoInfo>> listaProductos = productoRepository.findByDistribuidores_Id(id);
        //Comprueba si la lista obtenida tiene productos.
        if (listaProductos.isPresent()) {
            // Si el programa llega hasta aquí, el programa ha encontrado uno o más productos pertenecientes a dicho distribuidor. Devuelve una respuesta al usuario indicando esto, además de la lista <<listaProductos>>.
            return new ResponseModel(0, "Lista de productos", listaProductos.get());
        }
        // Si el programa llega hasta aquí, el programa no ha encontrado ningun producto de dicho distribuidor. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1, "No hay lista", null);
    }
}
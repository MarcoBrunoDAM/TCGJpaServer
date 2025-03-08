package org.dam19.tcgjpaserver.services;

import org.dam19.tcgjpaserver.dto.TipoProductoDto;
import org.dam19.tcgjpaserver.entities.TipoProducto;
import org.dam19.tcgjpaserver.mappers.TipoProductoMapper;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.projections.TipoProductoInfo;
import org.dam19.tcgjpaserver.repositories.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoProductoService {
    @Autowired
    private TipoProductoRepository tipoProductoRepository;
    @Autowired
    private TipoProductoMapper tipoProductoMapper;
    //Este metodo permite crear un formato de producto.
    public ResponseModel crearTipoProducto (TipoProductoDto tipoProductoDto) {
        //Convertimos TipoProductoDto a una entidad (TipoProducto).
        TipoProducto tipoProducto = tipoProductoMapper.toEntity(tipoProductoDto);
        //Se procede a crear/editar el tipo de producto y se comprueba si devuelve un objeto o no (debe devolver el tipo de producto creado/editado).
        if (tipoProductoRepository.save(tipoProducto) != null) {
            // Si el programa llega hasta aquí, el programa ha conseguido crear el tipo de producto. Devuelve una respuesta al usuario indicando esto y la id del tipo de producto.
            return new ResponseModel(0,"Tipo de producto creado",tipoProducto.getId());
        }
        // Si el programa llega hasta aquí, el programa no ha conseguido crear el tipo de producto. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1,"No se pudo crear el tipo producto",null);
    }
    //Este metodo permite obtener un formato de producto determinado a traves de su id.
    public ResponseModel obtenerTipoProductoPorId(int id) {
        //Se procede a buscar el tipo de producto con dicha id y se guarda en la lista <<listaProductos>>, la cual puede estar vacia sin lanzar NullPointerException gracias a la clase <<Optional>>.
        Optional<List<TipoProductoInfo>> listaProductos = tipoProductoRepository.findTipoProductoById(id);
        //Comprueba si la lista obtenida tiene tipos de producto.
        if(listaProductos.isPresent()) {
            // Si el programa llega hasta aquí, el programa ha encontrado un formato de producto con dicha id. Devuelve una respuesta al usuario indicando esto, además de la lista <<listaProductos>>.
            return new ResponseModel(0,"Lista de tipos de productos",listaProductos.get());
        }
        // Si el programa llega hasta aquí, el programa no ha encontrado ningun tipo de producto con dicha id. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1,"No hay lista", null);

    }
    //Este metodo permite obtener todos los tipos de producto existentes en la BBDD.
    public ResponseModel obtenerListaTipoProductos() {
        //Se guardan todos los tipos de productos existentes en la BBDD en la lista <<listaProductos>>, la cual puede estar vacia sin lanzar NullPointerException gracias a la clase <<Optional>>.
        Optional<List<TipoProductoInfo>> listaProductos = tipoProductoRepository.findAllBy();
        // El programa devuelve una respuesta al usuario que incluye la lista de tipos de producto.
        return new ResponseModel(0,"Lista de tipos de producto",listaProductos.get());
    }
    //Este metodo pemite borrar un formato de producto determinado a traves de su id.
    public ResponseModel eliminarTipoProductoPorId(int id) {
        //Se procede a eliminar el tipo de producto y se guarda el numero de registro eliminados en la variable <<delete>>
        long delete = tipoProductoRepository.deleteByIdIs(id);
        //Comprueba si la variable <<delete>> es superior a 0, es decir, si se ha eliminado un tipo de producto o mas.
        if(delete> 0){
            // Si el programa llega hasta aquí, el programa ha conseguido eliminar el tipo de producto. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return new ResponseModel(0,"Se ha eliminado el tipo",null);
        }
        // Si el programa llega hasta aquí, el programa no ha conseguido eliminar el tipo de producto. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1,"No hay lista", null);

    }
}

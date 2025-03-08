package org.dam19.tcgjpaserver.services;


import org.dam19.tcgjpaserver.dto.ColeccionDto;
import org.dam19.tcgjpaserver.entities.Coleccion;
import org.dam19.tcgjpaserver.mappers.ColeccionMapper;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.projections.ColeccionInfo;
import org.dam19.tcgjpaserver.repositories.ColeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColeccionService {
    @Autowired
    private ColeccionRepository coleccionRepository;
    @Autowired
    private ColeccionMapper coleccionMapper;

    //Este metodo permite crear una coleccion.
    public ResponseModel crearColeccion(ColeccionDto coleccionDto) {
        //Convertimos coleccionDto a una entidad (Coleccion).
        Coleccion coleccion = coleccionMapper.toEntity(coleccionDto);
        //Se procede a crear/editar la coleccion y se comprueba si devuelve un objeto o no (debe devolver la coleccion creada/editada).
        if (coleccionRepository.save(coleccion) != null) {
            // Si el programa llega hasta aquí, el programa ha conseguido crear/editar la coleccion. Devuelve una respuesta al usuario indicando esto y la id de la coleccion.
            return new ResponseModel(0,"Coleccion creada",coleccion.getId());
        }
        // Si el programa llega hasta aquí, el programa no ha conseguido crear/editar la coleccion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1,"No se pudo crear la coleccion",null);

    }
    //Este metodo permite obtener una coleccion determinada a traves de su id.
    public ResponseModel obtenerColeccionPorId(int id) {
        //Se procede a buscar la coleccion con dicha id y se guarda en la lista <<listaColecciones>>, la cual puede estar vacia sin lanzar NullPointerException gracias a la clase <<Optional>>.
        Optional<List<ColeccionInfo>> listaColecciones = coleccionRepository.obtenerColeccionPorId(id);
        //Comprueba si la lista obtenida tiene colecciones.
        if(listaColecciones.isPresent()){
            // Si el programa llega hasta aquí, el programa ha encontrado una coleccion con dicha id. Devuelve una respuesta al usuario indicando esto, además de la lista <<listaColecciones>>.
            return new ResponseModel(0,"Lista de colecciones",listaColecciones.get());
        }
        // Si el programa llega hasta aquí, el programa no ha encontrado ninguna coleccion con dicha id. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1,"No hay lista", null);

    }
    //Este metodo permite obtener todas las colecciones existentes en la BBDD.
    public ResponseModel obtenerListaColecciones() {
        //Se guardan todos las colecciones existentes en la BBDD en la lista <<listaColecciones>>, la cual puede estar vacia sin lanzar NullPointerException gracias a la clase <<Optional>>.
        Optional<List<ColeccionInfo>> listaColecciones = coleccionRepository.findAllBy();
        // El programa devuelve una respuesta al usuario que incluye la lista de colecciones.
        return new ResponseModel(0,"Lista de colecciones", listaColecciones);

    }
    //Este metodo pemite borrar una coleccion determinada a traves de su id.
    public ResponseModel eliminarColeccionPorId(int id) {
        //Se procede a eliminar la coleccion y se guarda el numero de registro eliminados en la variable <<delete>>
        long delete = coleccionRepository.deleteByIdIs(id);
        //Comprueba si la variable <<delete>> es superior a 0, es decir, si se ha eliminado una coleccion o mas.
        if(delete > 0){
            // Si el programa llega hasta aquí, el programa ha conseguido eliminar la coleccion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return new ResponseModel(0,"Se ha eliminado la coleccion",null);
        }
        // Si el programa llega hasta aquí, el programa no ha conseguido eliminar la coleccion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1,"No hay lista", null);

    }
    //Este metodo permite obtener una coleccion determinada a traves de su nombre.
    public ResponseModel obtenerColeccionPorNombre(String nombre) {
        ColeccionInfo coleccion = coleccionRepository.findByNombreIs(nombre);
        //Comprueba si la lista obtenida tiene colecciones.
        if(coleccion != null){
            // Si el programa llega hasta aquí, el programa ha encontrado una coleccion con dicho nombre. Devuelve una respuesta al usuario indicando esto, además de indicar su id.
            return new ResponseModel(0,"Lista de colecciones",coleccion.getId());
        }
        // Si el programa llega hasta aquí, el programa no ha encontrado ninguna coleccion con dicho nombre. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1,"No hay lista", null);

    }
}
